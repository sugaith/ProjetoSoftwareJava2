package persistencia;

import persistencia.dao.entidade.Desenho;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class ClienteSocket  {
    private static int port = 3333;
    private static String host = "192.168.15.4";
    public static final String CMD_CONS_TODOS = "CONSULTA_TODOS";
    public static final String CMD_EXCLUIR = "EXCLUIR";
    public static final String CMD_INSERIR = "INSERIR";
    public static final String CMD_ATUALIZAR = "ATUALIZAR";


    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    Socket socket = null;

    public Desenho atualizarDesenho(Desenho desenho) {
        try {
            connect();

            //envia comando String por ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(CMD_ATUALIZAR + "-");
            System.out.println(CMD_ATUALIZAR +".. enviado com sucesso!");

            //envia o desenho
            oos.writeObject(desenho);
            System.out.println("Desenho enviado com sucesso!");

            //le resposta
            ois = new ObjectInputStream(socket.getInputStream());
            Desenho desenho_inserido = (Desenho) ois.readObject();
            System.out.println("Resposta SERVER--> " + desenho.getClass());

            disconnect();
            return desenho_inserido;
        }catch (InterruptedIOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                oos.close();
                ois.close();
            }catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public Desenho inserirDesenho(Desenho desenho) {
        try {
            connect();

            //envia comando String por ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(CMD_INSERIR + "-");
            System.out.println(CMD_INSERIR +".. enviado com sucesso!");

            //envia o desenho
            oos.writeObject(desenho);
            System.out.println("Desenho enviado com sucesso!");


            //le resposta
            ois = new ObjectInputStream(socket.getInputStream());
            Desenho desenho_inserido = (Desenho) ois.readObject();
            System.out.println("Resposta SERVER--> " + desenho.getClass());

            disconnect();
            return desenho_inserido;
        }catch (InterruptedIOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                oos.close();
                ois.close();
            }catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public List<Desenho> consultaTodos(){
        try {
            connect();

            //envia comando String por ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(CMD_CONS_TODOS + "-");
            System.out.println(CMD_CONS_TODOS +".. enviado com sucesso!");


            //le resposta
            ois = new ObjectInputStream(socket.getInputStream());
            List<Desenho> list_d = (List<Desenho>) ois.readObject();
            System.out.println("Resposta SERVER--> " + list_d.getClass());

            disconnect();
            return list_d;
        }catch (InterruptedIOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                oos.close();
                ois.close();
            }catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }


    public List<Desenho> excluirDesenho(int id) {
        try {
            connect();

            //envia comando String por ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(CMD_EXCLUIR + "-" + id);
            System.out.println(CMD_EXCLUIR + "-"+id +".. enviado com sucesso!");


            //le resposta
            ois = new ObjectInputStream(socket.getInputStream());
            List<Desenho> list_d = (List<Desenho>) ois.readObject();
            System.out.println("Resposta SERVER--> " + list_d.getClass());

            disconnect();
            return list_d;
        }catch (InterruptedIOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                oos.close();
                ois.close();
            }catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }
    }


    private boolean disconnect(){
        try {
            socket.close();
            ois.close();
            oos.close();
            System.out.println("Desconectado!" );
            return true;
        }catch (InterruptedIOException e) {
            e.printStackTrace();
            return false;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean connect(){
        try {
            socket = new Socket(host, port);
            System.out.println("Conectado!");

            return true;
        }catch (InterruptedIOException e) {
            e.printStackTrace();
            return false;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public void run() {


        try {

//            Thread.sleep(3000);



            socket = new Socket("localhost", port);


            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("COMANDO PÁ");
            System.out.println("Comando enviado com sucesso!");

            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());

//            String message = (String) ois.readObject();
            List<Desenho> list_d;
            list_d = (List<Desenho>) ois.readObject();

            System.out.println("Resposta SERVER--> " + list_d.getClass());




            //close resources
            ois.close();
            oos.close();
            System.out.println("encerrado!" );


        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (InterruptedIOException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

//        new Thread(new ClienteSocket()).start();

//        new ClienteSocket().run();
        new ClienteSocket().consultaTodos();
    }



}
