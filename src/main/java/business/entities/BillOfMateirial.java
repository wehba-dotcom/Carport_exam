package business.entities;

import java.util.ArrayList;
import java.util.List;

  public class BillOfMateirial {
    List<CarportItem> carportItemList= new ArrayList<>();

    public int getTotalPrice()
    {
        int total = 0;
        for (CarportItem item : carportItemList) {
            total =  total + item.getPrice();
        }
         return total;
    }
     public void addItem(CarportItem item)
     {
         carportItemList.add(item);
     }

      public List<CarportItem> getCarportItemList() {
          return carportItemList;
      }
  }
