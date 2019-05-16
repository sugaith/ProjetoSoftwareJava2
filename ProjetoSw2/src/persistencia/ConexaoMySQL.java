/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ConexaoMySQL {
    private Connection conexao = null;
    public String server,base,senha,usuario;

    public ConexaoMySQL(String server, String dataBase, String senha, String usuario) {
        this.server = server;
        this.base = dataBase;
        this.senha = senha;
        this.usuario = usuario;
    }
    
    public String conectar(){
        try {
            //driver
            String driverName = "org.gjt.mm.mysql.Driver"; // MySQL MM JDBC driver
            Class.forName(driverName);

            //parametros de conexao
            String serverName = this.server;
            String mydatabase = this.base;
            String url = "jdbc:mysql://" + serverName +  "/" + mydatabase; // a JDBC url
            String username = this.usuario;
            String password = this.senha;
            setConexao(DriverManager.getConnection(url, username, password));
        } catch (ClassNotFoundException e) {
            System.out.println("Erro no driver de conexao MySQL!");
            e.printStackTrace();
            return e.getMessage();
        } catch (SQLException e) {
            System.out.println("Erro na conexão do Banco!");
            e.printStackTrace();
            return e.getMessage();
        }
        return "true";
    }


    public boolean desconectar(){
        try {
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro ao desconectar do banco");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @return the conexao
     */
    public Connection getConexao() {
        return conexao;
    }

    /**
     * @param conexao the conexao to set
     */
    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    

    


}
