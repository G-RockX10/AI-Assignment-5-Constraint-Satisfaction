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
         int connections;
        Scanner sc = new Scanner(System.in);

        System.out.println("Chose how many Regions");
        regionNum = sc.nextInt();
        
        
        for(int i = 0 ; 0< regionNum; i++){
            Region newRegion; // initalize 
            
            
           region.add(i, newRegion);
        }
        
        System.out.println("Chose how many Connections");
        connections = sc.nextInt();
        
        
        
        
    }
    
    
//test

    public Region getRegion(int index) {
        return region.get(index);
    }

    // not done
    // find regions not yet assinged color
     public Region selectRegion() {
         // fix
   for (int i = 0; i <   region.connections.size(); i++){    
        
      if(  region.get(i).getColor()!= null){
       
         // if all regions have color return null
         return null;
      }
      else return region.get(i);
     }
   return null;
     }
    // test
     // check if any neabor region has color return true if so
    public boolean checkColor(Region test, String color) {
       
        
       
     for (int i = 0; i <   test.connections.size(); i++){
      Region neighbor = region.get( test.connections.get(i));
    if(  neighbor.getColor()== color ){
        return true;
    }
        
     }
     
        
                
                
        return false;
    }

    //not done
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
       start(); // test

       
       
       
       
       
    }
    
    
    /* teacher task tommorow

    
Fix play in Region
get region called
     */
}
