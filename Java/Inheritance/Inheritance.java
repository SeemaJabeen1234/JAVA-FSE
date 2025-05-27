package Inheritance;

// Base class
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.makeSound(); // Output: Animal makes a sound

        Dog d = new Dog();
        d.makeSound(); // Output: Bark
    }
}
