
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "Bean", eager = true)
@ApplicationScoped
public class Bean implements Serializable {

    private String url = "jdbc:postgresql://pg:5432/studs";//Записываем url, в конце имя DB
    private String nameOfAdmin = "s263895";//Name
    private String pass = "vcf781";//Пароль

    private double x = 0;
    private double y = 0;
    private double r = 0;
    private boolean r1 = true; //Сделал true, чтобы при первой загрузке был выбран
    private boolean r2 = false;
    private boolean r3 = false;
    private boolean r4 = false;
    private boolean r5 = false;
    private boolean fromCanvas = false;


    List<Dot> list = new ArrayList<Dot>();

    public List<Dot> getList() throws SQLException, ClassNotFoundException {
        return getDotList();
    }

    public void setList(List<Dot> list) throws SQLException, ClassNotFoundException {
        this.list = getDotList();
    }

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


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    //    public String getR(){
//        return r;
//    }
    private void setRFromBoolean() {
        if (r1) r = 1;
        if (r2) r = 1.5;
        if (r3) r = 2;
        if (r4) r = 2.5;
        if (r5) r = 3;
    }

    public void setX(double x) {
        if (fromCanvas) {
            this.x = x;
        } else this.x = x / 10;

        fromCanvas=false;


    }


    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
        r1=false;
        r2=false;
        r3=false;
        r4=false;
        r5=false;


    }

    Connection connection;


    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver"); //Подключаем драйвер
            System.out.println("Драйвер загружен!");//Выводим сообщение
            connection = DriverManager.getConnection(url, nameOfAdmin, pass);//Устанавливаем соединение
            System.out.println("Соединение успешно установлено! ");//Сообщение о подключении
        } catch (Exception e) {
            e.printStackTrace(); //Выводим стректрейс ошибки
            System.out.println("Cannot connect to database!");
        }
        return connection;
    }

    public List<Dot> getDotList() throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
        list = new ArrayList<Dot>(); //Коллекция для хранения точек, нужна для извлечения данных из DB
        PreparedStatement st = c.prepareStatement("select x, y, r, inArea from studs");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Dot d = new Dot(rs.getDouble("x"), rs.getDouble("y"), rs.getDouble("r"), rs.getBoolean("inArea"));
            list.add(d);
        }
        rs.close();
        st.close();
        c.close();

        return list;
    }


    public String addToList() {


        setRFromBoolean(); //Устанавливаем R изходя из boolean значений
        x = Math.round(x * 100) / 100.0; //Округляем
        y = Math.round(y * 100) / 100.0;
        r = Math.round(r * 100) / 100.0;
        try {
            connection = getConnection();

            System.out.println(x + " " + y + " " + r);
            PreparedStatement st = connection.prepareStatement("INSERT INTO studs values(?, ?, ?, ?)");
            st.setDouble(1, x);
            st.setDouble(2, y);
            st.setDouble(3, r);
            st.setBoolean(4, Dot.check(x, y, r));
            st.executeUpdate();
            st.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }// todo это переход на начальную? зачем?
        return "application.xhtml?faces-redirect=true";
    }

    public String toIndex() {
        return "index.xhtml?faces-redirect=true";
    }

    public String toTable() {
        return "application.xhtml?faces-redirect=true";
    }
}
