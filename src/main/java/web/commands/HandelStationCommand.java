package web.commands;
import business.exceptions.UserException;
import business.services.CarportFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HandelStationCommand extends CommandUnprotectedPage {
private CarportFacade carportFacade;
public HandelStationCommand(String pageToShow) throws UserException {
    super(pageToShow);
    this.carportFacade= new CarportFacade(database);
}
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) throws  UserException {
     boolean station;
     String answer= request.getParameter("station");

     if (answer.equals("accept"))
     {
         station= true;
         answer="accept";

     }else {
         answer="refuse";
         station=false;

     }
     try {

         int order_id = Integer.parseInt(request.getParameter("orderId"));
         carportFacade.updateOrderStation(order_id, station);
         request.setAttribute("answer", answer);
     } catch (NumberFormatException e){
         throw new UserException(""+e);
     }
    return pageToShow;
}
}
