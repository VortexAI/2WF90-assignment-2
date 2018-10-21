/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2wf90.assignment.pkg2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author s166268
 */
public class FinFieldDivisionTest {
    
    public FinFieldDivisionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class FinFieldDivision.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Poly f = new Poly(new int[] {1}, 2);
        Poly g = new Poly(new int[] {}, 2);
        FinField field = new FinField(new int[] {1, 0, 1, 1}, 2);
        FinFieldDivision instance = new FinFieldDivision();
        Poly expResult = new Poly(new int[] {1}, 2);
        Poly result = instance.run(f, g, field);
        for (int i = 0; i < result.getPoly().length; i++) {
            //System.out.println("result: " + result.getPoly()[i].getVal());
        }
        System.out.println(result.getMod());
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
