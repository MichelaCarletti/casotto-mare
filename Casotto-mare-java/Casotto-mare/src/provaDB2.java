import java.sql.*;


//import java.sql.DriverManager;
//import java.util.Calendar;

/**
 * A Java MySQL PreparedStatement INSERT example.
 * Demonstrates the use of a SQL INSERT statement against a
 * MySQL database, called from a Java program, using a
 * Java PreparedStatement.
 * 
 * Created by Alvin Alexander, http://alvinalexander.com
 */
public class provaDB2
{

  public static void main(String[] args)
  {
    try
    {
      // create a mysql database connection
      String myDriver = "com.mysql.cj.jdbc.Driver"; //org.gjt.mm.mysql.Driver //com.mysql.jdbc.Driver
      String myUrl = "jdbc:mysql://localhost:3306/casotto";  // jdbc:mysql://localhost:3306/casottoDB
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
    
      // create a sql date object so we can use it in our INSERT statement
      // Calendar calendar = Calendar.getInstance();
      //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

      // the mysql insert statement
      String query = " insert into Ombrellone (costo_ombrellone, posizione_ombrellone, id_ombrellone)"
        + " values (?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setDouble (1, 1.1);
      preparedStmt.setInt (2, 3);
      preparedStmt.setInt (3, 6);
    

      // execute the preparedstatement
      preparedStmt.execute();
      
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
}

