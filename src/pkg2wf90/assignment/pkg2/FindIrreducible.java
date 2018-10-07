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
    
    Poly run(int mod, int degree) {
        // Add test whether degree n > 0?
        int[] random = new int[degree];
        findIrr(random, 0, mod, degree);
        return answer;
    }
    
    Boolean findIrr(int[] random, int i, int mod, int degree) {
        if (i == degree + 1) {
            answer = new Poly(random, mod);
            return irreducible.run(answer);
        } else {
            int k = 0;
            if (i == degree) { // make sure that it has the correct degree
                k = 1;
            }
            for (int j = k; j < mod; j++) {
                random[i] = j;
                if (findIrr(random, i, mod, degree)) {
                    return true;
                }
            }
            return false;
        }
    }
}
