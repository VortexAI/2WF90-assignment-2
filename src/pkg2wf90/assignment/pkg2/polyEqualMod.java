package pkg2wf90.assignment.pkg2;

public class polyEqualMod{
    
    /** We check whether f mod h == g mod h
     * 
     * @param f polynomial 1
     * @param g polynomial 2
     * @param h polynomial 3
     * @return Boolean f mod h == g mod h
     */
    boolean run(Poly f, Poly g, Poly h) {
        
        // We add a check for zero, as modulo zero is not possible we return false
        Poly zero = new Poly(new int[]{0}, f.getMod());
        if (h.equals(zero)) {
            return false;
        }
        
        LongDivision division = new LongDivision();
        
        // We check the remainders after the division
        f = division.run(f,h)[1];
        g = division.run(g,h)[1];
        
        // We return whether they are equal
        return f.equals(g);
    }
}
