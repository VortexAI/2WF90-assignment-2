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
        System.out.println(q);
        Poly a = input;
        Poly one = new Poly(new int[]{1}, f.getMod());

        List<Integer> primeDivisors = new ArrayList<>();
        boolean isPrime = true;
            for(int i=2; i<q; i++){
                System.out.println("Entered check prime loop");
                if((q-1)%i == 0){
                    System.out.println("Found divisor");
                    for(int j = 2; j <= i; j++){
                        if(i%j == 0){
                            System.out.println("Found divisor of divisor");
                            System.out.println("i:" + i + " j:" + j);
                            if(i!=j) {
                                isPrime = false;
                            }
                        }
                    }
                    if(isPrime){
                        System.out.println("Adding to prime divisors");
                        primeDivisors.add(i);
                    }
            }
        }

        int i = 1;
        while(i <= primeDivisors.size()) {
            System.out.println(a.equals(one));
            if (toThePower(a, (q - 1) / primeDivisors.get(i - 1), f.getMod()).equals(one)) {
                System.out.println("Power == 1");
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
        System.out.println(exponent);
        Poly power = new Poly(a.getPoly(), mod);

        for(int i=0; i<exponent-1; i++){
            power = power.multiply(a);
        }


        return power;
    }
}
