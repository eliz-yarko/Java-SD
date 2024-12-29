package org.example;

import java.util.List;
import java.util.Scanner;

// Головний клас для запуску програми
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playroom playroom = new Playroom();

        try {
            // Додавання іграшок
            playroom.addToy(new SmallCar("Small Car1", 10.0, 2));
            playroom.addToy(new MediumCar("Medium Car1", 20.0, 4));
            playroom.addToy(new LargeCar("Large Car1", 30.0, 6));
            playroom.addToy(new Doll("Doll1", 25.0, 5));
            playroom.addToy(new Ball("Ball1", 15.0, 3));
            playroom.addToy(new Cube("Cube1", 12.0, 3));

            System.out.println("Toys in the playroom:");
            for (Toy toy : playroom.getToys()) {
                System.out.println(toy);
            }

            // Сортування іграшок за ціною
            playroom.sortToysByPrice();
            System.out.println("\nToys sorted by price:");
            for (Toy toy : playroom.getToys()) {
                System.out.println(toy);
            }
            System.out.println();

            // Перевірка вводу мінімальної ціни
            System.out.print("Enter minimum price: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input. Enter a valid minimum price: ");
                scanner.next();
            }
            double minPrice = scanner.nextDouble();

            // Перевірка вводу максимальної ціни
            System.out.print("Enter maximum price: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input. Enter a valid maximum price: ");
                scanner.next();
            }
            double maxPrice = scanner.nextDouble();

            System.out.println();
            // Знаходження іграшок в діапазоні цін
            List<Toy> filteredToys = playroom.findToysInPriceRange(minPrice, maxPrice);
            System.out.println("Toys in the price range:");
            for (Toy toy : filteredToys) {
                System.out.println(toy);
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}