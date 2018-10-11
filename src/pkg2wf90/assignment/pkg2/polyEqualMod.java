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
public class polyEqualMod{
    
    boolean run(Poly f, Poly g, Poly h) {
        // Add catch for h == 0
        Poly zero = new Poly(new int[]{0}, f.getMod());
        if (h.equals(zero)) {
            return false;
        }
        LongDivision division = new LongDivision();
        
        f = division.run(f,h)[1];
        g = division.run(g,h)[1];
        
        return f.equals(g);
    }
}
