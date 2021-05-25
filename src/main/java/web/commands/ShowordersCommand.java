package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.CarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowordersCommand extends CommandProtectedPage{
   private CarportFacade carportFacade;
    public ShowordersCommand(String pageToShow, String role) throws UserException {
        super(pageToShow, role);
        this.carportFacade = new CarportFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        List<Order> orderList = carportFacade.getAllOrder();
        request.setAttribute("orderList",orderList);
        String deleteId = request.getParameter("delete");
        String editid = request.getParameter("edit");
        String update = request.getParameter("update");
        if (deleteId  != null) {
            int rawseffected = carportFacade.deletOrderById(Integer.parseInt(deleteId));
            if (rawseffected > 0) {
                request.getServletContext().setAttribute("orderList", carportFacade.getAllOrder());
            } else {
                request.setAttribute("error", "we can not find this order !");
            }
        } else if (editid != null) {
            Order order=carportFacade.getOrderById(Integer.parseInt(editid));
            request.setAttribute("orderItem",order);
            return "editorderpage";
        } else if (update != null) {
            String orderId = request.getParameter("order_id");
            String  price = request.getParameter("price");
            int rowsinserted = carportFacade.updateOrder(Integer.parseInt(orderId),Integer.parseInt(price));
            if (rowsinserted == 1) {
                request.getServletContext().setAttribute("orderList", carportFacade.getAllOrder());
            }
        }
        return pageToShow;
    }
}
