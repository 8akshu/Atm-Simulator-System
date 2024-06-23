
package bank.management.system;

import java.sql.*;
import java.io.Closeable;


public class Conn implements AutoCloseable
{
    
    Connection c ;
    Statement s;
    
    public Conn()
    {
       try
       {
           //crete connection
           //Class.forName(com.mysql.cj.jdbc.Driver);
          c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Sher");
          //create statement
          s = c.createStatement();
          
          
          
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }
     
    
    @Override
    public void close() 
    {
        new Conn().close();
    } 
    
}
