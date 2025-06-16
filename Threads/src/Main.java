
public class Main {
    public static void main(String[] args)  {

        new Thread(){
            public void run() {/*Executa o que queremos*/
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
        }.start();/* O start liga a thread que fica processando paralelamente por trás*/


        //**************** DIVISÂO DAS TREADS


        new Thread(){
            public void run() {/*Executa o que queremos*/
                /*Código da rotina*/
                for (int i = 0; i < 10; i++) {

                       System.out.println("Executando uma rotina, EX: Envio de Nota fiscal!");

                    try {
                        Thread.sleep(1000);
                        /*Quero executar esse envio com um tempo de parada / tempo determinado*/
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();/* O start liga a thread que fica processando paralelamente por trás*/

        System.out.println("Cregou ao fim do código de teste !");




    }
}