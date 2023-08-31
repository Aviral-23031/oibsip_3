
import java.sql.*;
public class Conn {
    Statement statement;
    Connection c;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///bms","root","mysql@1312");
            statement = c.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
