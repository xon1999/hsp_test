package com.hsp;

/**
 * @Author： zangaiyao
 * @Date： 2024/4/18 21:27
 * @Describe：
 */
public class Chapter7 {
    void testP251(){
        Car myCar = new Car("XiaoMiSu7",239_000,"purple", new String[]{"zangaiyao","misayao"});
        System.out.println(myCar.model+"\t"+myCar.price+"\t"+myCar.color+"\t"+myCar.masters[0]+"\t"+myCar.masters[1]);
    }
}

class Car{
    String model;
    double price;
    String color;
    String[] masters;

    public Car(String model,double price,String color,String[] masters){
        this.model = model;
        this.price = price;
        this.color = color;
        this.masters = masters;
    }


}
