import persistencia.ConexaoMySQL;
import persistencia.dao.DaoDesenho;
import persistencia.dao.entidade.Desenho;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorSocket implements Runnable {
    private ConexaoMySQL mysql
            = new ConexaoMySQL
            ("192.168.15.4", "projsw2_paint",
                    "root", "root");

    public static final String CMD_CONS_TODOS = "CONSULTA_TODOS";
    public static final String CMD_EXCLUIR = "EXCLUIR";
    public static final String CMD_INSERIR = "INSERIR";
    public static final String CMD_ATUALIZAR = "ATUALIZAR";



    private static ServerSocket server;
    private static int port = 3333;

    @Override
    public void run() {
        mysql.conectar();
        System.out.println("Conectado no Mysql... ");

        ServerSocket serverSocket = null;
        while (true) {

            try {
                serverSocket = new ServerSocket(port);
                System.out.println("--------------------------------------------------------");
                System.out.println("Esperando conexao/comando... ");

                Socket clientSocket = serverSocket.accept();

                //read from socket to ObjectInputStream object
                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());

                //convert ObjectInputStream object to String
                String message = (String) ois.readObject();
                System.out.println("COMANDO Recebido--> " + message);

                //sai do loop com ''EXIT''
                if(message.equalsIgnoreCase("exit")) break;

                //processa o comando
                this.processaComando(message, clientSocket, ois);

                //close resources
                ois.close();
            }catch (IOException e){
                e.printStackTrace();
            }catch (ClassNotFoundException c){
                c.printStackTrace();
            }finally{
                try {

                    serverSocket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        mysql.desconectar();
        System.out.println("Desconectado, servi'co encerrado... ");

    }

    private void processaComando(String CMD, Socket clientSocket, ObjectInputStream ois) {
        try {

            switch (CMD.split("-")[0]){

                case (CMD_CONS_TODOS):{
                    //write object to Socket
                    ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                    List<Desenho> list =  new DaoDesenho(mysql.getConexao()).consultaTodos();
                    oos.writeObject(list);

                    System.out.println("lista enviada..." );
                    oos.close();
                }break;

                case (CMD_EXCLUIR):{
                    //exclui desenho

                    int id = Integer.valueOf( CMD.split("-")[1] );
                    new DaoDesenho(mysql.getConexao()).excluirDesenho_id( id );

                    //retorna lista com desenho excluso
                    ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                    List<Desenho> list =  new DaoDesenho(mysql.getConexao()).consultaTodos();
                    oos.writeObject(list);

                    System.out.println("lista enviada..." );
                    oos.close();
                }break;


                case (CMD_INSERIR):{
                    //pega objeto desenho a ser inserido
                    Desenho desenho = (Desenho) ois.readObject();
                    System.out.println("Desenho Recebido, insert --> " + desenho.getNome());

                    //insere desenho...
                    new DaoDesenho(mysql.getConexao()).inserirDesenho( desenho );

                    //retorna desenho inserido
                    ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                    oos.writeObject(new DaoDesenho(mysql.getConexao()).consultaId( DaoDesenho.last_genKey ));

                    System.out.println("desenho inserido enviado..." );
                    oos.close();
                    ois.close();
                }break;

                case (CMD_ATUALIZAR):{
                    //pega objeto desenho a ser inserido
                    Desenho desenho = (Desenho) ois.readObject();
                    System.out.println("Desenho Recebido, update --> " + desenho.getNome());

                    //atualiza desenho...
                    new DaoDesenho(mysql.getConexao()).atualizarDesenho( desenho );

                    //retorna desenho atualizado
                    ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                    oos.writeObject(new DaoDesenho(mysql.getConexao()).consultaId( desenho.getId() ));

                    System.out.println("desenho atualizado enviado..." );
                    oos.close();
                    ois.close();
                }break;

                default:
                    System.out.println("Comando desconhecido!!" );
                    break;
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        new Thread(new ServidorSocket()).start();

    }



    public static void main(String args[], int TESTE) throws IOException, ClassNotFoundException{
        //create the socket server object
        server = new ServerSocket(port);
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Esperando conexões e pedidos.");
            //creating socket and waiting for client connection
            Socket socket = server.accept();
            //read from socket to ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            //convert ObjectInputStream object to String
            String message = (String) ois.readObject();
            System.out.println("Recebido--> " + message);


            //create ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket
            oos.writeObject("SV_ACK--> "+ message);
            System.out.println("ACK enviado--> " + message);


            //close resources
            ois.close();
            oos.close();
            socket.close();
            //terminate the server if client sends exit request
            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();
    }


}
