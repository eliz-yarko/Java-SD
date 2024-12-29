package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Масив об'єктів класу Student
        List<Student> students = Arrays.asList(
                new Student("Олександр", 20, 3.5, "Комп'ютерні науки", 2),
                new Student("Богдан", 22, 3.8, "Математика", 4),
                new Student("Василь", 21, 3.2, "Фізика", 3),
                new Student("Дмитро", 23, 3.9, "Інженерія", 5),
                new Student("Єва", 19, 3.7, "Біологія", 1)
        );

        // Виведення початкового масиву
        System.out.println("Initial array:");
        students.forEach(System.out::println);
        System.out.println();

        // Сортування за віком (зростання)
        List<Student> sortedByAge = students.stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .collect(Collectors.toList());
        System.out.println("Sorted by age (ascending):");
        sortedByAge.forEach(System.out::println);
        System.out.println();

        // Сортування за середнім балом (спадання)
        List<Student> sortedByGpa = students.stream()
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .collect(Collectors.toList());
        System.out.println("Sorted by GPA (descending):");
        sortedByGpa.forEach(System.out::println);
        System.out.println();

        // Пошук об'єкта, ідентичного заданому
        Student target = new Student("Василь", 21, 3.2, "Фізика", 3);
        boolean found = students.contains(target);
        System.out.println("Target student found: " + found);

        // Виведення знайденого об'єкта (якщо є)
        if (found) {
            System.out.println("Found student: " + target);
        }
    }
}