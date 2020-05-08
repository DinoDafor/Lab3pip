import java.io.Serializable;


public class Dot implements Serializable {

    protected double x;
    protected double y;
    protected double r;
    protected boolean inArea;


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
        if(x>=0 && y <=0 && x*x+y*y <=r*r/4) return true;
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
