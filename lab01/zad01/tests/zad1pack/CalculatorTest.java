package zad1pack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CalculatorTest {


    Calculator calc = new Calculator();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {
        assertNotNull(calc.add(1,1));
        assertEquals(5, calc.add(2,3));
        assertEquals(-5, calc.add(-2,-3));
        assertEquals(10, calc.add(10,0));
        assertEquals(0, calc.add(0,0));
    }

    @Test
    public void testSub() throws Exception {
        assertNotNull(calc.sub(1,1));
        assertEquals(-1, calc.sub(2,3));
        assertEquals(1, calc.sub(-2,-3));
        assertEquals(10, calc.sub(10,0));
        assertEquals(0, calc.sub(0,0));
    }

    @Test
    public void testMulti() throws Exception {
        assertNotNull(calc.multi(1,1));
        assertEquals(6, calc.multi(2,3));
        assertEquals(6, calc.multi(-2,-3));
        assertEquals(0, calc.multi(10,0));
        assertEquals(-9, calc.multi(3 ,-3));
    }

    @Test
    public void testDiv() throws Exception {
        assertNotNull(calc.div(1,1));
        assertEquals(3, calc.div(9,3));
        assertEquals(1, calc.div(1,1));
        assertEquals(0, calc.div(0,2));
        assertEquals(-1, calc.div(3 ,-3));
    }

    @Test
    public void testGreater() throws Exception {
        assertNotNull(calc.greater(2,1));
        assertNotNull(calc.greater(1,2));
        assertTrue(calc.greater(2,1));
        assertFalse(calc.greater(1,2));
        assertFalse(calc.greater(1,1));
    }
    @Test(expected=ArithmeticException.class)
    public void testDivWithZero() {
        calc.div(2,0);
    }
}