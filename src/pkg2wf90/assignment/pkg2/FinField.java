package pkg2wf90.assignment.pkg2;

public class FinField extends Poly {
    
    Poly[] elements; // elements of this field
    int degree; // degree of the field
    int mod; // modulo of the field
    
    int[] pol; // temp array
    int count; // temp count

    /** Constructor of the finite field class
     * 
     * @param a given int array
     * @param mod given modulo
     */
    FinField(int[] a, int mod){
        super(a, mod);
        degree = degree();
        this.mod = mod;
        int number = (int) Math.pow(this.mod, degree);
        elements = new Poly[number];
        pol = new int[degree];
        count = 0;
        generateElements(degree - 1);  
    }
    
    /** Generates all elements of the field
     * 
     * @param i the current element we are at
     */
    void generateElements(int i) {
        if (i == -1) {
            elements[count] = new Poly(pol, mod);
            count++;
        } else {
            for (int l = 0; l < mod; l++) {
                pol[i] = l;
                generateElements(i - 1);
            }
        }
        
    }
    
    /** Returns the elements of this field
     * 
     * @return elements
     */
    Poly[] getElements() {
        return elements;
    }
    
    /** Returns the degree of this field
     * 
     * @return degree
     */
    int getDegree() {
        return degree;
    }
    
    /** Displays an element in this field
     * 
     * @param f the given element
     * @return String of the element
     */
    String display(Poly f) {
        LongDivision div = new LongDivision();
        return div.run(f, this)[1].display();
    }
    
    /** Adds two elements in this field
     * 
     * @param f given polynomial 1
     * @param g given polynomial 2
     * @return (f+g) mod this
     */
    Poly add (Poly f, Poly g) {
        LongDivision div = new LongDivision();
        return div.run(f.add(g), this)[1];
    }
    
    /** Subtracts one polynomial from the other in this field
     * 
     * @param f given polynomial 1
     * @param g given polynomial 2
     * @return (f-g) mod this
     */
    Poly subtract (Poly f, Poly g) {
        LongDivision div = new LongDivision();
        return div.run(f.subtract(g), this)[1];
    }
    
    /** Multiplies two polynomials in this field
     * 
     * @param f given polynomial 1
     * @param g given polynomial 2
     * @return (f*g) mod this
     */
    Poly multiply (Poly f, Poly g) {
        LongDivision div = new LongDivision();
        return div.run(f.multiply(g), this)[1];
    }
    
}
