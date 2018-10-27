/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2wf90.assignment.pkg2;

/**
 *
 * @author stijn
 */

public class FindPrimitive {
    CheckPrimitive cp = new CheckPrimitive();
    
    //Loop over all elements of the field and check if they are primitive
    public String run(FinField f){
        Poly[] elements = f.getElements();
        for(int i=0; i < elements.length;i++){
            if(cp.run(f, elements[i])){;
                return elements[i].display();
            }
        }
        //Return ERROR is no primitive found
        return "ERROR";
    }


}

