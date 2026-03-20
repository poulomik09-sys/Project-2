import java.io.*;//import input and outputs classes used in file and string handling
import jakarta.servlet.*;//import general servlet classes
import jakarta.servlet.http.*;//import http specific servlet classes
import java.util.*;//import utility classes liked lists and the arraylists
import jakarta.servlet.http.HttpServlet;//this is the base class to create the http servlet
import jakarta.servlet.http.HttpServletRequest;//used to get data from the client request
import jakarta.servlet.http.HttpServletResponse;//used to send response back to the client
import jakarta.servlet.http.HttpSession;//used to store user data across multiple request
public class AddToCartServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//doGet method used to handle the get request
    throws ServletException,IOExceptioition{//it is used to solve the servlet errors
        String book=request.getParameter("book");//help to get the value of the book from the url or the form
        HttpSession session=request.getSession();//used to create a data session
        List<String>cart=(List<String>)session.getAttribute("cart");//its a typecasting needed the session stores the object. it retrives the cart from the session.
        if(cart==null){//create a new empty cart
            cart=new ArrayList<>();
        }
        cart.add(book);//adding the books to the cart
        session.setAttribute("cart",cart);//store the updated cart back to the sessions.it helps to create the consistency across the pages.
        response.sendRedirect("index.jsp");//it redirects the user to index.jsp after adding the items. prevent duplicate submission if the page is referesh
    }
}
