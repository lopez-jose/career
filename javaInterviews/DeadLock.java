public class DeadLock {
    public void method1() {
        synchronized (String.class) {
            synchronized (Integer.class) {
                System.out.println("Acquired a lock in Integer.class object");
            }
        }
    }
}
