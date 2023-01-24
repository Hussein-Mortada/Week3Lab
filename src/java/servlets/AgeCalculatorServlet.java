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
            
            request.setAttribute("answer", "Invalid entry. You must give your current age.");
            
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                    .forward(request, response);
        }
        char c = age.charAt(0);
        if(Character.isLetter(c)||age.length()>3){
            request.setAttribute("answer", "Invalid entry. Please Enter a Digit."); //still needs error checking, can get around this validation by 
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp") //entering 0a - could use regex or something but not needed for scope
                    .forward(request, response);                                    // of lab i guess :P
        }
        newAge = Integer.parseInt(age)+1;
        request.setAttribute("answer", "Your new age will be "+newAge);   
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }
}
