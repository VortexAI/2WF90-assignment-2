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
public class IntegerP {
    private int val;
    private int mod;
    
    IntegerP(int val, int mod){
        if((val%mod <0)){
            this.val = (val%mod)+mod;
            this.mod = mod;
        } else {
            this.val = val%mod;
            this.mod = mod;
        }
    }
    
    int getVal(){
        return val;
    }
    
    /**
     * adds val2 to this IntegerP
     * @param val2 IntegerP to be added
     */
    void add(IntegerP val2){
        if((this.val + val2.getVal())<0){
            this.val = (this.val + val2.getVal())%mod + mod;
        } else {
            this.val = (this.val + val2.getVal())%mod;
        }
    }
    
    /**
     * subtracts val 2 from this IntegerP
     * @param val2 number to be subtracted by
     */
    void subtract(IntegerP val2){
        if((this.val - val2.getVal())<0){
            this.val = (this.val - val2.getVal())%mod + mod;
        } else {
            this.val = (this.val - val2.getVal())%mod;
        }
    }
    
    /**
     * multiplies this InteregerP by val2
     * @param val2 the number to be mulitplied with
     */
    void mult(IntegerP val2){
        if((this.val * val2.getVal())<0){
            this.val = (this.val * val2.getVal())%mod + mod;
        } else {
            this.val = (this.val * val2.getVal())%mod;
        }
    }
}
