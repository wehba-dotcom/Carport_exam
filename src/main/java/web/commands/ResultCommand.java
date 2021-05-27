package web.commands;
import business.entities.*;
import business.exceptions.UserException;
import business.services.CarportFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
    public class ResultCommand extends CommandUnprotectedPage {
    private CarportFacade carportFacade;
    public ResultCommand(String pageToShow) throws UserException {
        super(pageToShow);
        this.carportFacade= new CarportFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws  UserException {
        HttpSession session = request.getSession();
     double length;
     double width;
     int user_id;
     User user = (User) session.getAttribute("user");
     if (user != null)
     {
         user_id = user.getId();
     } else
     {
         throw new UserException("You must login first !");
     }

     try {
      width = Double.parseDouble(request.getParameter("width"));
      length = Double.parseDouble(request.getParameter("length"));

     }catch (Exception x)
     {
       throw new UserException("you must test to numbers in the forms!");
     }
        //update Posts
        BillOfMateirial bill = new BillOfMateirial();
        CalcCarport calcCarport = new CalcCarport();
        CarportItem posts = calcCarport.getPosts(length,width);
        bill.addItem(posts);
       //Update remene.
       CarportItem rem = calcCarport.getRem(length,width);
       bill.addItem(rem);
        //Update Referts
       CarportItem referts= calcCarport.getRafters(length,width);
       bill.addItem(referts);
        //sent responde to jsp side
        request.setAttribute("length",(int)Math.round(length));
        request.setAttribute("width",(int)Math.round(width));
        request.setAttribute("bill",bill);
        //get all prices of Carport meteriales.
        int price = bill.getTotalPrice();
        // update new order and put it in the data base.
        int ny_order_id =   carportFacade.insertOrder(user_id,price,length,width,true);
        for (CarportItem item : bill.getCarportItemList() ) {
            carportFacade.insertCarportItem(ny_order_id, item);
          }
        request.setAttribute("OrderID", ny_order_id);
        return pageToShow;
    }
}
