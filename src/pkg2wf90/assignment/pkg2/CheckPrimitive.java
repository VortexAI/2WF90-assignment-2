/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */;
package pkg2wf90.assignment.pkg2;
 
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stijn
 */
public class CheckPrimitive {

    public boolean run(FinField f, Poly input){
        int q = f.getDegree();

        Poly a = input;
        Poly one = new Poly(new int[]{1}, f.getMod());

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

        int i = 1;
        while(i <= primeDivisors.size()) {
            if (toThePower(a, (q - 1) / primeDivisors.get(i - 1), f.getMod()).equals(one)) {
                break;
            } else {
                i += 1;
            }
        }

        if(i < primeDivisors.size()){
            return false;
        } else{
            return true;
        }


    }

    public Poly toThePower(Poly a, int exponent, int mod){
        Poly power = new Poly(a.getPoly(), mod);

        for(int i=0; i<exponent-1; i++){
            power = power.multiply(a);
        }


        return power;
    }
}
