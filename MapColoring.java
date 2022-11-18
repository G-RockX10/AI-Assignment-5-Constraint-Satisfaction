// this is the folder you keep your code for project 5 in change it acordingly
package com.mycompany.mapcoloring;

import java.util.Scanner;
import java.util.Vector;

public class MapColoring {

    Vector<Region> region = new Vector<>();

    public static void main(String[] args) {
        MapColoring MC = new MapColoring();
        MC.play();
    }

 // not done
    public void start(){
         int regionNum;
        Scanner sc = new Scanner(System.in);

        System.out.println("Chose how many Regions");
        regionNum = sc.nextInt();
    }
    
    
//test

    public Region getRegion(int index) {
        return region.get(index);
    }

    // not done
    // find regions not yet assinged color
     public Region selectRegion() {
         
        
        
         // if all regions have color return null
         return null;
     }
    
    // not done
     // check if any neabor region has color return true if so
    public boolean checkColor(Region test, String color) {
       
        test.getColor()
     
        
                
                
        return false;
    }

    //test
    public MapColoring copy() {

        MapColoring copyOfMe = new MapColoring();

        return copyOfMe;
    }

    
    
    // not done
    // see if any region has not been asigned color if so return true
    public boolean CheckRegion(){
        
        return false;
    }
    
    
    
      // not done
    public void play() {
       

    }
    
    
    /* teacher task tommorow

    
Fix play in Region
get region called
     */
}
