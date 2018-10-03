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
public abstract class LongDivision extends PolyFunc{
    
    Poly[] run(Poly f, Poly g){
        
        Poly q;
        Poly tempPoly;
        Poly r = f;
        
        while (r.degree() >= g.degree()) {
            tempPoly = new Poly(polyCreator(r.degree()-g.degree()),f.getMod());
            q = q + tempPoly.multiply(r.leadingCoefficient()/f.leadingCoefficient());
            tempPoly = new Poly(polyCreator(r.degree()-g.degree()),f.getMod());
            r = r - g.multiply(tempPoly.multiply(r.leadingCoefficient()/f.leadingCoefficient()));
        }
        Poly[] result = new Poly[]{q,r};
        return result;
    }
        
    int[] polyCreator(int deg) {
        int[] result = new int[deg + 1];
        for (int i = 0; i < deg; i++) {
            result[i] = 0;
        }
        result[deg] = 1;
        return result;
    }
    
    
}
