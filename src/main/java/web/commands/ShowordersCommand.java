package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.CarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowordersCommand extends CommandProtectedPage{
   private CarportFacade carportFacade;
    public ShowordersCommand(String pageToShow, String role) throws UserException {
        super(pageToShow, role);
        this.carportFacade=new CarportFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        List<Order> orderList= carportFacade.getAllOrder();

      request.setAttribute("orderList",orderList);

        return pageToShow;
    }
}
