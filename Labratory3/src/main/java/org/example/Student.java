package org.example;
import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private double gpa;
    private String major;
    private int year;

    // Конструктор
    public Student(String name, int age, double gpa, String major, int year) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.major = major;
        this.year = year;
    }

    // Геттери
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGpa() { return gpa; }
    public String getMajor() { return major; }
    public int getYear() { return year; }

    // Перевизначений метод toString
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                ", major='" + major + '\'' +
                ", year=" + year +
                '}';
    }

    // Перевизначений метод equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Double.compare(student.gpa, gpa) == 0 && year == student.year && Objects.equals(name, student.name) && Objects.equals(major, student.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gpa, major, year);
    }
}