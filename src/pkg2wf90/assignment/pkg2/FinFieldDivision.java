/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2wf90.assignment.pkg2;


public class FinFieldDivision {
   
    /** Returns the result of the division of 2 given polynomials of a field
    * 
    * @param f The first polynomial
    * @param g The second polynomial
    * @param field The given finite field
    */
    public Poly run(Poly f, Poly g, FinField field) {
        // compute division f/g by multiplying f by the inverse of g
        Inverse inverse = new Inverse();
        Poly gInverse = inverse.run(field, g);
        return field.multiply(f, gInverse);
    }
}
