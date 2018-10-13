package pkg2wf90.assignment.pkg2;

public class ExtendedEuclid{
    
    /** Computes {a, b, d} for which a*f + b*g = d
     * 
     * @param f first polynomial
     * @param g second polynomial
     * @return the array {a, b, d}
     */
    Poly[] run(Poly f, Poly g) {
        LongDivision division = new LongDivision();
        
        // initiate all values
        Poly q;
        Poly r;
        Poly x = new Poly(new int[]{1},f.getMod());
        Poly xPrime;
        Poly y = new Poly(new int[]{0},f.getMod());
        Poly yPrime;
        Poly v = new Poly(new int[]{1},f.getMod());
        Poly u = new Poly(new int[]{0},f.getMod());
        Poly zero = new Poly(new int[]{0}, f.getMod());
        
        // While g != 0
        while (!g.equals(zero)) {
            Poly[] div = division.run(f,g);
            q = div[0]; // set the quotient
            r = div[1]; // set the remainder
            f = g;
            g = r;
            xPrime = x;
            yPrime = y;
            x = u;
            y = v;
            u = xPrime.subtract(q.multiply(u)); // u = x' - qu
            v = yPrime.subtract(q.multiply(v)); // v = y' - qv
        }
        // Now we have to divide by the leading coefficient of the gcd to get the correct result
        Poly constant = new Poly(new IntegerP[]{f.leadingCoefficient()}, f.getMod());
        Poly[] result = new Poly[3]; 
        result[0] = division.run(x, constant)[0];
        result[1] = division.run(y, constant)[0];
        result[2] = division.run(f, constant)[0];
        return result;
    }
    
}
