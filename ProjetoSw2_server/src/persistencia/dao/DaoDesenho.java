/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.dao;

import persistencia.Conexao;
import persistencia.dao.entidade.Desenho;
import utils.Uteis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author admin
 */
public class DaoDesenho extends Conexao {
    public static int last_genKey = 0;

    public DaoDesenho(Connection c) {
        this.conexao = c;
    }

    public boolean atualizarDesenho(Desenho d) {
        try {
            conexao.setAutoCommit( false );

            String sql =
                    "UPDATE desenho SET " +
                        "nome = ?, update_date = CURRENT_TIMESTAMP()  " +
                    "WHERE id = " + d.getId();

            PreparedStatement ps= conexao.prepareStatement( sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,d.getNome());
            ps.execute();
            ps.close();

            conexao.commit();

            //deleta formas velhas
            if (! new DaoForma(conexao).excluirFormas_idDesenho( d.getId() )){
                return false;
            }

            //insere formas
            if (new DaoForma(conexao).inserirFormas(d.getId(), d.getListaFormas())){
                conexao.setAutoCommit( true );
                return true;
            }else {
                conexao.setAutoCommit( true );
                info = DaoForma.info;
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            info = e.getMessage();
            try{
                conexao.setAutoCommit( true );
                conexao.rollback();
            }catch (SQLException sqle){
                sqle.printStackTrace();
                info += ", " + sqle.getMessage();
            }
            return false;
        }

    }

    public boolean inserirDesenho(Desenho d ){
        try {
            conexao.setAutoCommit( false );

            String sql =
                    "INSERT INTO desenho " +
                    "(nome, create_date , update_date) " +
                    "VALUES " +
                    "(?, CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP() );" ;

            PreparedStatement ps= conexao.prepareStatement( sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,d.getNome());
            ps.execute();

            //p/ id gerado
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                last_genKey = rs.getInt(1);
            }
            ps.close();
            rs.close();

            conexao.commit();

            //insere formas
            if (new DaoForma(conexao).inserirFormas(last_genKey, d.getListaFormas())){
                conexao.setAutoCommit( true );
                return true;
            }else {
                conexao.setAutoCommit( true );
                info = DaoForma.info;
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            info = e.getMessage();
            try{
                conexao.rollback();
                conexao.setAutoCommit( true );
            }catch (SQLException sqle){
                sqle.printStackTrace();
                info += ", " + sqle.getMessage();
            }
            return false;
        }
    }

    public List<Desenho> consultaTodos() {
        List<Desenho> lista = new ArrayList<>();
        Desenho d;
        String sql = "SELECT * FROM desenho" ;

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                d = new Desenho();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));
                d.setCreate_date(Uteis.ts2Date( rs.getString("create_date") ));
                d.setUpdate_date(Uteis.ts2Date( rs.getString("update_date") ));

                d.setListaFormas( new DaoForma(conexao).consultarPorDesenho_id( d.getId() ) );

                lista.add(d);
            }
            stmt.close();
            rs.close();
            return lista;
        } catch (SQLException E) {
            System.out.println("Erro ao consultar Entradas");
            E.printStackTrace();
            return null;
        }
    }

    public Desenho consultaId(int desenho_id) {
        Desenho d;
        String sql = "SELECT * FROM desenho WHERE id = " + desenho_id ;

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                d = new Desenho();
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));
                d.setCreate_date(Uteis.ts2Date( rs.getString("create_date") ));
                d.setUpdate_date(Uteis.ts2Date( rs.getString("update_date") ));

                d.setListaFormas( new DaoForma(conexao).consultarPorDesenho_id( d.getId() ) );

                return d;
            }
            stmt.close();
            rs.close();
            return null;
        } catch (SQLException E) {
            System.out.println("Erro ao consultar Entradas");
            E.printStackTrace();
            return null;
        }
    }

    public boolean excluirDesenho_id(int id) {
        try {
            String sql_formas = "DELETE FROM desenho WHERE id = " + id;
            Statement stmt = conexao.createStatement();
            stmt.execute(sql_formas);
            stmt.close();

            return true;
        } catch (SQLException E) {
            E.printStackTrace();
            return false;
        }

    }


}
