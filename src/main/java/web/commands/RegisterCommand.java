package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand extends CommandUnprotectedPage
{
    private UserFacade userFacade;

    public RegisterCommand(String pageToShow)
    {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String adress = request.getParameter("adress");
        String phonenumber = request.getParameter("phonenumber");
         double balance = Double.parseDouble(request.getParameter("balance"));
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        if (password1.equals(password2))
        {
            User user = userFacade.createUser(name,email,adress,phonenumber,balance,password1);
            HttpSession session = request.getSession();
            session.setAttribute("name",name);
            session.setAttribute("email", email);
            session.setAttribute("adress",adress);
            session.setAttribute("phonenumber",phonenumber);
            session.setAttribute("balance",balance);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            return user.getRole() + "page";
        }
        else
        {
            request.setAttribute("error", "the two passwords did not match");
            return "registerpage";
        }
    }

}
