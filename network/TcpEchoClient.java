package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;
    public TcpEchoClient(String serverIP,int serverPort) throws IOException {
        socket = new Socket(serverIP,serverPort);
    }

    public void start(){
        System.out.println("连接到服务器！");
        Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream()) {
            try(OutputStream outputStream = socket.getOutputStream()){
                while (true) {
                    System.out.print("->");
                    String request = scanner.next();
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(request);
                    printWriter.flush();
                    Scanner respScanner = new Scanner(inputStream);
                    String response = respScanner.next();
                    System.out.printf("req:%s ,resp:%s\n",request,response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1",9090);
        tcpEchoClient.start();
    }
}
