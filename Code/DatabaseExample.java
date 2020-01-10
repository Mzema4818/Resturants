import java.io.IOException;

import java.util.Map;
import java.sql.*;
//javac -cp sqlite-jdbc-3.23.1.jar; DatabaseExample.java

public class DatabaseExample {

    public static void main(String[] args) throws IOException {
        Database database = new Database("jdbc:sqlite:chinook.db");
        String query = "SELECT City FROM customers WHERE SupportRepId = 3";
        String result = database.selectData(query);

        System.out.println(result);
    }    

}
