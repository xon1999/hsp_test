package com.hsp;

/**
 * @Author： zangaiyao
 * @Date： 2024/4/20 0:02
 * @Describe：
 */
public class Chapter8 {
    void testP279(){
        Vtuber asoul = new Vtuber("A-SOUL",12_000,true,teamTypes.ENTERPRISE);
        asoul.counts++;
        asoul.get();
        asoul.addSalary(6000);
        asoul.get();
        Profession t = new Vtuber("ava", 0, true, teamTypes.SOLO);
        //t.dance();// error 向上转型 父类的引用指向子类的对象 
                    //可以使用父类的所有成员（遵守访问权限） 不能使用子类特有的成员（编译阶段决定的）
        t.counts++;
        System.out.println(t instanceof Vtuber);//true
        System.out.println(t instanceof Profession);//true

        Vtuber b = (Vtuber) t;// 向下转型 要求：
                                //1.只能转换引用，不能转换对象
                                //2.转换的目标引用要指向目前所声明的编译类型对象
                                //3.向下转型后 可以调用子类所有的成员
        b.counts++;
        System.out.println(b.equals(t));// true
        System.out.println(b.equals(asoul));//false
        System.out.println(b instanceof Vtuber);//true
        System.out.println(b instanceof Profession);  //true 
        System.out.println(b.hashCode()==t.hashCode());//true 对象都是ava 引用不一样罢了        
        b.dance();
        System.out.println("asoul:"+asoul.getClass());
        System.out.println("t:"+t.getClass()); // getClass() return running Class
        System.out.println("b:"+b.getClass());
        System.out.println("asoul:"+asoul.counts);
        System.out.println(asoul.counts==b.counts?asoul.counts==t.counts?true:false:false);


    }
}
class Profession{
    String name;
    double meanSalary;
    boolean isNew;
    public static int counts = 0;
    public Profession(String name,double meanSalary,boolean isNew){
        this.isNew = isNew;
        this.name = name;
        this.meanSalary = meanSalary;
    }

    protected void addSalary(double addition){
        this.meanSalary += addition;
    }

    // 多态的应用 
    @Override
    public boolean equals(Object t) {
        if(this == t){return true;}
        if(t instanceof Profession){
            Profession p =(Profession) t;
        if(this.isNew == p.isNew&&this.name.equalsIgnoreCase(p.name)&&(Math.abs(this.meanSalary-p.meanSalary)<0.00001)){
            return true;
        }
    }
        return false;
    }
}

class Vtuber extends Profession{
    private final teamTypes teamType;
    public Vtuber(String name,double meanSalary,boolean isNew,teamTypes teamType){
        super(name, meanSalary, isNew);
        this.teamType = teamType;
    }

    void get(){
        System.out.println(this.isNew);
        System.out.println(this.name);
        System.out.println(this.meanSalary);
        System.out.println(this.teamType);
    }

    public teamTypes getTeamType() {
        return teamType;
    }

    //细节: 子类方法不能缩小父类方法的访问权限
    //public > protected > 默认>private
    @Override
    public void addSalary(double addition){
        this.meanSalary += addition*2;
    }

    public void dance(){
        System.out.println("Vtuber" +this.name +" almost can dance.");

    }


}

enum teamTypes{SOLO,ENTERPRISE;}