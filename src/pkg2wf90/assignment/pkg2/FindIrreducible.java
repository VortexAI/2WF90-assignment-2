package pkg2wf90.assignment.pkg2;

public class FindIrreducible {
    Irreducible irreducible = new Irreducible();
    Poly answer;
    int[] random;
    int mod;
    int degree;
    
    /** Generate a irreducible polynomial of given degree in given mod
     * 
     * @param mod given modulo
     * @param degree given degree
     * @pre degree > 0
     * @return polynomial of given degree which is irreducible in given mod
     */
    Poly run(int mod, int degree) {
        random = new int[degree + 1];
        this.mod = mod;
        this.degree = degree;
        findIrr(0);
        return answer;
    }
    
    /** Generates a random polynomial of given degree and checks whether it is irreducible
     * 
     * @param i current index to update in random
     * @return true when an irreducible polynomial is found
     */
    Boolean findIrr(int i) {
        // if random is completely filled in, then check whether random is irreducible
        if (i == degree + 1) {
            random = reverse(random); // Array in Stijn's implementation is reversed!!!
            answer = new Poly(random, mod);
            return irreducible.run(answer);
        } else {
            int k = 0;
            
            // make sure that it has the correct degree
            if (i == degree) { 
                k = 1;
            }
            // go over all possible values in given modulo
            for (int j = k; j < mod; j++) {
                random[i] = j;
                if (findIrr(i + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    /** Reverses the given array
     * 
     * @param a given array
     * @return reversed array a
     */

}
