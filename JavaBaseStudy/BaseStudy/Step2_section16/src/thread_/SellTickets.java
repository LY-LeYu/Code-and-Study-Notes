package thread_;

@SuppressWarnings({"all"})
public class SellTickets {
    public static void main(String[] args) {
//-------------------第1种方式----------------
//        Sell1 sell1 = new Sell1();
//        Sell1 sell3 = new Sell1();
//        Sell1 sell3 = new Sell1();
//        sell1.start();
//        sell3.start();
//        sell3.start();
//-------------------第2种方式----------------
        Sell3 sell3 = new Sell3();
        new Thread(sell3).start();
        new Thread(sell3).start();
        new Thread(sell3).start();


    }
}

class Sell3 implements Runnable {
    int numOfTickets = 100;
    boolean flag = true;

    @Override
    public void run() {
        while (true) {
            sell();
            if (flag == false) {
                break;
            }
        }
    }

    public /*synchronized*/ void sell() {
        synchronized (this) {
            if (numOfTickets <= 0) {
                System.out.println(Thread.currentThread().getName() + "票已售完");
                flag = false;
                return;
            }

            System.out.println(Thread.currentThread().getName() + "卖出一张票,剩余票数" + --numOfTickets);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }




}

/*class Sell3 implements Runnable {
    int numOfTickets = 300;
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName()+"卖出一张票,剩余票数"+--numOfTickets);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (numOfTickets < 0) {
                break;
            }

        }
    }
}*/

//class Sell1 extends Thread {
//    int numOfTickets = 300;
//    @Override
//    public void run() {
//        while (true) {
//            System.out.println(Thread.currentThread().getName()+"卖出一张票,剩余票数"+--numOfTickets);
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            if (numOfTickets < 0) {
//                break;
//            }
//
//        }
//
//    }
//}


