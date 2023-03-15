package Threads;
//Method içerisinde istenmeyen sonuca sebep olmayan kodlar da varsa
public class SyncronizedKeyword {
    public static void main(String[] args) {
        Brackets2 brackets2= new Brackets2();
        long startTime =System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=9;i++){
                    brackets2.generateBracket();
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=9;i++){
                    brackets2.generateBracket();
                }
            }
        });
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Gecen Süre: "+(endTime-startTime));
    }


}
class Brackets2{
    //[[[[[]]]] şeklini ekrana yazdıran bir method
    public void generateBracket(){
        //this: bu class'tan uretilen object
        //Bloğa erişen thread için objeyi kilitle işlem
        //Tamamlandığında serbest bırak
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                if (i <= 5) {
                    System.out.print("[ ");
                } else {
                    System.out.print("] ");
                }
            }
            System.out.println();
        }

        //asenkron bir şekilde çalışmasında problem olmayan kodlar
        for (int i=1;i<=5;i++){
            //başka kodlar
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}