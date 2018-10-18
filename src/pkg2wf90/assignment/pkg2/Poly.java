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
public class Poly {
    
    //the integerP array representing the polynomial and an integer mod
    private IntegerP[] poly;
    private int mod;
    
    //cosntructor that takes an integerP array and a mod
    Poly(int[] a, int mod){
        this.mod = mod;
        poly = new IntegerP[a.length];
        for(int i = 0; i < a.length; i++){
            poly[i] = new IntegerP(a[i], mod);
        }
    }
    
    //constructor that takes an integerP array and a mod
    Poly(IntegerP[] poly, int mod){
        this.poly = poly;
        this.mod = mod;
    }
    
    /**
     * returns the integer array representing the polynomial
     * @return {@code poly}
     */
    public IntegerP[] getPoly(){
        return poly;
    }
    
    /**
     * adds polynomial g to this polynomial
     * @param g polynomial to be added
     * @return {@code temp} 
     */
    Poly add(Poly g){
        IntegerP[] temp;
        
        if(g.getPoly().length > this.poly.length){
            temp = new IntegerP[g.getPoly().length];
            for(int i = poly.length; i < g.getPoly().length; i++){
                temp[i] = g.getPoly()[i];
            }
        } else {
            temp = new IntegerP[this.poly.length];
            for(int i = g.getPoly().length; i < poly.length; i++){
                temp[i] = poly[i];
            }
        }
        for(int i = 0; (i < Math.min(g.getPoly().length, poly.length)); i++){
            temp[i] = poly[i].add(g.getPoly()[i]);
        }
        
        return new Poly(temp, mod);
    }
    
    /**
     * subtracts polynomial g to this polynomial
     * @param g polynomial to be subtracted
     * @return {@code temp}
     */
    Poly subtract(Poly g){
        
        IntegerP[] temp;
        
        if(g.getPoly().length > this.poly.length){
            temp = new IntegerP[g.getPoly().length];
            for(int i = poly.length; i < g.getPoly().length; i++){
                temp[i] = new IntegerP(-g.getPoly()[i].getVal(), mod);
            }
        } else {
            temp = new IntegerP[this.poly.length];
            for(int i = g.getPoly().length; i < poly.length; i++){
                temp[i] = poly[i];
            }
        }
        for(int i = 0; (i < Math.min(g.getPoly().length, poly.length)); i++){
            temp[i] = poly[i].subtract(g.getPoly()[i]);
        }
        
        return new Poly(temp, mod);
    }
    
    /**
     * multiplies polynomial g with this polynomial
     * @param g polynomial to be multiplied with
     * @return {@code temp}
     */
    Poly multiply(Poly g){
        IntegerP[] temp = new IntegerP[1+g.degree()+this.degree()];
        for(int i = 0; i<temp.length;i++){
            temp[i] = new IntegerP(0, mod);
        }
        
        int degG = g.degree();
        int deg = this.degree();
        
        for(int i = 0; i <= deg; i++){
            for(int j = 0; j <= degG; j++){
                temp[i+j] = temp[i+j].add(g.getPoly()[j].mult(poly[i]));
            }
        }
        return new Poly(temp, mod);
    }
    
    /**
     * returns the leading coefficient of this poly
     * @return poly[this.degree()]
     */
    IntegerP leadingCoefficient(){
        return poly[this.degree()];
    }
    
    /**
     * function that returns the degree of this polynomial
     * @return result
     */
    int degree(){
        int result = 0;
        for(int i = poly.length-1; i>0; i--){
            if(poly[i].getVal() != 0){
                result = i;
                break;
            }
        }
        return result;
    }
    
    /**
     * returns whether this polynomial is equal to g
     * @param g polynomial to be compared with
     * @return g == this.poly
     */
    Boolean equals(Poly g){
        int degG = g.degree();
        if(g.degree() != this.degree()){
            return false;
        }
        for(int i = 0; i <= degG; i++){
            if(g.getPoly()[i].getVal() != poly[i].getVal()){
                return false;
            }
        }
        return true;
    }
    
    /**
     * returns mod
     * @return mod
     */
    int getMod(){
        return mod;
    }
    
    /**
     * returns the string representing this polynomial
     * @return result
     */
    String display(){
        int deg = degree();
        boolean firstNotNull = false;
        String result = null;
        for(int i = 0; i<=deg; i++){
            if(poly[i].getVal()!=0 && !firstNotNull){
                if (i==0){
                    result = poly[i].getVal() + "";
                    firstNotNull = true;
                } else if(i==1 && poly[i].getVal()!=1){
                    result = poly[i].getVal() + "X";
                    firstNotNull = true;
                } else if(i==1 && poly[i].getVal()==1){
                    result = "X";
                    firstNotNull = true;
                } else if(i>1 && poly[i].getVal()==1){
                    result = "X^" + i;
                    firstNotNull = true;
                } else {
                    result = poly[i].getVal() + "X^" + i;
                    firstNotNull = true;
                }
            } else if(poly[i].getVal()!=0 && firstNotNull){
                if(i==1 && poly[i].getVal()!=1){
                    result = poly[i].getVal() + "X+" + result;
                } else if(i==1 && poly[i].getVal()==1){
                    result = "X+" + result;
                } else if(i>1 && poly[i].getVal()==1){
                    result = "X^" + i + "+" + result;
                } else {
                    result = poly[i].getVal() + "X^" + i + "+" + result;
                }
            }
        }
        if(!firstNotNull){
            return "0";
        }
        return result;
    }
}
