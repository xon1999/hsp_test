package com.hsp;

/**
 * @Author： zangaiyao
 * @Date： 2024/4/20 0:02
 * @Describe：
 */
public class Chapter8 {
    void testP279(){
        Vtuber asoul = new Vtuber("A-SOUL",12_000,true,teamTypes.ENTERPRISE);
        asoul.get();
        asoul.addSalary(6000);
        asoul.get();
    }
}
class Profession{
    String name;
    double meanSalary;
    boolean isNew;
    public Profession(String name,double meanSalary,boolean isNew){
        this.isNew = isNew;
        this.name = name;
        this.meanSalary = meanSalary;
    }

    protected void addSalary(double addition){
        this.meanSalary += addition;
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

}

enum teamTypes{SOLO,ENTERPRISE;}