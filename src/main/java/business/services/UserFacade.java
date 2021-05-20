package business.services;

import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

public class UserFacade
{
    UserMapper userMapper;

    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) throws UserException
    {
        return userMapper.login(email, password);
    }

    public User createUser(String name,String email, String adress,String phonenumber,double balance, String password) throws UserException
    {

        User user = new User(name,email,adress,phonenumber,balance,"customer", password);
        userMapper.createUser(user);
        return user;
    }

}
