package com.hsp;

/**
 * @author zangaiyao
 */
public class Main {
    static void chapter1to6Run(){
        Chapter1to6 chapter1To6Demo = new Chapter1to6();
        chapter1To6Demo.testP28();
        chapter1To6Demo.testP55();
        chapter1To6Demo.testP58();
        chapter1To6Demo.testP140First();
    }
    static void chapter7Run(){
        Chapter7 chapter7Demo = new Chapter7();
        chapter7Demo.testP222First();
        chapter7Demo.testP251();
        chapter7Demo.testP242();
    }
    static void chapter8Run(){
        Chapter8 chapter8Demo = new Chapter8();
        chapter8Demo.testP279();
    }
    static void chapter10Run(){
        Chapter10 chapter10Demo = new Chapter10();
//        chapter10Demo.testP375();
        chapter10Demo.testP406();
    }

    public static void main(String[] args) {
        Main.chapter10Run();


    }

}