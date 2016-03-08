import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DoubleCalculatorTest {
//TODO: NIESKONCZONE

    zad2pack.DoubleCalculator dcalc = new DoubleCalculator();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {
        assertNotNull(dcalc.add(1,1));
        assertEquals(5, dcalc.add(2 , 3), 0);
        assertEquals(-5, dcalc.add(-2 , -3 ), 0);
        assertEquals(10, dcalc.add(10 , 0 ), 0);
        assertEquals(0, dcalc.add(0 ,0), 0);
        assertEquals(3, dcalc.add(1.5f , 1.5f ), 0);
        assertEquals(0, dcalc.add(-1.5f , 1.5f ), 0);
        assertEquals(2.2f , dcalc.add(1.1f , 1.1f ), 0);
    }

    @Test
    public void testSub() throws Exception {
        assertNotNull(dcalc.sub(1,1));
        assertEquals(-1, dcalc.sub(2,3), 0);
        assertEquals(1, dcalc.sub(-2,-3), 0);
        assertEquals(10, dcalc.sub(10,0), 0);
        assertEquals(0, dcalc.sub(0,0), 0);
        assertEquals(0.5f,dcalc.sub(0.8f , 0.3f), 0 );
    }

    @Test
    public void testMulti() throws Exception {
        assertNotNull(dcalc.multi(1,1));
        assertEquals(6, dcalc.multi(2,3));
        assertEquals(6, dcalc.multi(-2,-3));
        assertEquals(0, dcalc.multi(10,0));
        assertEquals(-9, dcalc.multi(3 ,-3));
    }

    @Test
    public void testDiv() throws Exception {
        assertNotNull(dcalc.div(1,1));
        assertEquals(3, dcalc.div(9,3));
        assertEquals(1, dcalc.div(1,1));
        assertEquals(0, dcalc.div(0,2));
        assertEquals(-1, dcalc.div(3 ,-3));
    }

    @Test
    public void testGreater() throws Exception {
        assertNotNull(dcalc.greater(2,1));
        assertNotNull(dcalc.greater(1,2));
        assertTrue(dcalc.greater(2,1));
        assertFalse(dcalc.greater(1,2));
        assertFalse(dcalc.greater(1,1));
    }
    @Test(expected=ArithmeticException.class)
    public void testDivWithZero() {
        dcalc.div(2,0);
    }
}