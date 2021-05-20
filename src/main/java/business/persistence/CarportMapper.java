package business.persistence;

import business.entities.CarportItem;
import business.entities.Order;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarportMapper {
    private Database database;


    public CarportMapper(Database database) {
        this.database = database;
    }

    public List<Order> getAllordersById(int id) throws UserException {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM carportdb.`order` where user_id=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    int user_id = rs.getInt("user_id");
                    Double price = rs.getDouble("price");

                    double length = rs.getDouble("length");
                    double width = rs.getDouble("width");
                    orderList.add(new Order(order_id, user_id, price, length, width));

                }
                } catch (SQLException ex)
                {
                    throw new UserException(ex.getMessage());
                }
            } catch (SQLException ex) {
                throw new UserException("Connection to database could not be established");
            }
                    return orderList;
        }
        public List<Order> getAllorders () throws UserException
        {
            List<Order> orderList = new ArrayList<>();
                try (Connection connection = database.connect()) {

                    String sql = "SELECT * FROM carportdb.`order` ";

                    try (PreparedStatement ps = connection.prepareStatement(sql)) {
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            int order_id = rs.getInt("order_id");
                            int user_id = rs.getInt("user_id");
                            double price = rs.getDouble("price");

                            double length = rs.getDouble("length");
                            double width = rs.getDouble("width");
                            orderList.add(new Order(order_id,user_id, price, length, width));

                        }
                    } catch (SQLException ex) {
                        throw new UserException(ex.getMessage());
                    }
                } catch (SQLException ex) {
                throw new UserException("Connection to database could not be established");
            }
            return orderList;
        }

    public int insertOrder(int user_id , double price, double length, double width) throws UserException
        {
             try (Connection connection = database.connect()) {
                   String sql = "INSERT INTO carportdb.order (user_id,price,length,width) values (?, ?, ?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setInt(1,user_id);
                ps.setDouble(2, price);


                ps.setDouble(3, length);
                ps.setDouble(4, width);
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                return id;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
            } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }


    public void insertCarportItem(int order_id, CarportItem item) throws UserException
    {

        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO carportdb.carport_item (order_id,item_id,qauntity,length,description,info,price) values (?,?,?,?, ?, ?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setInt(1,order_id);
                ps.setInt(2,item.getItem_id());
                ps.setInt(3, item.getQauntity());
                ps.setInt(4, item.getLength());
                ps.setString(5,item.getDescription());
                ps.setString(6, item.getInfo());
                ps.setInt(7, item.getPrice());
                ps.executeUpdate();


            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }
}

