/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2wf90.assignment.pkg2;

/**
 *
 * @author Th3LightShadow
 */
public class polyEqualMod extends PolyFunc{
    
    boolean run(Poly f, Poly g, Poly h) {
        LongDivision division = new LongDivision();
        
        f = division.run(f,h)[1];
        g = division.run(g,h)[1];
        
        boolean result = f.equals(g);
        return result;
    }
}
