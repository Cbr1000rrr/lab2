
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.random;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import model.Student;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 84375
 */
public class StudentServlet extends HttpServlet{
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String alphaAndalphaUpperCase=alpha+alphaUpperCase;
    private static Random generator = new Random();
     public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }
    public String randomAlphaAndAlphaUpperCase(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, alphaAndalphaUpperCase.length() - 1);
            char ch = alphaAndalphaUpperCase.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("student.jsp").forward(req, resp); 
    }
    public String RandomDate()//randomDate
    {
            Random random = new Random();
            int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
            int maxDay = (int) LocalDate.now().toEpochDay();
            long randomDay = minDay + random.nextInt(maxDay - minDay);
            LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
            return randomDate.toString();
    }
    public boolean randomBoolean()//randomBoolean
    {
        int random=randomNumber(0,1);
        if(random==0)
            return false;
        else
            return true;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out= resp.getWriter())
        {
            try
            {
                int count=1;
                ArrayList<Student> data = new ArrayList<>();
                int numberOfStudent=Integer.parseInt(req.getParameter("numberOfStudent"));
                for(int i=0;i<numberOfStudent;++i)
                {
                    int id=count;
                    ++count;
                    String name= randomAlphaAndAlphaUpperCase(randomNumber(4,7));
                    boolean gender=randomBoolean();
                    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                    Date date =f.parse(RandomDate());
                    data.add(new Student(id, name, gender, date));
                }
                req.setAttribute("data",data);
                req.getRequestDispatcher("student.jsp").forward(req, resp); 
            }
            catch(Exception e)
            {
                if(req.getParameter("numberOfStudent").isEmpty())
                {
                    out.print("Input is empty!"); 
                    return;
                }
                out.print("Input Not Valid!"); 
            }
        }

    }
    
}
