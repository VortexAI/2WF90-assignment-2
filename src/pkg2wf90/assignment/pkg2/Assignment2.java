/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2wf90.assignment.pkg2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author s151810
 */
public class Assignment2 {
    
    final String[] polyFuncStrings = {"[display-poly]", "[add-poly]", 
        "[subtract-poly]", "[multiply-poly]", "[long-dif-poly]",
        "[euclid-poly]", "[equals-poly-mod]", "[irreducible]",
        "[find-irred]"};
    final Set polyFuncs = new HashSet<String>(Arrays.asList(polyFuncStrings));
    
    final String[] finFieldFuncStrings = {"[mod-poly]", "[add-table]", 
        "[mult-table]", "[display-field]", "[add-field]", "[subtract-field]",
        "[inverse-field]", "[division-field]"};
    
    private void run(String[] args) throws FileNotFoundException, IOException{
        //read desired file and start reading
        String file = System.getProperty("user.dir");
        
        file = file + "\\" + args[0];
        Scanner sc = new Scanner(new FileReader(file));
        
        FileWriter fw = new FileWriter("output.txt");
        BufferedWriter br = new BufferedWriter(fw);
        
        //main loop continues until end of the provided txt file
        while(sc.hasNext()){
            String a = sc.nextLine();
            //starts whenever a string is found starting with [radix]
            if(a.startsWith("[mod]")){ 
                br.write(a + System.getProperty("line.separator"));
                int mod = 0;
                
                Function func = null;
                
                mod = Integer.parseInt(a.split(" ")[a.split(" ").length-1]);
                String Assignment = sc.nextLine();
                if(!Assignment.equals("[mod-poly]")){//polynomial opperations
                    
                    if(Assignment.equals("[display-poly]")){
                        
                    } 
                    
                    
                } else { //finite field operations
                    
                }
                //create instance of the correct function
                /*if(Assignment.equals("[add]")){
                    func = new AddSub(true);    
                } else if(Assignment.equals("[subtract]")){
                    func = new AddSub(false);
                } else if(Assignment.equals("[multiply]")){
                    func = new EzMult();
                } else if(Assignment.equals("[karatsuba]")){
                    func = new Karatsuba();
                } else if(Assignment.equals("[reduce]")) {
                    func = new Reduce();
                } else if(Assignment.equals("[inverse]")){
                    func = new Invert();
                } else if (Assignment.equals("[euclid]")){
                    func = new Euclid();
                } else {
                    br.write("wrong assignment given" +System.getProperty("line.separator") + System.getProperty("line.separator"));
                }
                
                if(func != null){
                    br.write(Assignment + System.getProperty("line.separator"));
                    a = sc.nextLine();
                    //While loop that checks for parameters x, y and m. Stops when
                    //no lines are left to be examined.
                    while(!sc.hasNext() || !a.trim().isEmpty()){
                        if(a.startsWith("[x]")){
                            String[] xl = a.split(" ");
                            x = xl[xl.length-1];
                            br.write(a + System.getProperty("line.separator"));
                        }
                        if(a.startsWith("[y]")){
                            String[] yl = a.split(" ");
                            y = yl[yl.length-1];
                            br.write(a + System.getProperty("line.separator"));
                        }
                        if(a.startsWith("[m]")){
                            String[] m1 = a.split(" ");
                            m = m1[m1.length-1];
                            br.write(a + System.getProperty("line.separator"));
                        }
                        if(sc.hasNext()){
                            a = sc.nextLine();
                        
                        } else {
                        break;
                        }
                    }
                
                
                
                
                    
                    //intialize the required numbers
                    Number num1 = new Number(x, radix, !x.startsWith("-"));
                    Number num2 = null;
                    Number numM = null;
                    if (y != null){
                        num2 = new Number(y, radix, !y.startsWith("-"));
                    }
                    
                    if (m != null){
                        numM = new Number(m, radix, !m.startsWith("-"));
                    }
                
                    //write all results
                    try {
                        num3 = func.run(num1, num2, numM);
                        //done for all functions except euclid
                        if(!(func.getClass()== Euclid.class)){
                            br.write("[answer] ");
                            for(char d: num3.getChars()){
                                br.write(d);
                            }
                            br.write(System.getProperty("line.separator"));
                        }
                
                        //only done for primary school multiplication and
                        //karatsuba
                        if((func.getClass() == EzMult.class)||(func.getClass() == Karatsuba.class)){
                            br.write("[count-add] " + num3.getCountAdd() + System.getProperty("line.separator"));
                            br.write("[count-mul] " + num3.getCountMult() + System.getProperty("line.separator"));
                        }
                        
                        //only done for euclid
                        if(func.getClass() == Euclid.class){
                            br.write("[answer-d] " + new String(num3.getD().getChars()) + System.getProperty("line.separator"));
                            
                            br.write("[answer-a] " + new String(num3.getA().getChars()) + System.getProperty("line.separator"));
                            br.write("[answer-b] " + new String(num3.getB().getChars()) + System.getProperty("line.separator"));
                        }
                    } catch (Exception e) {
                        br.write("exception " + e + " thrown");
                    } 
                
                    br.write(System.getProperty("line.separator"));
                } */
            }
        }
        
        br.flush();
    }
    
    //TODO
    String displayPoly(Poly a){
        boolean not0 = false;
        String result = null;
        
        
        
        return result;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        new Assignment2().run(args);
    }
    
}
