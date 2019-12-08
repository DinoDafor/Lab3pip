import java.io.Serializable;


public class Dot implements Serializable {



    //Не ебу как с одним полем сделать
    private boolean r1;
    private boolean r2;
    private boolean r3;
    private boolean r4;
    private boolean r5;

    public boolean isR5() {
        return r5;
    }

    public void setR5(boolean r5) {
        this.r5 = r5;
    }

    public boolean isR1() {
        return r1;
    }

    public void setR1(boolean r1) {
        this.r1 = r1;
    }

    public boolean isR2() {
        return r2;
    }

    public void setR2(boolean r2) {
        this.r2 = r2;
    }

    public boolean isR3() {
        return r3;
    }

    public void setR3(boolean r3) {
        this.r3 = r3;
    }

    public boolean isR4() {
        return r4;
    }

    public void setR4(boolean r4) {
        this.r4 = r4;
    }

    private double x;
    private double y;
    private double r;
    private boolean inArea;


    public Dot(double x, double y, double r, boolean inArea) {
        this.x = x;
        this.y = y;
        this.r = r;

        this.inArea = inArea;
    }
    public Dot() {
    }

    public static boolean check(double x, double y, double r){
        if(x<=0&&y<=0 && x>=-r&&y>=-r) return true;
        if(x<=0 && y>=0 && y<= x*2+r) return true;
        if(x>=0 && y <=0 && x*x+y*y <r*r/4) return true;
        return false;
    }

    public double getX() {
        System.out.println("Зашли в getX Dot class ");
        System.out.println("Здесь X равен " + x);
        return x;
    }

    public double getY() {
        System.out.println("Зашли в getY Dot class ");
        System.out.println("Здесь Y равен " + y);
        return y;
    }

    public double getR() {
//        System.out.println("Зашли в getR Dot class ");
//        System.out.println("Здесь R равен " + r);
        return r;
    }

    public boolean isInArea() {
        return inArea;
    }

    public void setX(double x) {
        this.x=x;
    }

    public void setY(double y) {
        this.y=y;
    }

    public void setR(double r) {
        this.r=r;
    }

    public void setIsInArea(boolean inArea) {
        this.inArea=inArea;
    }
}
