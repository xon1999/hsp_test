package com.hsp;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @Author： zangaiyao
 * @Date： 2024/4/18 21:27
 * @Describe：
 */
public class Chapter7 {
    void testP222First() {
        System.out.println(fib(4));

    }

    int fib(int n) {

        int g = 1;
        int f = 0;
        while (--n > 0) {
            g = g + f;
            f = g - f;
        }

        return g;
    }

    void testP251() {
        Car myCar = new Car("XiaoMiSu7", 239_000, "purple", new String[]{"zangaiyao", "misayao"});
        System.out.println(myCar.model + "\t" + myCar.price + "\t" + myCar.color + "\t" + myCar.masters[0] + "\t" + myCar.masters[1]);
    }

    /**
     * reload
     */
    void testP242() {
        System.out.println(sum(5, 6));
        System.out.println(sum((double) 5, 6));
        System.out.println(sum(10, 1, 3, 43, 2, 5543, 3, 5, 5, 5, 5));

    }


    public int sum(int a, int b) {
        return a + b;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    /**
     * 可变参数可以和普通类型的参数一起放在形参列表，但必须保证可变参数在最后
     *
     * @param length 数组长度
     * @param a      形参数组
     * @return sum
     */
    public int sum(int length, int... a) {
        int sum = 0;
        for (int i = 0; i < length; ++i) {
            sum += a[i];
        }
        return sum;
    }
}


class Car {
    String model;
    double price = 1000_00;
    String color;
    String[] masters;

    public Car() {

    }

    public Car(String model, double price, String color, String[] masters) {
        this.model = model;
        this.price = price;
        this.color = color;
        this.masters = masters;
    }

    public boolean compareTo(Car b) {
        return Arrays.equals(this.masters, b.masters) && this.model.equals(b.model) && this.price == b.price && this.color.equals(b.color);
    }


}

class A01 {
    double price;

    public double max(double[] a) {
        double max = a[0];
        for (double v : a) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public double find(String[] sa, String s) {
        for (int i = 0; i < sa.length; ++i) {
            if (sa[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    public void updatePrice() {
        if (this.price > 150) {
            this.price = 150;
        } else if (this.price > 100) {
            this.price = 100;
        } else {
            return;
        }
    }

}