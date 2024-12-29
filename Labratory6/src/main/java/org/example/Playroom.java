package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
// Клас для ігрової кімнати
class Playroom {
    private List<Toy> toys;

    public Playroom() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public double getTotalPrice() {
        return toys.stream().mapToDouble(Toy::getPrice).sum();
    }

    public void sortToysByPrice() {
        toys.sort(Comparator.comparingDouble(Toy::getPrice));
    }

    public List<Toy> getToys() {
        return toys;
    }

    public List<Toy> findToysInPriceRange(double minPrice, double maxPrice) {
        List<Toy> result = new ArrayList<>();
        for (Toy toy : toys) {
            if (toy.getPrice() >= minPrice && toy.getPrice() <= maxPrice) {
                result.add(toy);
            }
        }
        return result;
    }
    public List<Toy> findToysByPriceRange(double minPrice, double maxPrice) {
        return toys.stream()
                .filter(toy -> toy.getPrice() >= minPrice && toy.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public void displayToys() {
        toys.forEach(System.out::println);
    }
}