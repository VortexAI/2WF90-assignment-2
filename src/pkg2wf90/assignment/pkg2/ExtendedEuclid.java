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
public abstract class ExtendedEuclid extends PolyFunc{
    
    Poly[] run(Poly f, Poly g) {
        LongDivision division = new LongDivision();
        
        Poly q;
        Poly r;
        Poly x = new Poly(new int[]{1},f.getMod());
        Poly xPrime;
        Poly y = new Poly(new int[]{0},f.getMod());
        Poly yPrime;
        Poly v = new Poly(new int[]{1},f.getMod());
        Poly u = new Poly(new int[]{0},f.getMod());
               
        while (!g.equals(0)) {
            q = division.run(f,g)[0];
            r = division.run(f,g)[1];
            f = g;
            g = r;
            xPrime = x;
            yPrime = y;
            x = u;
            y = v;
            u = xPrime.subtract(q.multiply(u));
            v = yPrime.subtract(q.multiply(v));        
        }
        Poly[] result = new Poly[]{x,y,f};
        return result;
    }
    
}
