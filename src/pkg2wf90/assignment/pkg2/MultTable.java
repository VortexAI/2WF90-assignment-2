package pkg2wf90.assignment.pkg2;

public class MultTable {
    
    Poly[][] run(FinField f) {
        
        Poly[] elements = f.getElements();
        Poly[][] result = new Poly[elements.length][elements.length];
        LongDivision div = new LongDivision();
        
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                result[i][j] = f.multiply(elements[i], elements[j]);
            }
        }
        return result;
    }
}
