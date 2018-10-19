/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2wf90.assignment.pkg2;

/**
 *
 * @author s166268
 */
public class FinFieldDivision {
   
    public Poly run(Poly f, Poly g, FinField field) {
        Inverse inverse = new Inverse();
        Poly gInverse = inverse.run(field, g);
        return field.multiply(f, gInverse);
    }
}
