
import java.sql.*;


class connessioneDB { 
  
    public static void main (String[] args)  { 
        try { 
            String url = "jdbc:mysql://127.0.0.1:3306/casotto";     //jdbc:msql://127.0.0.1:3306/casotto
            Connection conn = DriverManager.getConnection(url,"root","");   
            Statement st = conn.createStatement() ; 
            st.executeUpdate("INSERT INTO Ombrellone " + 
                "VALUES (2, 4, 6 )"); 
           
            conn.close(); 
        } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
        
    }
} 
