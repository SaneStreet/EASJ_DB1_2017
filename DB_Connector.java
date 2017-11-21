import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {
//    declare a connection
    private static Connection con = null;
//    declare JDBC driver
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static String db = "ThisDatabase";
//    the url = jdbc:dbms://host name:port#/db name
    private static String url = "jdbc:mysql://localhost:3306/";
//    declare user name
    private static String usr = "root";
//    declare password
    private static String pswrd = "12345";

//		 Create the connection method
    public static Connection connect(){
        System.out.println("--Connecting to MySQL JDBC--");

//    Locate MySQL JDBC Driver
        try{
            Class.forName(DRIVER);
            System.out.println("\n--MySQL JDBC Driver registered--");
        }
//    Catch exceptions if JDBC is not found
        catch(ClassNotFoundException ex){
            System.out.println("\n--JDBC is missing--");
            ex.printStackTrace();
        }
//    Connect to MySQL DB = URL, usrName, pswrd
        try{
            con = DriverManager.getConnection(url, usr, pswrd);
            System.out.println("\n--Connecting to MySQL--");
        }
//    Catch exceptions on connection error
        catch(SQLException ex){
            System.out.println("\n--Did not connect - try again--");
            ex.printStackTrace();
        }
//    if connection successful
        if(con != null){
            System.out.println("\n--Connection successful--");
        }
//    if connection fails
        else{
            System.out.println("\n--Connection failed--");
        }
        return con;
    }
}