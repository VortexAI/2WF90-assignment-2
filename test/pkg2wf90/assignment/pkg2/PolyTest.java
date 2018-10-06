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
public class PolyTest {
    
    public PolyTest() {
    }

    /**
     * Test of getPoly method, of class Poly.
     */
    @Test
    public void testGetPoly() {
        System.out.println("getPoly");
        Poly instance = new Poly(new int[] {1,3,2}, 7);
        IntegerP[] expResult = null;
        IntegerP[] result = instance.getPoly();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Poly.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Poly g = new Poly(new int[] {1,2,3}, 7);
        Poly instance = new Poly(new int[]{6,2,6}, 7);
        
        Poly expResult = new Poly(new int[]{0,4,2}, 7);
        for(IntegerP a : expResult.getPoly()){
            System.out.print(a.getVal() + " ");
        }
        System.out.println();
        Poly result = instance.add(g);
        for(IntegerP a : result.getPoly()){
            System.out.print(a.getVal() + " ");
        }
        System.out.println();
        for(int i = 0; i <= expResult.degree(); i++){
            assertEquals(result.getPoly()[i].getVal(), expResult.getPoly()[i].getVal());
        }
    }

    /**
     * Test of subtract method, of class Poly.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        Poly g = new Poly(new int[] {6,2,6}, 7);
        Poly instance = new Poly(new int[]{1,2,3}, 7);
        
        Poly expResult = new Poly(new int[]{2,0,4}, 7);
        for(IntegerP a : expResult.getPoly()){
            System.out.print(a.getVal() + " ");
        }
        System.out.println();
        Poly result = instance.subtract(g);
        for(IntegerP a : result.getPoly()){
            System.out.print(a.getVal() + " ");
        }
        System.out.println();
        for(int i = 0; i <= expResult.degree(); i++){
            assertEquals(result.getPoly()[i].getVal(), expResult.getPoly()[i].getVal());
        }
    }

    /**
     * Test of multiply method, of class Poly.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        Poly g = new Poly(new int[]{1,1,1}, 10);
        Poly instance = new Poly(new int[]{2,2}, 10);
        
        Poly expResult = new Poly(new int[]{2,4,4,2}, 10);
        for(IntegerP a : expResult.getPoly()){
            System.out.print(a.getVal() + " ");
        }
        System.out.println();
        Poly result = instance.multiply(g);
        for(IntegerP a : result.getPoly()){
            System.out.print(a.getVal() + " ");
        }
        System.out.println();
        for(int i = 0; i <= expResult.degree(); i++){
            assertEquals(result.getPoly()[i].getVal(), expResult.getPoly()[i].getVal());
        }
    }

    /**
     * Test of leadingCoefficient method, of class Poly.
     */
    @Test
    public void testLeadingCoefficient() {
        System.out.println("leadingCoefficient");
        Poly instance = null;
        IntegerP expResult = null;
        IntegerP result = instance.leadingCoefficient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of degree method, of class Poly.
     */
    @Test
    public void testDegree() {
        System.out.println("degree");
        Poly instance = new Poly(new int[]{0,0,0,0,1,2,3}, 10);
        int expResult = 2;
        int result = instance.degree();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Poly.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Poly g = new Poly(new int[]{1,2,3},10);
        Poly instance = null;
        Boolean expResult = null;
        Boolean result = instance.equals(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testDisplay(){
        System.out.println("display");
        Poly g = new Poly(new int[]{1,2,3},10);
        String result = "X^2+2X+3";
        System.out.println(g.display());
        assertEquals(g.display(), result);
    }
    
}
