package Factory;

import java.util.Scanner;

/**
 * Common interface of product to be created
 */
abstract class Animal {
    String breed;
    public abstract String sound();
    public abstract String info();
}

/**
 * Common interface of various factories 
 * which can produce Product of type Animal
 */
abstract class AnimalFactory {
    abstract Animal createAnimal(String breed);
}

/**
 * Concrete Animal: Dog
 */
class Dog extends Animal {
    public Dog(String breed) {
        this.breed = breed;
    }

    @Override
    public String sound() {
        return "Woof";
    }

    @Override
    public String info() {
        return sound() + " : " + this.breed;
    }

}

class Cat extends Animal {
    public Cat(String breed) {
        this.breed = breed;
    }

    @Override
    public String sound() {
        return "Meow";
    }

    @Override
    public String info() {
        return sound() + " : " + this.breed;
    }

}

/**
 * Concrete AnimalFactory: Dog Factory
 */
class CatFactory extends AnimalFactory {

    @Override
    Animal createAnimal(String breed) {
        return new Cat(breed);
    }

}

/**
 * Concrete AnimalFactory: Cat Factory
 */
class DogFactory extends AnimalFactory {

    @Override
    Animal createAnimal(String breed) {
        return new Dog(breed);
    }

}

public class Main {

    public static void main(String[] args) {
        /**
         * Creation of concrete animals delegated to factories
         * sub-type of various animals are handled by subtypes of animal factories
         */
        AnimalFactory dogFactory = new DogFactory();
        AnimalFactory catFactory = new CatFactory();    

        /**
         * Run Time creation of various animal types
         * Advantage of code on interface rather than impleentations
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Animal type: ");
        String animal = scanner.nextLine();
        System.out.println("Enter Animal breed: ");
        String breed = scanner.nextLine();

        Animal animalInstance = null;

        /**
         * Notice that subtypes of Dog and Cat according to breed
         * needs various other sub-sub-types which are delegated to be handled by factories
         * 
         * So our driver method is loosly coupled with those subtypes
         */
        if("dog".equals(animal)) {
            animalInstance = dogFactory.createAnimal(breed);
        } else if("cat".equals(animal)) {
            animalInstance = catFactory.createAnimal(breed);
        }

        if (animalInstance != null) {
            System.out.println(animalInstance.info());
        }

        scanner.close();
    }
    
}
