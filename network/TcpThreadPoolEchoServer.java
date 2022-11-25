package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpThreadPoolEchoServer {
    private ServerSocket serverSocket = null;

    public TcpThreadPoolEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动！");
        ExecutorService pool = Executors.newCachedThreadPool();
        while (true) {
            //1.建立连接--接电话
            Socket clientSocket = serverSocket.accept();
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        processConnection(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
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

    public String process(String request) {
        return request;

    }

    public static void main(String[] args) throws IOException {
        TcpThreadPoolEchoServer server = new TcpThreadPoolEchoServer(9090);
        server.start();
    }

}
