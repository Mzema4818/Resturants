import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.sql.*;

//javac -cp sqlite-jdbc-3.23.1.jar; JuniorProject.java
//java -cp sqlite-jdbc-3.23.1.jar; JuniorProject

public class JuniorProject{
    public static void main(String [] args) throws IOException {
        int port = 8500;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        Database database = new Database("jdbc:sqlite:Restaurants.db");
        
        String query = "SELECT * FROM italian";
        String result = database.selectData(query);
        server.createContext("/italian", new RouteHandler(result));

        String query2 = "SELECT * FROM chinese";
        String result2 = database.selectData(query2);
        server.createContext("/chinese", new RouteHandler(result2));

        String query3 = "SELECT * FROM korean";
        String result3 = database.selectData(query3);
        server.createContext("/korean", new RouteHandler(result3));

        String query4 = "SELECT * FROM American";
        String result4 = database.selectData(query4);
        server.createContext("/american", new RouteHandler(result4));

        String query5 = "SELECT * FROM French";
        String result5 = database.selectData(query5);
        server.createContext("/french", new RouteHandler(result5));

        String query6 = "SELECT * FROM German";
        String result6 = database.selectData(query6);
        server.createContext("/german", new RouteHandler(result6));

        server.start();

        System.out.println("Server is listening on port " + port);
    }
}