package business.entities;


   public class CalcCarport {

   public Double calacPostQ(Double length,Double carportWidth)
   {
      Double Postgauntity= ((length/310)+1) * 2;
       return  Postgauntity;
   }
    public Double calacPostL(Double carportLength,Double carportWidth)
    {
        Double postLength= 300.0 ;
        return postLength;
    }
    public CarportItem getPosts(Double carportLength,Double carportWidth)
    {
      int postqauntity =(int)Math.round(calacPostQ(carportLength,carportWidth));
      int postlength =(int)Math.round(calacPostL(carportLength,carportWidth));
      int price =  (int) (postqauntity * carportLength /100 * 49);  // stolper koster 49 kr pr. meter
      String info = "Stolper nedgraves 90 cm. i jord";
      String description = "Posts 45x95";
      CarportItem posts=new CarportItem(0, 9,postqauntity,postlength,description,info,price);

     /*  bill.addItem(item1);
      update new item (posts)
      double price1=qauntity1*item1.getPrice();*/

        return posts;
    }
    public Double calacRemQ(Double carportLength,Double carportWidth)
    {
        return 2.0;
    }
    public Double calacRemL(Double carportLength,Double carportWidth)
    {
        return carportLength;
    }
    public CarportItem getRem(Double carportLength,Double carportWidth)
    {

        /*`Clac Remerne*/
        int remqauntity = (int)Math.round(calacRemQ(carportLength,carportWidth));
        int remlength = (int)Math.round(calacRemL(carportLength,carportWidth));
        String info= "Remme i sider, sadles ned i stolper ";
        String description="rem 90x45";
        int price = (int) (remqauntity * carportLength/100 * 39);  // Rem koster 49 kr pr. meter
        CarportItem rem = new CarportItem(0, 49, remqauntity,remlength,description,info,price);
        /* bill.addItem(rem1);
        update new item (Rem)
        String rem="";
        double price2=qauntity2*500;
        Item  item2=new Item(item_id,rem,"over posts",price2);*/

        return rem;
    }

    public Double calacRaftersQ(Double carportLength,Double carportWidth)
    {
        Double raftergauntity = (carportLength / 55)  ;
        return  raftergauntity;
    }
    public Double calacRaftersL(Double carportLength , Double carportWidth)
    {
        Double rafterlength = carportWidth ;
        return rafterlength;
    }
    public CarportItem getRafters(Double carportLength,Double carportWidth )
    {
        int rafterqauntity = (int)Math.round(calacRaftersQ(carportLength,carportWidth));
        int rafterlength = (int)Math.round(calacRaftersL(carportLength,carportWidth));
        String info  = "Spær, monteres på rem ";
        String description ="rafters 90x90";
        int price= (int) (rafterqauntity * carportLength / 100 * 39);  // Spær koster 49 kr pr / meter.
        CarportItem rafters=new CarportItem(0, 64, rafterqauntity,rafterlength,description,info,price);
        /*bill.addItem(rafters1);
        String refters="";
        double price3=qauntity3*400;
        Item  item3=new Item(item_id,refters,"take alot of picese",price3);*/
        return rafters;
    }


}
