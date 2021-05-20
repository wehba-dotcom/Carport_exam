package business.persistence;

import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;

public class UserMapper
{
    private Database database;

    public UserMapper(Database database)
    {
        this.database = database;
    }

    public void createUser(User user) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO user (name,email,adress,phonenumber,balance,role, password) VALUES (?,?,?,?,?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getAdress());
                ps.setString(4, user.getPhonenumber());
                ps.setDouble(5,user.getBalance());
                ps.setString(6,user.getRole());
                ps.setString(7,user.getPassword());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setId(id);
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public User login(String email, String password) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM carportdb.user WHERE email=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {

                ps.setString(1, email);

                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String name = rs.getString("name");
                    String adress = rs.getString("adress");
                    String phonenumber = rs.getString("phonenumber");
                    double balance = rs.getDouble("balance");
                    String role = rs.getString("role");
                    int id = rs.getInt("user_id");

                    User user = new User(name, email, adress,phonenumber,balance,role,password);
                    user.setId(id);
                    return user;
                } else
                {
                    throw new UserException("Could not validate user");
                }
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