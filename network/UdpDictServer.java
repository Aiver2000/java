package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

public class UdpDictServer extends UdpEchoServer{
    private HashMap<String,String> dict = new HashMap<>();
    public UdpDictServer(int port) throws SocketException {
        super(port);
        dict.put("cat","小猫");
        dict.put("dog","小狗");
        dict.put("fuck","卧槽");
        dict.put("cristina","李王蓁");
        dict.put("pig","小猪");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"该词未收录！");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer udpDictServer = new UdpDictServer(9090);
        udpDictServer.start();
    }
}
