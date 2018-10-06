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
        
        Poly q = new Poly(new int[]{0},f.getMod());
        Poly tempPoly;
        Poly r = f;
        Poly divisionPoly;
        int division;
        
        while (r.degree() >= g.degree() && !r.equals(0)) {
            tempPoly = new Poly(polyCreator(r.degree()-g.degree()),f.getMod());
            division = r.leadingCoefficient().getVal()/f.leadingCoefficient().getVal();
            divisionPoly = new Poly(new int[]{division},f.getMod());
            q = q.add(tempPoly.multiply(divisionPoly));
            tempPoly = new Poly(polyCreator(r.degree()-g.degree()),f.getMod());
            r = r.subtract(g.multiply(tempPoly.multiply(divisionPoly)));
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
