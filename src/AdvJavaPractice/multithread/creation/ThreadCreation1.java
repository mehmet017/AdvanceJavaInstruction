package AdvJavaPractice.multithread.creation;

public class ThreadCreation1 {

    public static void main(String[] args) {

        //Task1: Thread sınıfını extend eden Sayac isminde sınıf oluşturup
        // bu sınıftan sayıları 1 den 100 e kadar yazdıran iki tane thread oluşturunuz.

        Sayac thread1 = new Sayac("Ronaldo");
        Sayac thread2 = new Sayac("ArdaGuler");

        thread1.start();
        thread2.start();


    }

}
