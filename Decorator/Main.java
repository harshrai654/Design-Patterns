package Decorator;

/**
 * This example is not the best use case of decorator pattern
 */


//Base contract
abstract class Beverage {
    public abstract int cost();
}

/**
 * A decorator which `has a Beverage`
 * and also `is a beverage`
 */
abstract class AddOnDecorator extends Beverage {
    public Beverage beverage;
    public abstract int cost();
}

//Concrete Defination of a Decorator called Caramel
class Caramel extends AddOnDecorator {
    Caramel(Beverage addOn){
        this.beverage = addOn;
    }
    /**
     * Using inner Decorator (which is also of super type beverage)
     * dont confuse beverge with base beverage
     * The beverage instance inside Decorator can be another decorator
     */
    @Override
    public int cost() {
        return this.beverage.cost() + 10;
    }

}

//Concrete Defination of a Decorator called Chocolate
class Chocolate extends AddOnDecorator {
    Chocolate(Beverage addOn){
        this.beverage = addOn;
    }
    /**
     * Another Decorator
     * Order of layers of decorator is defined while instantiation
     */
    @Override
    public int cost() {
        return this.beverage.cost() + 15;
    }

}

/**
 * Concreate Defination of Base Beverage: Coffee
 */
class Coffee extends Beverage {

    //Base price of a coffee without addons
    @Override
    public int cost() {
        return 5;
    }

}

public class Main {
    public static void main(String[] args) {
        /**
         * We can see run time mix of various possible combination 
         * coffee
         * coffee + caramel
         * coffee + caramel + chocolate
         * coffe + chocolate
         * 
         * This is advantage of using decorator pattern
         */


        //Coffee
        Beverage baseCoffee = new Coffee();
        System.out.println("Cost of base coffee " + baseCoffee.cost());

        //Caramel[(caramel(base))]
        Beverage caramelCoffee = new Caramel(baseCoffee);
        System.out.println("Cost of caramel coffee " + caramelCoffee.cost());

        //Chocolate[(chocolate(base))]
        Beverage chocolateCoffee = new Chocolate(baseCoffee);
        System.out.println("Cost of chocolate coffee " + chocolateCoffee.cost());

        //Chocolate(Caramel(Coffee))
        Beverage chocolateCaramelCoffee = new Chocolate(caramelCoffee);
        // OR
        // Beverage caramelChocolateCoffee = new Caramel(chocolateCoffee);

        System.out.println("Cost of chocolate caramel coffee " + chocolateCaramelCoffee.cost());
    }    
}
