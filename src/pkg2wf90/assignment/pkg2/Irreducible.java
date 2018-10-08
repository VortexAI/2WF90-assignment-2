/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2wf90.assignment.pkg2;

/**
 *
 * @author Rowin
 */
public class Irreducible {
    Boolean run(Poly f) {
        // Add test whether degree n > 1?
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
            temp[qt] = 1;
            temp[1] = temp[1] - 1;
            Poly gcd = EE.run(f, new Poly(temp, q))[0];
            if (!gcd.equals(polyOne)) {
                break;
            }
            t++;
        }
        return t == n;
    }
}
