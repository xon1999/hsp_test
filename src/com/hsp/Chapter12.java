/*
 * Copyright (c) 2024. All rights reserved.
 */

package com.hsp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author： zangaiyao
 * @Date： 2024/4/29 21:03
 * @Describe：
 */
public class Chapter12 {
    void testP505() {
        /*
        * try出现异常执行catch，否则不执行。finally始终执行。
        * */
        try {
            int num1 = 1;
            int num2 = 0;
            int num3 = num1/num2;
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(1.0/0);
        }finally {
            System.out.println("man,what can I say?");
        }
        try {
            readFile();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    public static void readFile() throws FileNotFoundException{
        FileInputStream fis = new FileInputStream("d://aa.txt");

    }

    void testP528() {
        int age = 180;
        if(!(age>=18&&age<=120)){
            throw new AgeException("age range:18-120");
        }
    }
    class AgeException extends RuntimeException{
        public AgeException(String message){
            super(message);
        }
    }


}

