package com.hsp;


/**
 * class name UpperCamelCase
 * 方法名、参数名、成员变量、局部变量都统一使用lowerCamelCase风格
 *
 * @author zangaiyao
 **/
public class Chapter1to6 {
    void testP28() {
        System.out.println("misayao\nmale\nxg\nuestc");
    }
    void testP55() {
        String name = "misayao";
        short age = 25;
        short grade = 60;
        char sex = 'm';// m = male f = female
        String hobby = "badminton";
        System.out.println("name\t" + "age\t" + "grade\t" + "sex\t" + "hobby\t\n" + name + "\t" + age + "\t" + grade + "\t\t" + sex + "\t" + hobby + "\t");
    }

    void testP58(){
        int i=1,j= 1;
        i = ++i;// i = i+1 ; temp = i ; i = temp;
        j= j++;//  temp = j; j = temp; j = j+1;
        System.out.println("i="+ i); // 2
        System.out.println("j="+ j); // 1
    }
    void testP140First(){
        double money = 100_000;
        int counts = 0;
        while(true){
            while (money>50000){
                money = money*0.95;
                counts++;
            }
            while(money<=50000){
                counts += (int)money/1000;
                break;
            }
            break;
        }
        System.out.println("counts = "+counts);
    }


}