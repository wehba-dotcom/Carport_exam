package web.commands;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.services.CarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowMyOrdersCommand extends CommandProtectedPage{
      private CarportFacade carportFacade;
    public ShowMyOrdersCommand(String pageToShow, String role) throws UserException {
        super(pageToShow, role);
        this.carportFacade= new CarportFacade(database);
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Order> orderList = carportFacade.getAllordersById(user.getId());
        request.setAttribute("orderslist",orderList);
        return pageToShow;
    }
}
