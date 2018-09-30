import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BadgeServlet
 */
@WebServlet("/BadgeServlet")
public class BadgeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BadgeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");

        Params params = new Params();
        params.setMessage(request.getParameter("message"));
        params.setShape(request.getParameter("shape"));
        params.setColor(request.getParameter("color"));
        params.setBgColor(request.getParameter("BGColor"));
        params.setFgColor(request.getParameter("FGColor"));
        params.setX(request.getParameter("X"));
        params.setY(request.getParameter("Y"));
        params.setFtSize(request.getParameter("FTSize"));
        params.setFtStyle(request.getParameter("FTStyle"));

        // New variables
        params.setNX(request.getParameter("NX"));
        params.setNY(request.getParameter("NY"));

        //store the parameter into session and forward to web page
        HttpSession session = request.getSession();
        session.setAttribute("Params", params);


        RequestDispatcher dispatcher = request.getRequestDispatcher("Assignment_3.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

}
