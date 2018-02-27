package TeaCollector;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class MysqlCon {    
    Connection conn = null;    
    public static Connection ConnectDB(){        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/janakadb","root","");
            System.out.println("Connection Established");
            return conn;            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }    
}
