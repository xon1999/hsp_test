
package com.hsp;

import java.util.Arrays;

/**
 * @Author： zangaiyao
 * @Date： 2024/4/22 10:31
 * @Describe： ddd
 */
public class Chapter10 {
    void testP375(){
//        Person.setNumbers(0);//Any one here?
//        Person ava = new Person("ava",18,PersonSex.FEMALE);
//        System.out.println(ava);
        /*
        * 创建一个对象，调用顺序
        * T1：静态代码块=静态属性初始化，多个则按顺序依次进行
        * T2：普通代码块=普通成员属性初始化，多个则按顺序依次进行
        * T3：调用构造方法
        * */
        Idol avava = new Idol("avava",21,PersonSex.FEMALE,new IdolSkill[] {IdolSkill.GAME});
        System.out.println(avava);



    }

    void testP406(){
        System.out.println(Asoul.getAsoulInstance());
        System.out.println(Tara.getTaraInstance());

    }
}
class Person{
    private static int numbers = 0;
    private String name;
    private int age;
    private PersonSex sex;
    public static int getNumbers() {
        return numbers;
    }

    public static void addNumbers(int numbers) {
        Person.numbers += numbers;
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

    public PersonSex getSex() {
        return sex;
    }

    public void setSex(PersonSex sex) {
        this.sex = sex;
    }
    /*1、静态代码块
    随着类的加载而执行，且只会执行一次；
    类加载：1.创建对象实例(new)
          2.创建子类对象实例也会加载
          3.使用静态对象时(静态方法，静态属性)
    */
    static {
        System.out.println("Any person here?");
    }

    /*2、普通代码块
    普通代码块调用的顺序优先于构造器...但是晚于类加载（静态变量和静态方法可被调用）。
    创建对象时，发生一次隐性调用，创建一次，调用一次。
    调用顺序：父类--->子类（但是子类的静态代码块优先级大于父类）
    */
    {
        System.out.println("There is a new person coming!"+"Now we have "+ Person.numbers+ " Person(s).");
    }
    public Person(String name,int age , PersonSex sex){
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}

class Idol extends Person{
    private IdolSkill[] skill;
    public Idol(String name,int age,PersonSex sex,IdolSkill[] skill){
        super(name,age,sex);
        this.skill = skill;
    }

    public IdolSkill[] getSkill() {
        return skill;
    }

    public void setSkill(IdolSkill[] skill) {
        this.skill = skill;
    }
    static {
        System.out.println("Any idol here?");
    }
    @Override
    public String toString() {
        return "Idol{" +
                "name=" + super.getName() +
                ", age=" + super.getAge() +
                ", sex=" + super.getSex() +
                ", skill=" + skill +
                '}';

    }
}
final class Tara extends Idol{
    //使用【单例模式--懒汉模式】定义Tara
    //1.仍然构造器私有化
    //2.声明一个 static 静态属性对象
    //3.提供一个 public 的 static 方法，可以返回一個 Tara 對象
    //4.懒汉式，只有当用户使用getInstance 时，才返回 Tara 對象, 後面再次調用時，會返回上次創建的 Tara 對象
    private static final int GROUP_SIZE = 6;
    private static Tara tara;
    static {
        Person.addNumbers(GROUP_SIZE);
    }

    private Tara(String name, int age, PersonSex sex, IdolSkill[] skill) {
        super(name, age, sex, skill);
    }

    public static Tara getTaraInstance(){
        if(tara == null){
            tara = new Tara("T-ara",15,PersonSex.FEMALE, new IdolSkill[]{IdolSkill.SING,IdolSkill.DANCE});
        }
        return tara;
    }
    @Override
    public String toString() {
        return "Tara{" +
                "name=" + super.getName() +
                ", age=" + super.getAge() +
                ", sex=" + super.getSex() +
                ", skill=" + Arrays.toString(super.getSkill()) +
                ", groupSize=" +GROUP_SIZE +
                '}';
    }
}
final class Asoul extends Idol{
    //如何保障我们只能创建一个Asoul对象
    //步骤[单例模式-饿汉式]
    //1. 将构造器私有化
    //2. 在类的内部直接创建对象(该对象是static)
    //3. 提供一个公共的 static 方法，返回 asoul 对象
    //好处：
    private static final int GROUP_SIZE = 4;
    static {
        Person.addNumbers(GROUP_SIZE);
    }

    //2. 在类的内部直接创建对象(该对象是static)
    private static final Asoul ASOUL = new Asoul("A—SOUL",3,PersonSex.FEMALE,
            new IdolSkill[]{IdolSkill.PAINT,IdolSkill.GAME,IdolSkill.DANCE,IdolSkill.TALK,IdolSkill.SING});

    //1. 将构造器私有化
    private Asoul(String name, int age, PersonSex sex, IdolSkill[] skill) {
        super(name, age, sex, skill);
    }

    //3. 提供一个公共的 static 方法，返回 asoul 对象
    public static Asoul getAsoulInstance(){
        return ASOUL;
    }

    @Override
    public String toString() {
        return "Asoul{" +
                "name=" + super.getName() +
                ", age=" + super.getAge() +
                ", sex=" + super.getSex() +
                ", skill=" + Arrays.toString(super.getSkill()) +
                ", groupSize=" +GROUP_SIZE +
                '}';
    }
}
enum PersonSex{MALE, FEMALE}
enum IdolSkill{DANCE,SING,PAINT,TALK,GAME}