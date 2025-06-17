package Fila;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread{
    private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_filha =
             new ConcurrentLinkedQueue<>();

    public static void add(ObjetoFilaThread o){
        pilha_filha.add(o);
    }

    @Override
    public void run() {
        System.out.println("Fila rodando!");

        while(true) {

            Iterator iteracao = pilha_filha.iterator();

            synchronized (iteracao) {// Bloquear o acesso a essa listaa por outros processos

                while (pilha_filha.iterator().hasNext()) { //Enquanto tiver dados na lista ieá processsar
                    ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();// Pega o objeto atual
                    /* Processar 10 mil notas fiscaias */
                    System.out.println("============================================");
                    System.out.print("Nome do usuário: ");
                    System.out.println(processar.getNome());
                    System.out.print("E-mail do usuário: ");
                    System.out.println(processar.getEmail());

                    iteracao.remove();
                    try {
                        Thread.sleep(100);/* Dar um tempo para descarga de memoria */
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                Thread.sleep(1000);// Após processar toda lista, dar um tempo para limpesa de memoria
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
