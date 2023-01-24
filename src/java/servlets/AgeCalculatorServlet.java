package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String age = request.getParameter("newAge");
        int newAge;
        
        if (age == null || age.equals("")) {
            try{
            newAge = Integer.parseInt(age);
            }catch (NumberFormatException ex) {
            request.setAttribute("answer", "Invalid entry. Please enter your age.");
            throw new NumberFormatException("Invalid Entry");
            }
            request.setAttribute("answer", "Invalid entry. Please enter your age.");
            
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                    .forward(request, response);
            return;
        }
        
        newAge = Integer.parseInt(age)+1;
        request.setAttribute("answer", "Your new age will be "+newAge);   
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }
}
