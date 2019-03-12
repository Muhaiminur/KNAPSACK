/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author muhaiminur
 */
public class KnapSackDP {
    ArrayList weight = new ArrayList();
    ArrayList value = new ArrayList();
    ArrayList r = new ArrayList();
    int item = 0;
    int [][] k;
    
    public KnapSackDP(ArrayList wei,ArrayList val){
        weight=wei;
        value=val;
        
        /*for (Iterator iterator = weight.iterator(); iterator.hasNext();) {
                Object next = iterator.next();
                System.out.println(next);
            }
            System.out.println("======================================");
            for (Iterator iterator = value.iterator(); iterator.hasNext();) {
                Object next = iterator.next();
                System.out.println(next);
            }*/
    }
    
    
    public int knapSack(int n,int w){
        int i=0;
        k = new int [n+1][w+1];
        
        
        for(int c=1; c<k.length; c++){
            for(int d=1; d<k[c].length; d++)
            {
                if((int)weight.get(c-1) <= (d))
                {
                    int a = (int)k[c-1][d];
                    int b =(int)k[c-1][d-(int)weight.get(c-1)]+(int)value.get(c-1);
                    
                    if(a > b)
                    {
                        k[c][d] = a;
                    }
                    
                    else
                    {
                        k[c][d] = b;
                    }
                }
                
                else
                {
                    k[c][d] = k[c-1][d];
                }
            }
        }
        i=k[k.length-1][k[0].length-1];
        
        knapsackresult(k.length-1,k[0].length-1);
        return i;
    }
    
    
    public ArrayList<Integer> findItems(){
        
        
        
        return r;
    }
    private void knapsackresult(int e, int f)
    {
        if(e==0 || f==0)
        {
          //System.out.print("Should Carry item no: ");
        }
        
        else if(k[e][f] != (k[e-1][f]))
        {
            knapsackresult(e-1, f-(int)weight.get(e-1));
            //System.out.print(e+" ");
            r.add(e-1);
        }
        else
        {
            knapsackresult(e-1,f);
        }
    }
    
}
