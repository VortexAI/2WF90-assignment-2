/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2wf90.assignment.pkg2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author s151810
 */
public class IntegerPTest {
    
    public IntegerPTest() {
    }

    /**
     * Test of getVal method, of class IntegerP.
     */
    @Test
    public void testGetVal() {
        System.out.println("getVal");
        IntegerP instance = new IntegerP(5,7);
        int expResult = 5;
        int result = instance.getVal();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class IntegerP.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        IntegerP val2 = new IntegerP(5, 7);
        IntegerP instance = new IntegerP(5,7);
        IntegerP expResult = new IntegerP(3,7);
        System.out.println("Result: " + expResult.getVal());
        IntegerP result = instance.add(val2);
        assertEquals(expResult.getVal(), result.getVal());
    }

    /**
     * Test of subtract method, of class IntegerP.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        IntegerP val2 = new IntegerP(4,7);
        IntegerP instance = new IntegerP(3,7);
        IntegerP expResult = new IntegerP(6,7);
        IntegerP result = instance.subtract(val2);
        System.out.println("Result: " + expResult.getVal());
        assertEquals(expResult.getVal(), result.getVal());
    }

    /**
     * Test of mult method, of class IntegerP.
     */
    @Test
    public void testMult() {
        System.out.println("mult");
        IntegerP val2 = new IntegerP(5, 7);
        IntegerP instance = new IntegerP(6,7);
        IntegerP expResult = new IntegerP(2,7);
        
        System.out.println("Result: " + expResult.getVal());
        IntegerP result = instance.mult(val2);
        assertEquals(expResult.getVal(), result.getVal());
    }
    
}
