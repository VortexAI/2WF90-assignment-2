/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2wf90.assignment.pkg2;

/**
 *
 * @author s151810
 */
public class FinField extends Poly {
    
    Poly[] elements;
    int[] pol;
    int degree;
    int mod;
    int count;

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
    
    Poly[] getElements() {
        return elements;
    }
    
    int getDegree() {
        return degree;
    }
    
    String display(Poly f) {
        LongDivision div = new LongDivision();
        return div.run(f, this)[1].display();
    }
    
    Poly add (Poly f, Poly g) {
        LongDivision div = new LongDivision();
        return div.run(f.add(g), this)[1];
    }
    
    Poly subtract (Poly f, Poly g) {
        LongDivision div = new LongDivision();
        return div.run(f.subtract(g), this)[1];
    }
    
    Poly multiply (Poly f, Poly g) {
        LongDivision div = new LongDivision();
        return div.run(f.multiply(g), this)[1];
    }
    
}
