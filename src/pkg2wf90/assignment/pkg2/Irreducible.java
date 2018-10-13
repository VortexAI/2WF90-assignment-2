package pkg2wf90.assignment.pkg2;

public class Irreducible {
    
    /** We check whether f is irreducible
     * 
     * @param f the polynomial to check
     * @pre deg(f) > 1
     * @return Boolean if f is irreducible
     */
    Boolean run(Poly f) {
        
        // Initialize all the values
        int n = f.degree();
        int q = f.getMod();
        int t = 1;
        int qt = 1;
        ExtendedEuclid EE = new ExtendedEuclid();
        int[] one = new int[1];
        one[0] = 1;
        Poly polyOne = new Poly(one, q);
        
        while (true) {
            qt = q * qt;
            int[] temp = new int[qt + 1];
            temp[qt] = 1; // Should be highest degree
            temp[1] = temp[1] - 1; // -X
            Poly gcd = EE.run(f, new Poly(temp, q))[2]; // gcd(f, X^(q^t) - X) 
            
            // if gcd != 1
            if (!gcd.equals(polyOne)) {
                break;
            }
            t++;
        }
        // if t == n then f is irreducible
        return t == n;
    }
}
