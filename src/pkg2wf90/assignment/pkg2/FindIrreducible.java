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
public class FindIrreducible {
    Irreducible irreducible = new Irreducible();
    Poly answer;
    int[] random;
    int mod;
    int degree;
    
    Poly run(int mod, int degree) {
        // Add test whether degree n > 0?
        random = new int[degree + 1];
        this.mod = mod;
        this.degree = degree;
        findIrr(0);
        return answer;
    }
    
    Boolean findIrr(int i) {
        if (i == degree + 1) {
            random = reverse(random); // fix stijn's fuckery!
            answer = new Poly(random, mod);
            return irreducible.run(answer);
        } else {
            int k = 0;
            if (i == degree) { // make sure that it has the correct degree
                k = 1;
            }
            for (int j = k; j < mod; j++) {
                random[i] = j;
                if (findIrr(i + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    int[] reverse(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[a.length - 1 - i] = a[i];
        }
        return b;
    }
}
