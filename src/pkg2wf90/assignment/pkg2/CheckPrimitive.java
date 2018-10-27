/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2wf90.assignment.pkg2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stijn
 */
public class CheckPrimitive {

    public boolean run(FinField f, Poly input){
        //Get the order of the field
        int q = f.getElements().length;
        
        //Get the poly of the input to check for 0 polys
        IntegerP[] poly = input.getPoly();

        boolean zero = true;

        //Check if the poly is all zeros
        for(int i=0; i < poly.length; i++){
            if(poly[i].getVal() != 0){
                zero = false;
                break;
            }
        }
        //If all zeros return false
        if(zero){
            return false;
        }

        //Find all prime divisors of the Order - 1
        List<Integer> primeDivisors = new ArrayList<>();
        boolean isPrime = true;
        for(int i=2; i<q; i++){
            if((q-1)%i == 0){
                for(int j = 2; j <= i; j++){
                    if(i%j == 0){
                        if(i!=j) {
                            isPrime = false;
                        }
                    }
                }
                if(isPrime){
                    primeDivisors.add(i);
                }
            }
        }
        
        
        //The input poly and the Poly "One" for condition checking
        Poly a = input;
        Poly one = new Poly(new int[]{1}, f.getMod());
        //Main algorithm
        //Put a to the power of each our prime divisors and check if it is euqal to one.
        int i = 1;
        while(i <= primeDivisors.size()) {
            if (toThePower(a, (q - 1) / primeDivisors.get(i - 1), f.getMod(), f, one).equals(one)) {
                break;
            } else {
                i += 1;
            }
        }

        if(i <= primeDivisors.size()){
            return false;
        } else{
            return true;
        }


    }
    
    //Function used for exponantion. Multiplies a poly by itself for the size of the
    //exponent. If an intermediate power is found twice, a cycle is found to early and
    //we return a One poly so the main algorithm will evaluate to false. 
    
    public Poly toThePower(Poly a, int exponent, int mod, FinField f, Poly one){
        List<String> powers = new ArrayList<>();
        Poly power = new Poly(a.getPoly(), mod);


        for(int i=0; i<exponent-1; i++){
            power = f.multiply(power, a);
            if(powers.contains(power.display())){
                power = one;
                break;
            } else{
                powers.add(power.display());
            }

        }

        return power;
    }
}

