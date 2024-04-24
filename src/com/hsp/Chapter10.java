
package com.hsp;

import java.sql.SQLOutput;
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
        System.out.println(Tara.getTaraInstance().getPosition());

    }

    void testP421(){
        Manager ming = new Manager("xiaoming",003,24_000,5000);
        CommonEmployee hei = new CommonEmployee("xiaohei",040,8_000);
        ming.work();
        hei.work();
    }
     void testP432(){
        Asoul asoul = Asoul.getAsoulInstance();
        asoul.dance();
     }

     void testP446(){
        Asoul asoul = Asoul.getAsoulInstance();
        Tara tara = Tara.getTaraInstance();
        // 接口的多态
        // 1.多态参数 接口多态（接口引用可以指向实现了接口的类的对象）
        printEntertainment(asoul);
        printEntertainment(tara);

        //2.多态数组 类似于类的多态
        EntertainmentMethods[] ens = new EntertainmentMethods[2];
        ens[0] = asoul;
        ens[1] = tara;
        for (EntertainmentMethods en : ens){
            en.dance();
            if(en instanceof Asoul){
                System.out.println(((Asoul)en).toString());
            }
         }

        //3. 多态传递 接口类型的变量可以指向实现了该接口的类的对象实例
        // 如果EntertainmentMethodsV2继承了EntertainmentMethods 接口
         // 而 Asoul 类实现了EntertainmentMethodsV2接口
         // 那么相当于Asoul 类也实现了EntertainmentMethods接口
        EntertainmentMethodsV2 emV2 = asoul;
        emV2.game();
        EntertainmentMethods em = asoul;
        em.sing();
     }

     void printEntertainment(EntertainmentMethods en){
        en.sing();
        en.dance();
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

    // final 2、父类的某个方法不希望被子类override重写时使用。
    public final String getPosition(){
        return "Entertainment";
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
                ", skill=" + Arrays.toString(skill) +
                '}';

    }
}

// final 1、不希望某个类被继承时修饰
//一般来说，如果一个类已经是final 类了，就没有必要再将方法修饰成final 方法
final class Tara extends Idol implements EntertainmentMethods{
    //使用【单例模式--懒汉模式】定义Tara
    //1.仍然构造器私有化
    //2.声明一个 static 静态属性对象
    //3.提供一个 public 的 static 方法，可以返回一個 Tara 對象
    //4.懒汉式，只有当用户使用getInstance 时，才返回 Tara 對象, 後面再次調用時，會返回上次創建的 Tara 對象
    //不提前创建对象浪费资源，但存在线程安全问题。


    // final 3、不希望某个属性的值被修改
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

    @Override
    public void sing() {
        System.out.println("Tara is singing..." );
    }

    @Override
    public void dance() {
        System.out.println("Tara is dancing..." );
    }

    @Override
    public void paint() {
        System.out.println("Tara is painting..." );
    }

    @Override
    public void talk() {
        System.out.println("Tara is talking..." );
    }


}
final class Asoul extends Idol implements EntertainmentMethodsV2{
    //如何保障我们只能创建一个Asoul对象
    //步骤[单例模式-饿汉式]
    //1. 将构造器私有化
    //2. 在类的内部直接创建对象(该对象是static)
    //3. 提供一个公共的 static 方法，返回 asoul 对象
    //好处：不存在线程安全问题，但存在对象未使用浪费资源问题。
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

    @Override
    public void sing() {
        System.out.println("Ava is singing 'Spring'");
    }

    @Override
    public void dance() {
        System.out.println("Bella is dancing with tara's background music.");

    }

    @Override
    public void paint() {
        System.out.println("Diana is painting a cute little strawberry.");

    }

    @Override
    public void talk() {
        System.out.println("Eileen is talking about her friend Ava's joking things.");

    }

    @Override
    public void game() {
        System.out.println("Ava is playing cyberpunk-2077 and going to pass it.");
    }
}




abstract class Employee {
    private String name;
    private int id;
    private double salary;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();
}

class Manager extends Employee{
    private double bonus;

    public Manager(String name, int id, double salary,double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("Manager is working...");

    }

    @Override
    public String toString() {
        return "Manager{" +
                "name=" +  super.getName()+
                ", id=" + super.getId() +
                ", salary=" + super.getSalary() +
                ", bonus=" + bonus +
                '}';
    }
}

class CommonEmployee extends Employee{

    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("Employee is working without bonus...");
    }
}

enum PersonSex{MALE, FEMALE}
enum IdolSkill{DANCE,SING,PAINT,TALK,GAME}

interface EntertainmentMethods {
    public void sing();
    public void dance();
    public void paint();
    public void talk();


}

interface EntertainmentMethodsV2 extends EntertainmentMethods{
    public void game();
}
