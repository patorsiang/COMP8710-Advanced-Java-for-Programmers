public class Main {

    public static void main(String[] args) {
        var a = 6;
        var b = 2;

        // create new Threads
        var ts = new Thread[4];
        ts[0] = new Thread(() -> System.out.println("Thread 1: a+b = " + (a + b)));
        ts[1] = new Thread(() -> System.out.println("Thread 2: a-b = " + (a - b)));
        ts[2] = new Thread(() -> System.out.println("Thread 3: a*b = " + (a * b)));
        ts[3] = new Thread(() -> System.out.println("Thread 4: a/b = " + (a / b)));

        // start threads
        for (var t : ts) {
            t.start();
        }

        var mypin = 1234;  // local variable must be effectively final
        Runnable r = () -> System.out.println(mypin);
        // mypin = 7890;
        new Thread(r).start();

        var acc = new MyInt(1234);  // local variable
        Runnable r1 = () -> System.out.println(acc.get());
        acc.set(7890);
        new Thread(r1).start();
    }

    static private class MyInt {
        private int value;

        public MyInt(int n) {
            value = n;
        }

        public void set(int n) {
            value = n;
        }

        public int get() {
            return value;
        }
    }
}