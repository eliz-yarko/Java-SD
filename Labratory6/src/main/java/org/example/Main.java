package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playroom playroom = new Playroom();

        try {
            // Додавання іграшок до ігрової кімнати
            playroom.addToy(new SmallCar("Small Car1", 10.0, 2));
            playroom.addToy(new MediumCar("Medium Car1", 20.0, 4));
            playroom.addToy(new LargeCar("Large Car1", 30.0, 6));
            playroom.addToy(new Doll("Doll1", 25.0, 5));
            playroom.addToy(new Ball("Ball1", 15.0, 3));
            playroom.addToy(new Cube("Cube1", 12.0, 3));

            System.out.println("Initial toys in the playroom:");
            playroom.displayToys();

            // Загальна вартість іграшок
            System.out.println("\nTotal price of toys: " + playroom.getTotalPrice());

            // Сортування іграшок за ціною
            playroom.sortToysByPrice();
            System.out.println("\nToys sorted by price:");
            playroom.displayToys();

            // Введення діапазону цін з перевіркою
            double minPrice = 0;
            double maxPrice = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.print("\nEnter minimum price: ");
                    minPrice = Double.parseDouble(scanner.nextLine());

                    System.out.print("Enter maximum price: ");
                    maxPrice = Double.parseDouble(scanner.nextLine());

                    if (minPrice > maxPrice || minPrice < 0 || maxPrice < 0) {
                        throw new IllegalArgumentException("Invalid price range. Minimum price cannot be greater than maximum price, and prices must be non-negative.");
                    }
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter numeric values for prices.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            // Пошук іграшок у діапазоні цін
            System.out.println("\nToys in price range (" + minPrice + " - " + maxPrice + "):");
            List<Toy> filteredToys = playroom.findToysInPriceRange(minPrice, maxPrice);
            if (filteredToys.isEmpty()) {
                System.out.println("No toys found in the specified price range.");
            } else {
                filteredToys.forEach(System.out::println);
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

