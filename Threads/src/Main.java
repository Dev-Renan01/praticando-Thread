
public class Main {
    public static void main(String[] args) {

        Thread threadNotaFiscal = new Thread(thread1);
        threadNotaFiscal.start();

        //**************** DIVISÂO DAS TREADS

       Thread threadEmail = new Thread(thread2);
       threadEmail.start();

        System.out.println("Cregou ao fim do código de teste !");
    }


    private static Runnable thread1 = new Runnable() {

        @Override
        public void run() {
            /*Código da rotina*/
            for (int i = 0; i < 10; i++) {

                System.out.println("Executando uma rotina, EX: Envio de Nota fiscal!");

                try {
                    /*Quero executar esse envio com um tempo de parada / tempo determinado*/
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private static Runnable thread2 = new Runnable() {

        @Override
        public void run() {
                /*Código da rotina*/
            for (int i = 0; i < 10; i++) {
                System.out.println("Executando uma rotina, EX: envio de E-mail!");
                try {
                    Thread.sleep(1000);
                    /*Quero executar esse envio com um tempo de parada / tempo determinado*/
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}