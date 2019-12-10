import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@ManagedBean(name = "Bean", eager = true)
@ApplicationScoped
public class Bean implements Serializable {
    private String x=null;
    private String y=null;
    private String r="1";
    private boolean r1=false;
    private boolean r2=false;
    private boolean r3=false;
    private boolean r4=false;
    private boolean r5=false;
    private boolean fromCanvas = false;

    public boolean isFromCanvas() {
        return fromCanvas;
    }

    public void setFromCanvas(boolean fromCanvas) {
        this.fromCanvas = fromCanvas;
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

    public boolean isR5() {
        return r5;
    }

    public void setR5(boolean r5) {
        this.r5 = r5;
    }




    public String getX(){
        return x;
    }
    public String getY(){
        return y;
    }
    public String getR(){
        return r;
    }
    private void setRFromBoolean(){
        if(r1) r="1";
        if(r2) r="1.5";
        if(r3) r="2";
        if(r4) r="2.5";
        if(r5) r="3";
    }

    public void setX(String x){
        if(x.isEmpty())
            return;
        double xd = Double.parseDouble(x.trim().replace(",","."));
        if(fromCanvas)
            this.x=String.format("%.2f",xd);
        else {
            if(xd>-4 && xd<4)
                this.x=String.format("%.2f",xd);
            else
                this.x="0";
        }
    }

    public void setY(String y){
        if(y.isEmpty())
            return;
        double yd = Double.parseDouble(y.trim().replace(",","."));
        if(fromCanvas)
            this.y=String.format("%.2f",yd);
        else {
            if(yd>-5 && yd<5)
                this.y=String.format("%.2f",yd);
            else
                this.y="0";
        }
    }

    Connection connection;


    public Connection getConnection(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection( "jdbc:postgresql://192.168.10.99:5432/postgres","postgres","b0nd2211");
        }catch(Exception e){
            System.out.println("Cannot connect to database!");
        }
        return connection;
    }

    public List<Dot> getDotList()throws  ClassNotFoundException, SQLException{
        Connection c = getConnection();
        List<Dot> list = new ArrayList<Dot>();
        PreparedStatement st = c.prepareStatement("select x, y, r, inArea from postgres.dots");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Dot d = new Dot(rs.getDouble("x"), rs.getDouble("y"), rs.getDouble("r"), rs.getBoolean("inArea"));
            list.add(d);
        }
        rs.close();
        st.close();
        c.close();
        return  list;
    }

    public String addToList(){
        setRFromBoolean();
        try{
            connection = getConnection();
            double parsedX = Double.parseDouble(x.replace(",","."));
            double parsedY = Double.parseDouble(y.replace(",","."));
            double parsedR = Double.parseDouble(r.replace(",","."));
            System.out.println(x +" " + y + " " + r);
            PreparedStatement st = connection.prepareStatement("INSERT INTO dots values(?, ?, ?, ?)");
            st.setDouble(1, parsedX);
            st.setDouble(2, parsedY);
            st.setDouble(3, parsedR);
            st.setBoolean(4, Dot.check(parsedX,parsedY,parsedR));
            st.executeUpdate();
            st.close();
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return "index.xhtml?faces-redirect=true";
    }

    public String toIndex() {
        return "index.xhtml?faces-redirect=true";
    }

    public String toTable() {
        return "table.xhtml?faces-redirect=true";
    }
}
