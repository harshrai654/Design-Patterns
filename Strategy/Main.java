package Strategy;

/**
 * Bike having some common strategy
 * and some rapidly changing (updating or add/delete) strategies
 * 
 * Splitting Varying Strategies with poissble variations (algorithms)
 * from constant strategy
 */

/**
 * Having common Interface for each type strategy
 * to use run time polymorphism
 */
interface RunStrategy {
    public void run();
}

interface StartStrategy {
    public void start();
}

/**
 * Different Algorithms for Run Strategy
 */
class GearedRunAlgo implements RunStrategy {

    @Override
    public void run() {
        System.out.println("Geared Bike");
    }

}

class AccelatrateRunAlgo implements RunStrategy {

    @Override
    public void run() {
        System.out.println("Only Accelaration Bike");
    }

}

/**
 * Different Algorithms for Start Strategy
 */
class SelfStartAlgo implements StartStrategy {

    @Override
    public void start() {
        System.out.println("Self Start Bike");
    }

}

class KickStartAlgo implements StartStrategy {

    @Override
    public void start() {
        System.out.println("Kick Start Bike");
    }
}


class Bike { 
    private RunStrategy runStrategy;
    private StartStrategy startStrategy;

    //These Strategies can also be Injected in runtime
    public Bike(RunStrategy runStrategy, StartStrategy startStrategy) {
        this.runStrategy = runStrategy;
        this.startStrategy = startStrategy;
    }

    public void run() {
        runStrategy.run();
    }

    public void start() {
        startStrategy.start();
    }
    

}


class Jupiter extends Bike {

    public Jupiter(RunStrategy runStrategy, StartStrategy startStrategy) {
        super(runStrategy, startStrategy);
    }

}

class Honda extends Bike {

    public Honda(RunStrategy runStrategy, StartStrategy startStrategy) {
        super(runStrategy, startStrategy);
    }

}

public class Main {
    public static void main(String[] args) {
        Bike jupiter = new Jupiter(new AccelatrateRunAlgo(), new SelfStartAlgo());
        Bike honda = new Honda(new GearedRunAlgo(), new KickStartAlgo());

        jupiter.start();
        jupiter.run();

        honda.start();
        honda.run();
    }
    
}