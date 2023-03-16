package Threads;

public class WaitInterrupt {

    public static int balance=0;

    public static void main(String[] args) {
        WaitInterrupt object = new WaitInterrupt();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                object.withdraw(1000);
            }
        });
        thread1.setName("tüketici");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                object.deposit(2000);
                thread1.interrupt();// thread1'in işlemini zorla durduruyor
            }
        });
        thread2.setName("üretici");
        thread2.start();

    }
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para çekmek istiyor.");
        if(balance<=0 || balance<amount){
            System.out.println("Bakiye yetersiz...Mevcut bakiye :"+balance);
            System.out.println("Bakiyenin güncellenmesini bekliyor.");

        }

    }
    //para yatırma metodu
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor...");
        balance=balance+amount;
        System.out.println("Para yatırma işlemi gerçekleşti...Mevcut bakiye:"+balance);
    }
}
