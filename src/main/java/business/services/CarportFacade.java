package business.services;

import business.entities.CarportItem;
import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.CarportMapper;
import business.persistence.Database;

import java.util.List;

public class CarportFacade {

   private CarportMapper carportMapper;
   public CarportFacade(Database database) throws UserException
   {
     this.carportMapper= new CarportMapper(database);

   }
    public int insertOrder(int user_id , double price, double length, double width) throws UserException
{
    return carportMapper.insertOrder(user_id,price,length,width);

}
   public List<Order> getAllOrder() throws UserException
   {
     return   carportMapper.getAllorders();
   }

    public List<Order> getAllordersById(int userid) throws UserException
    {
        return carportMapper.getAllordersById(userid);
    }
    public void insertCarportItem(int order_id, CarportItem item) throws UserException
    {
        carportMapper.insertCarportItem(order_id, item);
    }
}
