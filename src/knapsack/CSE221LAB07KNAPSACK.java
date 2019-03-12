/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author muhaiminur
 */
public class CSE221LAB07KNAPSACK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList weight = new ArrayList();
        ArrayList benefit=new ArrayList();
        int capacity=0;
        int elem=0;
        try {
            Scanner abir=new Scanner(new File("INPUT"));
            int count=0;
            while (abir.hasNextLine()) {
                String input=abir.nextLine();
                if(input.equalsIgnoreCase("Weights:")) {
                    String x=abir.nextLine();
                    for (String retval: x.split(" ")){
                        weight.add(Integer.parseInt(retval));
                    }
                }
                if(input.equalsIgnoreCase("Benefits:")) {
                    String x=abir.nextLine();
                    for (String retval: x.split(" ")){
                        benefit.add(Integer.parseInt(retval));
                    }
                }
                if(input.contains("Knapsack Capacity:")) {
                    String numberOnly= input.replaceAll("[^0-9]", "");
                    capacity=Integer.parseInt(numberOnly);
                }
                if(input.contains("Number of Elements:")) {
                    String numberOnly= input.replaceAll("[^0-9]", "");
                    elem=Integer.parseInt(numberOnly);
                }
            }
            
            
            
            //System.out.println("Knapsack Capacity: "+capacity);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        KnapSackDP ab=new KnapSackDP(weight,benefit);
        int i=ab.knapSack(elem, capacity);
        //
        ArrayList r=ab.findItems();
        //
        System.out.println("OUTPUT : ================================================");
        System.out.println("                                                          ");
        System.out.println(" ITEM                  PROFIT                WEIGHT       ");
        for (int j = 0; j < weight.size(); j++) {
            
            System.out.println("  "+j+"                     "+benefit.get(j)+"                    "+weight.get(j)+"       ");
            
        }
        System.out.println("Total Benefit      :  "+i);
        System.out.println("Items in knapsack : "+r);
    }
    
}
