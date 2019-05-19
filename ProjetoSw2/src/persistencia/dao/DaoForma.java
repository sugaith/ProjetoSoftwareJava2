package persistencia.dao;

import persistencia.Conexao;
import persistencia.dao.entidade.Forma;
import utils.Uteis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoForma extends Conexao {

    public DaoForma(Connection c) {
        this.conexao = c;
    }

    public boolean inserirFormas (int desenho_id, List<Forma> listaForma){
        try {
            if (listaForma.isEmpty())
                return true;

            conexao.setAutoCommit( false );

            String sql =
                    "INSERT INTO forma " +
                            "(desenho_id, nome, pontos, create_date , update_date) " +
                            "VALUES ";
            for (Forma f : listaForma){
                sql += "('"+desenho_id+"' ,'"+f.getNome()+"', " +
                        "'"+f.getPontos()+"', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP() ),";
            }
            sql = sql.substring(0, sql.length()-1);//tira ultima virgula

            PreparedStatement ps= conexao.prepareStatement( sql);
            ps.execute();
            ps.close();

            conexao.commit();
            return true;
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

    public List<Forma> consultarPorDesenho_id(int desenho_id) {
        List<Forma> listaFormas = new ArrayList<>();
        Forma f;
        try {
            String sql_formas = "SELECT * FROM forma WHERE desenho_id = " + desenho_id;
            Statement stmt = conexao.createStatement();

            ResultSet rs2 = stmt.executeQuery(sql_formas);
            while (rs2.next()) {
                f = new Forma();
                f.setId(rs2.getInt("id"));
                f.setNome(rs2.getString("nome"));
                f.setPontos(rs2.getString("pontos"));
                f.setCreate_date(Uteis.ts2Date( rs2.getString("create_date") ));
                f.setUpdate_date(Uteis.ts2Date( rs2.getString("update_date") ));
                f.setDesenho_id( desenho_id );

                listaFormas.add(f);
            }

            stmt.close();
            rs2.close();
            return listaFormas;
        } catch (SQLException E) {
            System.out.println("Erro ao consultar Entradas");
            E.printStackTrace();
            return null;
        }
    }


    public boolean excluirFormas_idDesenho(int id) {
        try {
            String sql_formas = "DELETE FROM forma WHERE desenho_id = " + id;
            Statement stmt = conexao.createStatement();
            stmt.close();

            return true;
        } catch (SQLException E) {
            E.printStackTrace();
            return false;
        }

    }
}
