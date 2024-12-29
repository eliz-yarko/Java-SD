package org.example;

import java.util.*;

// Типізована колекція для роботи з іграшками
class ToyCollection implements List<Toy> {
    private ArrayList<Toy> toys;

    // Конструктори
    public ToyCollection() {
        this.toys = new ArrayList<>(15);
    }

    public ToyCollection(Toy toy) {
        this();
        this.toys.add(toy);
    }

    public ToyCollection(Collection<? extends Toy> collection) {
        this.toys = new ArrayList<>(collection);
    }

    // Додавання іграшки
    @Override
    public boolean add(Toy toy) {
        return toys.add(toy);
    }

    @Override
    public void add(int index, Toy toy) {
        toys.add(index, toy);
    }

    @Override
    public boolean addAll(Collection<? extends Toy> collection) {
        return toys.addAll(collection);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Toy> collection) {
        return toys.addAll(index, collection);
    }

    @Override
    public Toy get(int index) {
        return toys.get(index);
    }

    @Override
    public Toy remove(int index) {
        return toys.remove(index);
    }

    @Override
    public boolean remove(Object o) {
        return toys.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return toys.removeAll(c);
    }

    @Override
    public int size() {
        return toys.size();
    }

    @Override
    public boolean isEmpty() {
        return toys.isEmpty();
    }

    @Override
    public void clear() {
        toys.clear();
    }

    @Override
    public int indexOf(Object o) {
        return toys.indexOf(o);
    }

    @Override
    public ListIterator<Toy> listIterator() {
        return toys.listIterator();
    }

    @Override
    public List<Toy> subList(int fromIndex, int toIndex) {
        return toys.subList(fromIndex, toIndex);
    }

    // Інші методи інтерфейсу List залишені без реалізації для скорочення коду

    @Override
    public boolean contains(Object o) {
        return toys.contains(o);
    }

    @Override
    public Iterator<Toy> iterator() {
        return toys.iterator();
    }

    @Override
    public Object[] toArray() {
        return toys.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return toys.toArray(a);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return toys.containsAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return toys.retainAll(c);
    }

    @Override
    public ListIterator<Toy> listIterator(int index) {
        return toys.listIterator(index);
    }

    @Override
    public Toy set(int index, Toy element) {
        return toys.set(index, element);
    }

    @Override
    public int lastIndexOf(Object o) {
        return toys.lastIndexOf(o);
    }
}