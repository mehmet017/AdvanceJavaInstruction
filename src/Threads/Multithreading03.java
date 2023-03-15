package Threads;

public class Multithreading03 {
    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
              for (int i=1;i<=9;i++){
                  brackets.generateBracket();
              }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=9;i++){
                    brackets.generateBracket();
                }
            }
        });

        thread2.start();


    }
//iki thread aynı anda methoda erişmee çalıştığğında methodun içindeki işlem tamamlanmadan
//diğer thread işleme başlayabiliyor, bu sebeple sırayla erişmelerini istiyoruz

}
class Brackets{
    //[[[[[]]]] şeklini ekrana yazdıran bir method
    public synchronized void generateBracket(){
        for (int i=1;i<=10;i++){
            if (i<=5){
                System.out.print("[ ");
            }else {
                System.out.print("] ");
            }


        }
        System.out.println();

    }


}