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
                int deg = 0;
                a = a.replace("\t", " ");
                mod = Integer.parseInt(a.split(" ")[a.split(" ").length-1]);
                
                String Assignment = sc.nextLine();
                br.write(Assignment + System.getProperty("line.separator"));
                
                if(!Assignment.startsWith("[mod-poly]")){//polynomial opperations
                    // polynomials used in the operations
                    Poly f = null;
                    Poly g = null;
                    Poly h = null;
                    //scan all polynomials required for all operations
                    a = sc.nextLine();
                    while(!sc.hasNext() || !a.trim().isEmpty()){
                        if(a.startsWith("[f]")){
                            br.write(a + System.getProperty("line.separator"));
                            a = a.substring(3);
                            String fx = a.trim();
                            fx = fx.substring(1, fx.length()-1);
                            String[] fxs = fx.split(",");
                            int[] pol = new int[fxs.length];
                            if(fx.length() == 0){
                                pol = new int[1];
                                pol[0] = 0;
                            } else {
                                for(int i = 0; i < fxs.length; i++){
                                    pol[i] = Integer.parseInt(fxs[i]);
                                }
                            }
                            pol = reverse(pol);
                            f = new Poly(pol, mod);
                        } else if (a.startsWith("[g]")){
                            br.write(a + System.getProperty("line.separator"));
                            a = a.substring(3);
                            String gx = a.trim();
                            gx = gx.substring(1, gx.length()-1);
                            String[] gxs = gx.split(",");
                            int[] pol = new int[gxs.length];
                            if(gx.length() == 0){
                                pol[0] = 0;
                            } else {
                                for(int i = 0; i < gxs.length; i++){
                                    pol[i] = Integer.parseInt(gxs[i]);
                                }
                            }
                            pol = reverse(pol);
                            g = new Poly(pol, mod);
                        } else if (a.startsWith("[h]")){
                            br.write(a + System.getProperty("line.separator"));
                            a = a.substring(3);
                            String hx = a.trim();
                            hx = hx.substring(1, hx.length()-1);
                            String[] hxs = hx.split(",");
                            int[] pol = new int[hxs.length];
                            
                            if(hx.length() == 0){
                                pol[0] = 0;
                            } else {
                                for(int i = 0; i < hxs.length; i++){
                                    pol[i] = Integer.parseInt(hxs[i]);
                                }
                            }
                            pol = reverse(pol);
                            h = new Poly(pol, mod);
                        } else if (a.startsWith("[deg]")) {
                            br.write(a + System.getProperty("line.separator"));
                            a = a.replace("\t", " ");
                            deg = Integer.parseInt(a.split(" ")[a.split(" ").length-1]);
                        }
                        if(sc.hasNext()){
                            a = sc.nextLine();
                            
                        } else {
                        break;
                        }
                    }
                    
                    
                    if(Assignment.equals("[display-poly]")){
                        //display poly
                        br.write("[answer] " + f.display() + System.getProperty("line.separator"));
                        br.write(System.getProperty("line.separator"));
                        
                    } else if (Assignment.equals("[add-poly]")){
                        //add poly
                        br.write("[answer] " + (f.add(g)).display() + System.getProperty("line.separator"));
                        br.write(System.getProperty("line.separator"));
                        
                    } else if (Assignment.equals("[subtract-poly]")){
                        //execute subtract poly
                        br.write("[answer] " + (f.subtract(g)).display() + System.getProperty("line.separator"));
                        br.write(System.getProperty("line.separator"));
                        
                    } else if (Assignment.equals("[multiply-poly]")){
                        //execute multiply poly
                        br.write("[answer] " + (f.multiply(g)).display() + System.getProperty("line.separator"));
                        br.write(System.getProperty("line.separator"));
                        
                    } else if (Assignment.equals("[long-div-poly]")){
                        //execute long division a polynomial zero is given to 
                        //be able to compare to zero
                        Poly zero = new Poly(new int[]{0}, f.getMod());
                        if (g.equals(zero)) {
                            br.write("[answ-q] " + "ERROR" + System.getProperty("line.separator"));
                            br.write("[answ-r] " + "ERROR" + System.getProperty("line.separator"));
                        } else {
                            LongDivision div = new LongDivision();
                            Poly[] result = div.run(f, g);
                            br.write("[answ-q] " + result[0].display() + System.getProperty("line.separator"));
                            br.write("[answ-r] " + result[1].display() + System.getProperty("line.separator"));
                        }
                        br.write(System.getProperty("line.separator"));
                        
                    } else if (Assignment.equals("[euclid-poly]")){
                        //execute eulcids algorithm
                        ExtendedEuclid euc = new ExtendedEuclid();
                        Poly[] result = euc.run(f, g);
                        br.write("[answ-a] " + result[0].display() + System.getProperty("line.separator"));
                        br.write("[answ-b] " + result[1].display() + System.getProperty("line.separator"));
                        br.write("[answ-d] " + result[2].display() + System.getProperty("line.separator"));
                        br.write(System.getProperty("line.separator"));
                        
                    } else if (Assignment.equals("[equals-poly-mod]")){
                        //check if the polynomials are equal modulo some integer
                        polyEqualMod epm = new polyEqualMod();
                        boolean result = epm.run(f, g, h);
                        if (result) {
                            br.write("[answer] " + "TRUE" + System.getProperty("line.separator"));
                        } else {
                            br.write("[answer] " + "FALSE" + System.getProperty("line.separator"));
                        }
                        br.write(System.getProperty("line.separator"));
                        
                    } else if (Assignment.equals("[irreducible]")){
                        //check if the provided polynomial is irreducible
                        Irreducible irr = new Irreducible();
                        boolean result = irr.run(f);
                        if (result) {
                            br.write("[answer] " + "TRUE" + System.getProperty("line.separator"));
                        } else {
                            br.write("[answer] " + "FALSE" + System.getProperty("line.separator"));
                        }
                        br.write(System.getProperty("line.separator"));
                        
                    } else if (Assignment.equals("[find-irred]")){
                        
                        FindIrreducible firr = new FindIrreducible();
                        Poly result = firr.run(mod, deg); //Change to [deg]!
                        br.write("[answer] " + result.display() + System.getProperty("line.separator"));
                        br.write(System.getProperty("line.separator"));
                        
                    }
                    
                    
                } else { //finite field operations
                    //finite field that is used for all arithmatic
                    FinField field = null;
                    
                    a = Assignment.substring(10);
                    
                    //get the mod-poly and init the finite field
                    String zx = a.trim();
                    zx = zx.substring(1, zx.length()-1);
                    String[] zxs = zx.split(",");
                    int[] pol = new int[zxs.length];
                    if(zx.length() == 0){
                        pol[0] = 0;
                    } else {
                        for(int i = 0; i < zxs.length; i++){
                            pol[i] = Integer.parseInt(zxs[i]);
                        }
                    } 
                    pol = reverse(pol);
                    field = new FinField(pol, mod);
                    
                    
                    Assignment = sc.nextLine();

                    br.write(Assignment + System.getProperty("line.separator"));
                    
                    Poly f = null;
                    Poly g = null;
                    Poly h = null;
                    //check all polys and initilize the poly objects
                    a = sc.nextLine();
                    while(!sc.hasNext() || !a.trim().isEmpty()){
                        if(a.startsWith("[a]")){
                            br.write(a + System.getProperty("line.separator"));
                            a = a.substring(3);
                            String fx = a.trim();
                            fx = fx.substring(1, fx.length()-1);
                            String[] fxs = fx.split(",");
                            int[] pol2 = new int[fxs.length];
                            if(fx.length() == 0){
                                pol2 = new int[1];
                                pol2[0] = 0;
                            } else {
                                for(int i = 0; i < fxs.length; i++){
                                    pol2[i] = Integer.parseInt(fxs[i]);
                                }
                            }
                            pol2 = reverse(pol2);
                            f = new Poly(pol2, mod);
                        } else if (a.startsWith("[b]")){
                            br.write(a + System.getProperty("line.separator"));
                            a = a.substring(3);
                            String gx = a.trim();
                            gx = gx.substring(1, gx.length()-1);
                            String[] gxs = gx.split(",");
                            int[] pol2 = new int[gxs.length];
                            if(gx.length() == 0){
                                pol2[0] = 0;
                            } else {
                                for(int i = 0; i < gxs.length; i++){
                                    pol2[i] = Integer.parseInt(gxs[i]);
                                }
                            }
                            pol2 = reverse(pol2);
                            g = new Poly(pol2, mod);
                        } else if (a.startsWith("[h]")){
                            br.write(a + System.getProperty("line.separator"));
                            a = a.substring(3);
                            String hx = a.trim();
                            hx = hx.substring(1, hx.length()-1);
                            String[] hxs = hx.split(",");
                            int[] pol2 = new int[hxs.length];
                            
                            if(hx.length() == 0){
                                pol2[0] = 0;
                            } else {
                                for(int i = 0; i < hxs.length; i++){
                                    pol2[i] = Integer.parseInt(hxs[i]);
                                }
                            }
                            pol2 = reverse(pol2);
                            h = new Poly(pol2, mod);
                        } else if (a.startsWith("[deg]")) {
                            br.write(a + System.getProperty("line.separator"));
                            a = a.replace("\t", " ");
                            deg = Integer.parseInt(a.split(" ")[a.split(" ").length-1]);
                        }
                        if(sc.hasNext()){
                            a = sc.nextLine();
                            
                        } else {
                            break;
                        }
                    }
                    
                    //all functions applied for the finite field arithmatic
                    if(Assignment.equals("[add-table]")){
                        br.write("[answer] ");
                        AddTable tab = new AddTable();
                        Poly[][] result = tab.run(field);
                        br.write("{");
                        boolean first2 = true;
                        for(Poly[] d: result){
                            if(first2){
                                first2 = false;
                            } else {
                                br.write("; ");
                            }
                            boolean first = true;
                            for(Poly b: d){
                                if(first){
                                    br.write(b.display());
                                    first = false;
                                } else {
                                    br.write(", " + b.display());
                                }
                            }
                        }
                        br.write("}" + System.getProperty("line.separator"));
                        br.write(System.getProperty("line.separator"));
                        
                    } else if(Assignment.equals("[mult-table]")){
                        br.write("[answer] ");
                        MultTable tab = new MultTable();
                        Poly[][] result = tab.run(field);
                        br.write("{");
                        boolean first2 = true;
                        for(Poly[] d: result){
                            if(first2){
                                first2 = false;
                            } else {
                                br.write("; ");
                            }
                            boolean first = true;
                            for(Poly b: d){
                                if(first){
                                    br.write(b.display());
                                    first = false;
                                } else {
                                    br.write(", " + b.display());
                                }
                            }
                        }
                        br.write("}" + System.getProperty("line.separator"));
                        br.write(System.getProperty("line.separator"));
                        
                    } else if(Assignment.equals("[display-field]")){
                        

                        
                        br.write("[answer] " + field.display(f) + System.getProperty("line.separator"));
                        br.write(System.getProperty("line.separator"));
                        
                    } else if(Assignment.equals("[add-field]")){
                        
                        
                        
                        br.write("[answer] " + field.add(f, g).display() + System.getProperty("line.separator"));
                        
                        br.write(System.getProperty("line.separator"));
                    } else if(Assignment.equals("[subtract-field]")){
                        
                        
                        
                        br.write("[answer] " + field.subtract(f, g).display() + System.getProperty("line.separator"));
                        
                        
                        br.write(System.getProperty("line.separator"));
                    } else if(Assignment.equals("[multiply-field]")){
                        
                        
                        
                        br.write("[answer] " + field.multiply(f, g).display() + System.getProperty("line.separator"));
                        
                        
                        br.write(System.getProperty("line.separator"));
                    } else if(Assignment.equals("[inverse-field]")){
                        
                        Inverse inverse = new Inverse();
                        
                        
                        
                        br.write("[answer] " + inverse.run(field, f).display() + System.getProperty("line.separator"));
                        
                        br.write(System.getProperty("line.separator"));
                    } else if(Assignment.equals("[division-field]")){
                        
                        br.write(System.getProperty("line.separator"));
                        
                    } else if(Assignment.equals("[equals-field]")){
                        
                        polyEqualMod epm = new polyEqualMod();
                        boolean result = epm.run(f, g, field);
                        if (result) {
                            br.write("[answer] " + "TRUE" + System.getProperty("line.separator"));
                        } else {
                            br.write("[answer] " + "FALSE" + System.getProperty("line.separator"));
                        }
                        br.write(System.getProperty("line.separator"));
                        
                    } else if(Assignment.equals("[primitive]")){
                        
                        
                        br.write(System.getProperty("line.separator"));
                        
                    } else if(Assignment.equals("[find-prim]")){
                        
                        br.write(System.getProperty("line.separator"));
                    }
                }
                
            }
        }
        
        br.flush();
    }
    
    /**
     * reverses the provided integer array
     * @param a
     * @return 
     */
    int[] reverse(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[a.length - 1 - i] = a[i];
        }
        return b;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        new Assignment2().run(args);
    }
    
}
