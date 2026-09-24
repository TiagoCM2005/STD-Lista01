package engtelecom.std;

public class App {


    public static void main(String[] args) throws Exception {

        String versao = System.getenv("VERSAO");

        while (true) {
            System.out.println("versão: " + versao);

            Thread.sleep(1000);
        }



    }
}
