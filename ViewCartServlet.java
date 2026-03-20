import java.io.*;//import input and outputs classes used in file and string handling
import jakarta.servlet.*;//import general servlet classes
import jakarta.servlet.http.*;//import http specific servlet classes
import java.util.*;//import utility classes liked lists and the arraylists
import jakarta.servlet.http.HttpServlet; // this is the base class to create the http servlet
import jakarta.servlet.http.HttpServletRequest;  // used to get data from the client request
import jakarta.servlet.http.HttpServletResponse;//used to send response back to the client
import jakarta.servlet.http.HttpSession;//used to store user data across multiple request
public class ViewCartServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException,IOException{
        HttpSession session = request.getSession();
        List<String> cart = (List<String>) session.getAttribute("cart");
        response.setContentType("text/html");//tells the browser the response is html form/content.
        PrintWriter out = response.getWriter();//it helps you to send output to the browser.
        out.println("<h2>Your Cart</h2>");
        if(cart != null){// if not null then print each and every book 
            for(String book : cart){
                out.println(book + "<br>");
            }
        }else{
            out.println("Cart is empty");
        }
    }
}
