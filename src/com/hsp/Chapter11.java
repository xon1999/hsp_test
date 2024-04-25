/*
 * Copyright (c) 2024. All rights reserved.
 */

package com.hsp;

import org.w3c.dom.ls.LSOutput;

/**
 * @Author： zangaiyao
 * @Date： 2024/4/24 21:08
 * @Describe：
 */
public class Chapter11 {
    void testP482(){
        System.out.println(Season.FALL.name());
    }
}

enum Season{

    SPRING("春天","温暖"),SUMMER("夏天","炎热"),
    FALL("秋天","清爽"), WINTER("冬天","寒冷");
    private String name;
    private String tem;
    private Season(String name,String tem){
        this.name = name;
        this.tem = tem;
    }



}