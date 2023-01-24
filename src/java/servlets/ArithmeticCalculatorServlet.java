package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstnum = request.getParameter("firstNum");
        String secondnum = request.getParameter("secondNum");
        String operation=request.getParameter("operation");
        
       if(firstnum==null||firstnum.equals("")||secondnum==null||secondnum.equals("")){ //if null or empty say invalid
           request.setAttribute("result", "Invalid.");
           getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
               return;
       }
       for(int i=0;i<firstnum.length();i++){ //loop thru first num as string and see if any letters to say invalid
           char c=firstnum.charAt(i);
           if(!Character.isDigit(c)){
               request.setAttribute("result", "Invalid.");
               getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
               return;
           }
       }
       for(int i=0;i<secondnum.length();i++){ //loop thru second num as string and see if any letters to say invalid
           char c=secondnum.charAt(i);
           if(!Character.isDigit(c)){
               request.setAttribute("result", "Invalid.");
               getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
               return;
           }
       }
       int firstnumber=Integer.parseInt(firstnum);
       int secondnumber=Integer.parseInt(secondnum);
       
       if(operation.equals("+")){
           request.setAttribute("result", firstnumber+secondnumber);
           request.setAttribute("firstNum", firstnumber);
           request.setAttribute("secondNum", secondnumber);
               getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
               return;
       }
       else if(operation.equals("-")){
           request.setAttribute("result", firstnumber-secondnumber);
           request.setAttribute("firstNum", firstnumber);
           request.setAttribute("secondNum", secondnumber);
               getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
               return;
       }
       else if(operation.equals("*")){
           request.setAttribute("result", firstnumber*secondnumber);
           request.setAttribute("firstNum", firstnumber);
           request.setAttribute("secondNum", secondnumber);
               getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
               return;
       }
       else if(operation.equals("%")){
           request.setAttribute("result", secondnumber%firstnumber);
           request.setAttribute("firstNum", firstnumber);
           request.setAttribute("secondNum", secondnumber);
               getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
               return;
       }
    }
}
