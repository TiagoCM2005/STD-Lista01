package engtelecom.std;

public class App {


    public static void main(String[] args) throws Exception {

        String version = System.getenv("VERSAO");

        SendUDP send = new SendUDP(version);
        send.start(version);

        while (true) {
            System.out.println("versão: " + version);

            Thread.sleep(1000);
        }



    }
}
