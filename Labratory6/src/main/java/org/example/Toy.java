package org.example;

// Базовий клас для іграшок
abstract class Toy {
    private String name;
    private double price;
    private int ageGroup;

    public Toy(String name, double price, int ageGroup) {
        this.name = name;
        this.price = price;
        this.ageGroup = ageGroup;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    @Override
    public String toString() {
        return name + " (Price: " + price + ", Age Group: " + ageGroup + ")";
    }
}

// Підкласи для типів іграшок
class Car extends Toy {
    public Car(String name, double price, int ageGroup) {
        super(name, price, ageGroup);
    }
}

class SmallCar extends Car {
    public SmallCar(String name, double price, int ageGroup) {
        super(name, price, ageGroup);
    }
}

class MediumCar extends Car {
    public MediumCar(String name, double price, int ageGroup) {
        super(name, price, ageGroup);
    }
}

class LargeCar extends Car {
    public LargeCar(String name, double price, int ageGroup) {
        super(name, price, ageGroup);
    }
}

class Doll extends Toy {
    public Doll(String name, double price, int ageGroup) {
        super(name, price, ageGroup);
    }
}

class Ball extends Toy {
    public Ball(String name, double price, int ageGroup) {
        super(name, price, ageGroup);
    }
}

class Cube extends Toy {
    public Cube(String name, double price, int ageGroup) {
        super(name, price, ageGroup);
    }
}