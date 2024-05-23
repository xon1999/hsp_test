package com.hsp;

import java.io.FileNotFoundException;

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
//        chapter10Demo.testP406();
//        chapter10Demo.testP421();
//        chapter10Demo.testP432();
        chapter10Demo.testP446();
    }
    static void chapter11Run(){
        Chapter11 chapter11Demo = new Chapter11();
        chapter11Demo.testP482();
    }
    static void chapter12Run(){
        Chapter12 chapter12Demo = new Chapter12();
        chapter12Demo.testP505();
        try {
            chapter12Demo.testP528();
        }catch (Chapter12.AgeException e){
            System.out.println(e.getMessage());
        }

    }

    static void chapter13Run(){
        Chapter13 chapter13Demo = new Chapter13();
        chapter13Demo.testP533();
        chapter13Demo.testP541();
        chapter13Demo.testP583();
        chapter13Demo.testP595();
    }
    static void chapter14Run(){
        Chapter14 chapter14Demo = new Chapter14();
        chapter14Demo.testP601();

    }
    static void chapter15Run(){
        Chapter15 chapter15Demo = new Chapter15();
        chapter15Demo.testP700();
        chapter15Demo.testP721();
    }

    static void chapter17Run(){
        Chapter17 chapter17Demo = new Chapter17();
        chapter17Demo.testP780();
    }

    public static void main(String[] args){
        Main.chapter17Run();


    }

}