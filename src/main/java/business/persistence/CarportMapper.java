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
                    boolean station = rs.getBoolean("station");
                    orderList.add(new Order(order_id, user_id, price, length, width,station));
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
                            boolean station = rs.getBoolean("station");
                            orderList.add(new Order(order_id,user_id, price, length, width,station));
                        }
                          return orderList;
                    } catch (SQLException ex) {
                        throw new UserException(ex.getMessage());
                    }
                } catch (SQLException ex) {
                throw new UserException("Connection to database could not be established");
            }
        }
    public int insertOrder(int user_id , double price, double length, double width,boolean station) throws UserException
        {
             try (Connection connection = database.connect()) {
                   String sql = "INSERT INTO carportdb.order (user_id,price,length,width,station) values (?,?, ?, ?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1,user_id);
                ps.setDouble(2, price);
                ps.setDouble(3, length);
                ps.setDouble(4, width);
                ps.setBoolean(5,station);
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
    public int deletOrderById(int orderId) throws UserException
    {
        try (Connection connection = database.connect()) {
            String sql = "DELETE FROM carportdb.`order` WHERE order_id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1,orderId);
                int rawseffected = ps.executeUpdate();
                return rawseffected;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }
    public Order getOrderById(int order_id)throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT * from `order` WHERE `order`.order_id=?;";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int new_order_id = rs.getInt("order_id");
                    int user_id = rs.getInt("user_id");
                    double price = rs.getDouble("price");
                    double length = rs.getDouble("length");
                    double width = rs.getDouble("width");
                    boolean station = rs.getBoolean("station");
                    return new Order(new_order_id, user_id, price, length,width,station);
                }
                throw new UserException("Order findes ikke for order_id = " + order_id);
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }
    public int updateOrder(int order_id,int price)throws UserException
    {

        try (Connection connection = database.connect())
        {
            String sql = "UPDATE  carportdb.`order` SET price =?  WHERE order_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1,price);
                ps.setInt(2,order_id);

                int rowsinserted = ps.executeUpdate();
                return rowsinserted;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }
    public int updateOrderStation(int order_id,boolean station)throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "UPDATE  carportdb.`order` SET station =?  WHERE order_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setBoolean(1,station);
                ps.setInt(2,order_id);

                int rowsinserted = ps.executeUpdate();
                return rowsinserted;
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }
}

