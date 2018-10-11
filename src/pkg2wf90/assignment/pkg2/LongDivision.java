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
public class LongDivision{
    
    Poly[] run(Poly f, Poly g){
        // Add catch for g == 0, not needed, is done beforehand?
        Poly q = new Poly(new int[]{0},f.getMod());
        Poly tempPoly;
        Poly r = new Poly(f.getPoly(), f.getMod());
        Poly divisionPoly;
        int division;
        Poly zero = new Poly(new int[]{0}, f.getMod());
        int gDegree = g.degree();
        int rDegree = r.degree();
        
        while (rDegree >= gDegree && !r.equals(zero)) {
            
            IntegerP rlc = r.leadingCoefficient();
            IntegerP glc = g.leadingCoefficient();
            division = (int) Math.ceil((double) rlc.getVal() / (double) glc.getVal());
            //System.out.println("r: " + r.display());
            //System.out.println("g: " + g.display());
            tempPoly = new Poly(polyCreator(rDegree - gDegree), f.getMod()); // Array in Stijn's implementation is reversed!!!
            //System.out.println("tempPol: " + tempPoly.display());
            divisionPoly = tempPoly.multiply(new Poly(new int[]{division}, f.getMod()));
            //System.out.println("divPol: " + divisionPoly.display());
            q = q.add(divisionPoly);
            r = r.subtract(g.multiply(divisionPoly));
            rDegree = r.degree();
        }
        Poly[] result = new Poly[]{q,r};
        return result;
    }
        
    int[] polyCreator(int deg) {
        int[] result = new int[deg + 1];
        /*for (int i = 0; i < deg; i++) {
            result[i] = 0;
        }*/
        result[0] = 1; //// Array in Stijn's implementation is reversed!!!
        return result;
    }
    
    
}
