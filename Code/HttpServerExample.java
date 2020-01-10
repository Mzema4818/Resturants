import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;

import java.net.InetSocketAddress;
import java.util.Map;

//javac HttpServerExample.java

public class HttpServerExample {

    public static void main(String[] args) throws IOException {
        int port = 8500;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        //First Route
        server.createContext("/", new RouteHandler("Hi Boss"));
        //second Route
        server.createContext("/student", new RouteHandler("Matthew"));
        //Third Route
		String html = "<html><body><center><div><p>Matthew <br> Zeman </p></div></center></body></html>";
        server.createContext("/mypage", new RouteHandler(html));
        //Fourth Route
        html = Input.readFile("ReadHTML.html");
        server.createContext("/ReadHTML", new RouteHandler(html));

        server.start(); 
        System.out.println("Server is listening on port " + port );
    }    
}
