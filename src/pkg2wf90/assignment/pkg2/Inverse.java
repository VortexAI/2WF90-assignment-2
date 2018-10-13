package pkg2wf90.assignment.pkg2;

public class Inverse {
    
    Poly run (FinField f, Poly a) {
        ExtendedEuclid euclid = new ExtendedEuclid();
        Poly[] result = euclid.run(a, f);
        Poly gcd = result[2];
        Poly one = new Poly(new int[]{1}, a.getMod());
        if (gcd.equals(one)) {
            return result[0];
        } else {
            return new Poly(new int[]{0}, -1);
        }
    }
}
