package Singleton;

class Singleton {
    /**
     * This instance can be used when you are synchronizing whole getInstance method
     * */
    private static Singleton singletonInstancev1 = null;

    /**
     * This instance can be used to create instance everytime when JVM loads
     * i.e. this way does not lazy initialize(initialize on demand)
     */
    private static Singleton singletonInstancev2 = new Singleton();

    /**
     * This instance can be used when you are synchronizing
     * a segment of getInstance
     * */
    private static volatile Singleton singletonInstancev3 = null;




    private Singleton() {
        System.out.println("Instantiation of Singleton");
    }

    /**
     * Three ways to make Singleton pattern threadsafe
     */

    /**
     * VERSION 1
     * one option is to make the getSingletonInstance synchronized
     * - Slow upto 100x
     */

    public static synchronized Singleton getSingletonInstancev1() {
        if(singletonInstancev1 == null) {
            // If two threads reach to this line then two different instance will be created
            singletonInstancev1 = new Singleton();
        }

        return singletonInstancev1;
    }

    /**
     * VERSION 2
     * second option is to always create a single instance beforehand
     * singletonInstance v2
     * + Fast
     * - no lazy initialization
     */

    public static Singleton getSingletonInstancev2() {
        return singletonInstancev2;
    }

    /**
     * VERSION 3
     * third option is to use volatile instance with synchronize
     */

    public static Singleton getSingletonInstancev3() {
        if(singletonInstancev3 == null) {
            synchronized (Singleton.class) {
                if(singletonInstancev3 == null) {
                    singletonInstancev3 = new Singleton();
                }
            }
        }

        return singletonInstancev3;
    }

    /**
     * A normal method
     */
    public void display() {
        System.out.println("Hello from singleton with hash" + this.hashCode());
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingletonInstancev3();
        Singleton singleton2 = Singleton.getSingletonInstancev3();
        Singleton singleton3 = Singleton.getSingletonInstancev3();

        singleton1.display();
        singleton2.display();
        singleton3.display();
    }
}
