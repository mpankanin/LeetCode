package Encapsulation.SecondPackage;

import Encapsulation.FirstPackage.Animal;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal();

        //animal.publicField;
        //todo so from a different package I can see only a public field.

        Cat cat = new Cat();
        //cat.publicField;
        //todo even for a subclass I can see only the private field.


    }

}
