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

    FinField(int[] a, int mod){
        super(a, mod);
        degree = degree();
        this.mod = mod;
        int number = (int) Math.pow(this.mod, degree);
        elements = new Poly[number];
        pol = new int[degree];
        generateElements(0, 0);    
    }
    
    void generateElements(int i, int j) {
        if (i == degree + 1) {
            pol = reverse(pol); // fix stijn's fuckery!
            elements[j] = new Poly(pol, mod);
            j++;
        } else {
            for (int l = 0; l < mod; l++) {
                pol[i] = l;
                generateElements(i + 1, j);
            }
        }
        
    }
    
    int[] reverse(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[a.length - 1 - i] = a[i];
        }
        return b;
    }
    
    Poly[] getElements() {
        return elements;
    }
    
    int getDegree() {
        return degree;
    }
    
    Poly display(Poly f) {
        LongDivision div = new LongDivision();
        return div.run(f, this)[1];
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
    
    Poly[] divide (Poly f, Poly g) {
        LongDivision div = new LongDivision();
        Poly one = div.run(f, this)[1];
        Poly two = div.run(g, this)[1];
        return div.run(one, two);
    }
}
