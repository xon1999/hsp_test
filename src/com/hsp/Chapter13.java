/*
 * Copyright (c) 2024. All rights reserved.
 */

package com.hsp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * @Author： zangaiyao
 * @Date： 2024/4/29 22:02
 * @Describe：
 */
public class Chapter13 {
    void testP533(){
        int n1 = 100;
        Integer integer1 = new Integer(n1); //新建变量指向堆中新建的对象,两者在内存中的地址不同
        Integer integer1_1 = Integer.valueOf(n1);
        Integer integer2 = new Integer(100);
        Integer integer3 = n1;// 底层调用valueOf(n1) 等价于integer1_1
        Integer integer4 = n1;
        System.out.println(integer1==integer2); // false 两个Integer对象
        System.out.println(integer1==integer1_1);
        System.out.println(integer1==integer3); // false 两个Integer对象
        //    100在-128-127之间，在IngeterCache范围内则直接返回，因此为同一个对象
        System.out.println(integer3==integer4);// true

    }
    void testP541(){
//        字符串的字符使用Unicode 字符编码(utf-16)，一个字符(不区分字母还是汉字)占两个字节
        String asoul = "Ava";

        asoul = asoul+"Bella";
        char[] asoulChars = asoul.toCharArray();
        StringBuffer as = new StringBuffer(asoul);
        as.append("Diana");
        StringBuilder ass = new StringBuilder(as);
        ass.append("Eileen");
        ass = new StringBuilder(ass.substring(0, 3) + " " + ass.substring(3, 8) + " " + ass.substring(8, 13) + " " + ass.substring(13, 19));
        System.out.println(asoulChars);
        System.out.println(as);
        System.out.println(ass);
    }
    void testP583(){
        Book[] books = new Book[4];
        books[0] = new Book("红楼",50);
        books[1] = new Book("机器学习方法",100);
        books[2] = new Book("蛊真人",200);
        books[3] = new Book("向晚写真集",5000);
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                double priceDec = o1.getPrice()-o2.getPrice();
                if(priceDec>0){return 1;}
                else if(priceDec<0){return -1;}
                else {return 0;}
            }
        });
        System.out.println(Arrays.toString(books));
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().length()-o2.getName().length();
            }
        });
        System.out.println(Arrays.toString(books));
    }

    void testP595(){
        /*
        * LocalDate 只包含日期 年月日
        * LocalTime 只包括时间 时分秒
        * LocalDateTime 包括日期时间
        * */
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(ldt);
        System.out.println(format);
        System.out.println(Arrays.toString(new int[]{ldt.getYear(), ldt.getMonthValue()}));
        System.out.println(ldt.getMonth());

        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        LocalTime lt = LocalTime.now();

        Instant now = Instant.now();
        System.out.println(now);
        Date date = Date.from(now);
        System.out.println(date);
        Instant instant = date.toInstant();
        System.out.println(instant);


    }


}

class Book{
    private String name;
    private double price;

    public Book(String name,double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
