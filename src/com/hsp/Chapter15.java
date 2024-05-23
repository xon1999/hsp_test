/*
 * Copyright (c) 2024. All rights reserved.
 */

package com.hsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author： zangaiyao
 * @Date： 2024/5/1 12:08
 * @Describe：
 */
public class Chapter15 {

    @SuppressWarnings("all")
    void testP700(){
        //使用传统的方法来解决
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("发财", 1));
        arrayList.add(new Dog("小黄", 5));
        //假如我们的程序员，不小心，添加了一只猫
//        arrayList.add(new Cat("招财猫", 8));
        //遍历
        for (Object o : arrayList) {
        //向下转型Object ->Dog
            Dog dog = (Dog) o;// Exception: class com.hsp.Cat cannot be cast to class com.hsp.Dog
            System.out.println(dog.getName() + "-" + dog.getAge());
        }

        //使用泛型 不用类型转换，能提前检查元素类型，无编译警告
        ArrayList<Dog> dogArrayList = new ArrayList<>();
        dogArrayList.add(new Dog("旺财", 10));
        dogArrayList.add(new Dog("发财", 1));
        dogArrayList.add(new Dog("小黄", 5));
        //假如我们的程序员，不小心，添加了一只猫,编译时即报错
//        dogArrayList.add(new Cat("招财猫", 8));
        for (Dog dog:
             dogArrayList) {
            System.out.println(dog);
        }
        Animals<Dog> animals = new Animals<>();
        animals.addAnimal(new Dog("旺财", 10));
        animals.addAnimal(new Dog("发财", 1));
        animals.addAnimal(new Dog("小黄", 5));
        System.out.println(animals.getAnimalsMessage());

    }

    void testP721(){
        ArrayList<Employee1> employee1ArrayList = new ArrayList<>();
        employee1ArrayList.add(new Employee1("ava",15_000,new MyDate(12,6,1999)));
        employee1ArrayList.add(new Employee1("Bella",14_000,new MyDate(17,7,1998)));
        employee1ArrayList.add(new Employee1("Diana",25_000,new MyDate(7,3,2001)));
        employee1ArrayList.add(new Employee1("Eileen",19_000,new MyDate(8,8,1999)));
        employee1ArrayList.sort(new Comparator<Employee1>() {
            @Override
            public int compare(Employee1 o1, Employee1 o2) {
                if(o1.getName().length()-o2.getName().length()>0){
                    return 1;
                }
                else if(o1.getName().length()-o2.getName().length()<0){
                    return -1;
                }
                else {
                    return o2.getBirthday().getNumbers()-o1.getBirthday().getNumbers();
                }
            }
        });
        System.out.println(employee1ArrayList);

    }
}
class Dog{
    private String name;
    private int age;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Cat{
    private String name;
    private int age;
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

class Animals<E>{
    private ArrayList<E> animals = new ArrayList<>();
    public Animals(){
    }
    public Animals(ArrayList<E> animals){
        this.animals = animals;
    }

    public void addAnimal(E animal) {
        this.animals.add(animal);
    }

    public ArrayList<E> getAnimals() {
        return animals;
    }
    public String getAnimalsMessage(){
        String message = "";
        if(!this.animals.isEmpty()){
            for (E e:animals
             ) {
                message =message + e;
            }
        }
        return message;

    }

    @Override
    public String toString() {
        return "Animals{" +
                "animals=" + animals +
                '}';
    }
}

class Employee1{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee1(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate{
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }



    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumbers(){
        return (int)year+month+day;
    }

    @Override
    public String toString() {
        return year+"-"+month+"-"+day;
    }
}