package pkg2wf90.assignment.pkg2;

public class Inverse {
    
    /** Returns the inverse of the given element in the given field
     * 
     * @param f The given field
     * @param a The given element of the field
     * @return 0 if inverse does not exist, else the inverse of a in f
     */
    Poly run (FinField f, Poly a) {
        
        // initialize variables
        ExtendedEuclid euclid = new ExtendedEuclid();
        Poly zero = new Poly(new int[]{0}, f.getMod());
        Poly one = new Poly(new int[]{1}, a.getMod());
        
        // obtain the gcd
        Poly[] result = euclid.run(a, f);
        Poly gcd = result[2];        

        if (gcd.equals(one)) {
            // return x of the euclidean algorithm
            return result[0];
        } else {
            return zero;
        }
    }
}
