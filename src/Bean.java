import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@ManagedBean(name = "Bean", eager = true)
@ApplicationScoped
public class Bean implements Serializable {

    private String x = null;
    private String y = null;
    private String r = null;
    private boolean fromCanvas = false;



    public String getX(){
        return x;
    }
    public String getY(){
        return y;
    }
    public String getR(){
        return r;
    }

    public void setX(String x){
        if(x.isEmpty())
            return;
        if(fromCanvas)
            this.x=x;
        else {
            double xd = Double.parseDouble(x);
            if(xd>-4 && xd<4)
                this.x=x;
            else
                this.x="0";
        }
    }

    public void setY(String y){
        if(y.isEmpty())
            return;
        if(fromCanvas)
            this.y=y;
        else {
            double yd = Double.parseDouble(y);
            if(yd>-5 && yd<5)
                this.y=y;
            else
                this.y="0";
        }
    }

    public void setR(String r){
        if(r.isEmpty())
            return;
        if(fromCanvas)
            this.r=r;
        else {
            double rd = Double.parseDouble(r);
            if(rd>=1 && rd<=3)
                this.r=r;
            else
                this.r="";
        }
    }

    public void setIsFromCanvas(boolean b){
        this.fromCanvas=b;
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
        try{
            connection = getConnection();
            double parsedX = Double.parseDouble(x);
            double parsedY = Double.parseDouble(y);
            double parsedR = Double.parseDouble(r);
            PreparedStatement st = connection.prepareStatement("INSERT INTO dots(x, y, r, isInArea) values(?, ?, ?, ?)");
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
        return "view/index.xhtml?faces-redirect=true";
    }

    public String toIndex() {
        return "index.xhtml?faces-redirect=true";
    }

    public String toTable() {
        return "table.xhtml?faces-redirect=true";
    }
}
