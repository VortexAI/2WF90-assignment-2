package pkg2wf90.assignment.pkg2;

public class AddTable {
    
    /** Returns the addition table of the elements of the given field
     * 
     * @param f input field
     * @return 2D array of polynomials
     */
    Poly[][] run(FinField f) {
        
        // Initialization of the variables
        Poly[] elements = f.getElements();
        Poly[][] result = new Poly[elements.length][elements.length];
        LongDivision div = new LongDivision();
        
        // Loop over all elements of the field twice
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                // Do a field addition of every element with every element
                result[i][j] = f.add(elements[i], elements[j]);
            }
        }
        return result;
    }
}
