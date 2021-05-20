package business.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcCarportTest {
        CalcCarport c1;
        double length;
        double width;
        CarportItem posts;

    @BeforeEach
    void setUp() {
c1 = new CalcCarport();
length=620.0;
width=400.0;

    }

    @Test
    void calacPostQ() {

        double expected =((length/310) + 1 ) * 2;
         double actual = c1.calacPostQ(620.0,400.0);
         assertEquals(expected,actual);
    }

    @Test
    void calacPostL() {
        double expected =300.0;
        double actual = c1.calacPostL(620.0,400.0);
        assertEquals(expected,actual);
    }

    @Test
    void calacRemQ() {
        double expected =2.0;
        double actual = c1.calacRemQ(620.0,400.0);
        assertEquals(expected,actual);
    }

    @Test
    void calacRemL() {

        double expected =620.0;
        double actual = c1.calacRemL(620.0,400.0);
        assertEquals(expected,actual);
    }

    @Test
    void calacRaftersQ() {

        double expected =length / 55;
        double actual = c1.calacRaftersQ(620.0,400.0);
        assertEquals(expected,actual);
    }

    @Test
    void calacRaftersL() {
        double expected =400.0;
        double actual = c1.calacRaftersL(620.0,400.0);
        assertEquals(expected,actual);
    }

    @Test
    void getPosts() {
      String des="";
      String info = "";

        double expected = 1822.0;
        posts= new CarportItem(6,300,des,info,(int)1822.0);
        double actual = posts.getPrice();
        assertEquals(expected,actual);
    }
}
