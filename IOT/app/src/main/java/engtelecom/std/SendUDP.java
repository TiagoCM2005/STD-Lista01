package engtelecom.std;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;


public class SendUDP {
    private static final String MULTICAST = "231.0.0.1";
    private static final int PORT = 1290;
    private final String version;

    public SendUDP(String version){
        this.version = version;
    }


    public static void start(String version) {
        Thread thread = new Thread(() -> {
            try (DatagramSocket socket = new DatagramSocket()){

                InetAddress adress = InetAddress.getByName(MULTICAST);

                while(!Thread.currentThread().isInterrupted()){
                    byte[] data = version.getBytes(StandardCharsets.UTF_8);

                    DatagramPacket packet = new DatagramPacket(data, data.length, adress, PORT);
                    socket.send(packet);

                    System.out.println("Mensagem UDP enviada: " + version);
                    Thread.sleep(10000);
                }


            } catch (IOException | InterruptedException e) {
                System.err.println("Erro no envio UDP: " + e.getMessage());
            }
        });

        thread.setName("send-udp");
        thread.start();
    }
}

