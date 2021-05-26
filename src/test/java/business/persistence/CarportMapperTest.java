package business.persistence;

import business.entities.Order;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CarportMapperTest {

    private final static String DATABASE = "carportdb";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "allord";
    private final static String PASSWORD = "allordone-1";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static UserMapper userMapper;
    private static CarportMapper carportMapper;



    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            userMapper = new UserMapper(database);
            carportMapper = new CarportMapper(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    void setUp() {
        // reset test database
        try ( Statement stmt = database.connect().createStatement() ) {
            stmt.execute("drop table if exists user" );
            stmt.execute("create table " + TESTDATABASE + ".user LIKE " + DATABASE + ".user;" );
            stmt.execute(
     "insert into user values (1,'wehba','jens@somewhere.com','bornholm','234324','678000','customer','123') ");



            stmt.execute("drop table if exists order" );
            stmt.execute("create table " + TESTDATABASE + ".order LIKE " + DATABASE + ".order;" );
            stmt.execute("insert into `order` values (1,12000,780,600,true)");



        } catch (SQLException ex) {
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }

    }

    @Test
    void insertOrder() throws UserException {
        Order order = new Order(71,1,10000,760.0,600.0,true);

        carportMapper.insertOrder(1,10000,760.0,600.0,true);
         assertEquals(71,order.getOrder_id());

    }
}