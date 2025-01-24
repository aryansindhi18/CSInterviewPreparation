import bank.*;

class Pen {
  String color;
  String type; // ball, gel, etc.

  public void write(String a) {
    System.out.println(a + " Written via Pen");
  }

  public void printColor() {
    System.out.println(color);
  }
}

class Student {
  String name;
  int age;

  public void printInfo() {
    System.out.println(this.name);
    System.out.println(this.age);
  }

  public void printInfo(int age) {
    System.out.println("Printing only age(Compile Time Polymorphism): " + this.age);
  }

  public void printInfo(String name) {
    System.out.println("Printing only name(Compile Time Polymorphism): " + this.name);
  }

  Student() {
    System.out.println("constructor called()");
  }

  Student(String name, int age) {
    System.out.println("parameterized constructor called");
    this.age = age;
    this.name = name;
  }

  // Copy Constructor
  Student(Student student) {
    System.out.println("Copy constructor called...");
    this.age = student.age;
    this.name = student.name;
  }
}

class Shape {
  String color;

  public void printColor() {
    System.out.println("possible via Inheritance " + this.color);
  }

  public void area() {
    System.out.println("Printing area :: Class Shape");
  }
}

class Triangle extends Shape {
  public void area(int base, int height) {
    System.out.println("Printing area :: Class Triangle - " + (float) (base * height) / 2);
  }
}

class EquilateralTriangle extends Triangle {
  public void area(int base, int height) {
    System.out.println("Printing area :: Class EquilateralTriangle - " + (float) (base * height) / 2);
  }
}

class Circle extends Shape {
  public void area(int radius) {
    System.out.println("Printing area :: Class Circle - " + (float) 3.14 * (radius * radius));
  }
}

abstract class Animal {
  // can have normal methods as well, not just abstract ones
  // cannot be instantiated
  // if any sub class now doesn't implement walk, it will give error
  // can have constructor
  Animal() {
    System.out.print("you're creating a new animal");
  }

  abstract void walk();
}

class Horse extends Animal {
  Horse() {
    System.out.print("you're creating a new horse");
  }

  public void walk() {
    System.out.println("Walks on 4 legs");
  }
}

class Chicken extends Animal {
  public void walk() {
    System.out.println("Walks on 2 legs");
  }
}

interface Animal{
  
}

public class OOPS {
  public static void main(String args[]) {
    Pen pen1 = new Pen();
    pen1.color = "blue";
    pen1.type = "ballpoint";
    pen1.write("Hello World!");

    Pen pen2 = new Pen();
    pen2.color = "green";
    pen2.type = "gel";

    pen1.printColor(); // Should print "blue"
    pen2.printColor(); // Should print "green"

    Student s1 = new Student();
    s1.name = "Aryan";
    s1.age = 25;
    s1.printInfo();

    Student s2 = new Student("Arushi", 24);
    s2.printInfo();

    Student s3 = new Student(s2);
    s3.printInfo();

    // Destructors are automatic in JAVA - using Garbage Collectors

    // Polymorphism
    // Compile Time Polymorphism - Function Overloading
    // Run Time Polymorphism - Function Overriding(Will be discussed in detail when
    // on inheritance)

    s3.printInfo(24);
    s3.printInfo("hello");

    // Inheritance
    // one class can get all properties&methods of another class if it inherits that
    // or extends that call
    // e.g - Parent class shape - properties: color
    // Child classes - Triangle - properties: name
    // here we defined only name property in triangle class but it will have color
    // as well, coz it extends shape class
    Triangle tri1 = new Triangle();
    tri1.color = "red";
    tri1.printColor();

    // Types Of Inheritance
    // Single Level
    // MultiLevel
    // Heirarchal
    // Hybrid
    // Multiple - Can be done using interfaces (will be covered there)
    tri1.area();
    tri1.area(20, 30);

    EquilateralTriangle tri2 = new EquilateralTriangle();
    tri2.area();
    tri2.area(20, 30);

    Circle c1 = new Circle();
    c1.area();
    c1.area(2);

    // Packages
    // Put related functinalities at one place
    // Built-in Packages - Java.util.*
    bank.Account acc1 = new bank.Account();
    // acc1.name = "Customer1";

    // Access Modifiers
    // Public - anyone can access
    // Private - no one can access except class || (Getter/setters)
    // Protected - anyone can access within package, but outside package, only
    // sub-classes can access
    // Default - anyone within package can access, no outside access

    // Encapsulation
    // Whenever we create a class, we package data and fucntions in a single unit

    // Abstraction - showing users imp data and hide unimportant data
    // implemented using abstract classes and interfaces
    Horse horse1 = new Horse();
    horse1.walk();

    // Cannot create object of abstract class, it's just there as a min blueprint of
    // functionalities sub-classes need to implement
    // Animal animal = new Animal();




    //Interfaces
    //Pure abstraction
    //only abstract methods - by default public&abstract
    //interfaces are implemented not extended


    //static keyword

  }

}
