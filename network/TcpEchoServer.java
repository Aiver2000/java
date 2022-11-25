package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoServer {
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动！");
        while (true) {
            //1.建立连接--接电话
            Socket clientSocket = serverSocket.accept();
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) throws IOException {
        System.out.printf("[%s:%d] 客户端已连接！\n",clientSocket.getInetAddress().toString(),clientSocket.getPort());
        try (InputStream inputStream  = clientSocket.getInputStream()){
            try(OutputStream outputStream = clientSocket.getOutputStream()){
                Scanner scanner = new Scanner(inputStream);
                while (true) {
                    if(!scanner.hasNext()){
                        System.out.printf("[%s:%d] 客户端断开连接！\n",clientSocket.getInetAddress().toString(),clientSocket.getPort());
                        break;
                    }
                    String request = scanner.next();
                    String response = process(request);
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(response);
                    printWriter.flush();

                    System.out.printf("[%s:%d] req: %s resp: %s\n",clientSocket.getInetAddress().toString(),clientSocket.getPort(),request,response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clientSocket.close();
        }
    }

    private String process(String request) {
        return request;

    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }

}
