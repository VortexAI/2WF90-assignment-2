package pkg2wf90.assignment.pkg2;

public class LongDivision{
    
    /** returns {q, r} for which f = q*g + r holds
     * 
     * @param f the first polynomial
     * @param g the second polynomial
     * @pre g != 0
     * @return the array {q, r}
     */
    Poly[] run(Poly f, Poly g){
        
        // Initiate all values
        Poly q = new Poly(new int[]{0},f.getMod());
        Poly tempPoly;
        Poly r = new Poly(f.getPoly(), f.getMod());
        Poly divisionPoly;
        int division;
        Poly zero = new Poly(new int[]{0}, f.getMod());
        int gDegree = g.degree();
        int rDegree = r.degree();
        
        // while deg(r) >= deg(g) and r != 0
        while (rDegree >= gDegree && !r.equals(zero)) {
            
            IntegerP rlc = r.leadingCoefficient(); // lc(r)
            IntegerP glc = g.leadingCoefficient(); // lc(g)
            
            // We take the ceiling of the division, as we are working in modulo
            division = (int) Math.ceil((double) rlc.getVal() / (double) glc.getVal()); 
            
            // we create a polynomial of the correct degree after division
            tempPoly = new Poly(polyCreator(rDegree - gDegree), f.getMod()); // Array in Stijn's implementation is reversed!!!
            
            // we combine the result of the division of the degree and lc's = t
            divisionPoly = tempPoly.multiply(new Poly(new int[]{division}, f.getMod()));
            
            q = q.add(divisionPoly); // q = q + t
            r = r.subtract(g.multiply(divisionPoly)); // r - gt
            rDegree = r.degree(); // update the new degree
        }
        Poly[] result = new Poly[]{q,r};
        return result;
    }
    
    /** Creates singleton polynomial array of given degree deg
     * 
     * @param deg the given degree
     * @return singleton polynomial array
     */    
    int[] polyCreator(int deg) {
        int[] result = new int[deg + 1];
        result[0] = 1; //// Array in Stijn's implementation is reversed!!!
        return result;
    }
    
    
}
