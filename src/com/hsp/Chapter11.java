/*
 * Copyright (c) 2024. All rights reserved.
 */

package com.hsp;

/**
 * @Author： zangaiyao
 * @Date： 2024/4/24 21:08
 * @Describe：
 */
public class Chapter11 {
    void testP482(){
        System.out.println(Season.FALL.getName()+"："+Season.FALL.getDesc());
    }
}

/*
 * 1. 自定义类实现枚举！
 * 细节：构造器私有化；对外暴露对象；提供get方法，但不提供set
 */

class Season_1{
    private String name;
    private String desc;
    public static final Season_1 SPRING = new Season_1("春天","温暖");
    public static final Season_1 SUMMER = new Season_1("夏天","炎热");
    public static final Season_1 FALL = new Season_1("秋天","清爽");
    public static final Season_1 WINTER = new Season_1("冬天","寒冷");
    private Season_1(String name,String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}

/*
 * 2. 枚举类实现枚举！
 * 细节：关键字 enum 替代class；枚举对象必须放在枚举类的行首.
 */
enum Season{

    SPRING("春天","温暖"),SUMMER("夏天","炎热"),
    FALL("秋天","清爽"), WINTER("冬天","寒冷");
    private String name;
    private String desc;
    private Season(String name,String tem){
        this.name = name;
        this.desc = tem;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

}