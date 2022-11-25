package network;

import java.io.IOException;
import java.util.HashMap;

public class TcpDictServer extends TcpThreadPoolEchoServer{
    private HashMap<String,String> dict = new HashMap<>();
    public TcpDictServer(int port) throws IOException {
        super(port);
        dict.put("cat","小猫");
        dict.put("dog","小狗");
        dict.put("fuck","卧槽");
    }
    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"当前词未收录!");
    }

    public static void main(String[] args) throws IOException {
        TcpDictServer server = new TcpDictServer(9090);
        server.start();
    }
}
