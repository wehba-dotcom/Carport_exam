package business.entities;

   public class CarportItem {

       private int order_id;
       private int item_id;
       private int qauntity;
      private int  length;
      private String description;
      private String info;
      private int price;

       public CarportItem(int order_id, int item_id, int qauntity, int length, String description, String info, int price) {
           this.order_id = order_id;
           this.item_id = item_id;
           this.qauntity = qauntity;
           this.length = length;
           this.description = description;
           this.info = info;
           this.price = price;
       }

       public CarportItem(int quantity, int length, String description, String info, int price) {
        this.qauntity = qauntity;
        this.length = length;
        this.description = description;
        this.info = info;
        this.price = price;
    }



       public int getOrder_id() {
           return order_id;
       }

       public void setOrder_id(int order_id) {
           this.order_id = order_id;
       }

       public int getItem_id() {
           return item_id;
       }

       public void setItem_id(int item_id) {
           this.item_id = item_id;
       }

       public int getPrice() {
        return price;
    }

    public int getQauntity() {
        return qauntity;
    }

    public void setQauntity(int qauntity) {
        this.qauntity = qauntity;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
