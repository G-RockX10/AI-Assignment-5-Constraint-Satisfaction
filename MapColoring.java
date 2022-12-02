// this is the folder you keep your code for project 5 in change it acordingly
package com.mycompany.mapcoloring;

import java.util.Scanner;
import java.util.Vector;

public class MapColoring {

    Vector<Region> region = new Vector<>();

    public static void main(String[] args) {
        MapColoring csp = new MapColoring();

        csp.start();
        System.out.println("CSP :" + csp);
        Region unassigned = csp.selectRegion();
        System.out.println("Un assigned region " + unassigned);
        System.out.println(csp.CheckRegion());

        unassigned.assign("Red");
        unassigned.removeColor("Red");

        MapColoring cspCopy = csp.CSPcopy();

        System.out.println("Original");
        System.out.println(csp);
        System.out.println("Copy");
        System.out.println(cspCopy);

    }

 //done
    public void start() {
        int regionNum;
        int connections;
        int regeionSelect1;
        int regeionSelect2;
        Scanner sc = new Scanner(System.in);

        System.out.println("Chose how many Regions");
        regionNum = sc.nextInt();

        for (int i = 0; i < regionNum; i++) {
            Region newRegion = new Region(i); // initalize 
newRegion.InitializeRegion();
            region.add(newRegion);
        }

        System.out.println("Chose how many Connections");
        connections = sc.nextInt();
        for (int i = 0; i < connections; i++) {
            System.out.println("Which Regions to Connect");
            System.out.println("Selct First Region to Connect");
            regeionSelect1 = sc.nextInt();
            System.out.println("Selct Seceond Region to Connect");
            regeionSelect2 = sc.nextInt();
            region.get(regeionSelect1).addConnection(region.get(regeionSelect2));
            region.get(regeionSelect2).addConnection(region.get(regeionSelect1));
 System.out.println("Done Connecting");
            // ask for help Getting .addconnections 
        }

    }

//test
    public Region getRegion(int index) {
        return region.get(index);
    }

    // test
    // find regions not yet assinged color
    public Region selectRegion() {
        // fix
        for (int i = 0; i < region.size(); i++) {

            if (region.get(i).getColor() != null) {

                // if all regions have color return null
                return null;
            } else {
                return region.get(i);
            }
        }
        return null;
    }
    // test
    // check if any neabor region has color return true if so
    public boolean checkColor(Region test, String color) {

        for (int i = 0; i < test.connections.size(); i++) {
            Region neighbor = region.get(test.connections.get(i));
            if (neighbor.getColor() == color) {
                return true;
            }

        }

        return false;
    }

       // test
    // see if any region has not been asigned color if so return true
    public boolean CheckRegion() {

        
        for(int i=0; i < region.size();i++){
        
   String color = region.get(i).getColor();
       if(color != null)
           return true;
                }
        
        return false;
    }
    
    
    
    
    //test
    public MapColoring CSPcopy() {

        MapColoring copy = new MapColoring();
for(int i = 0; i < region.size(); i++){
        copy.region.add(region.get(i).Regioncopy());

}
        return copy;
        
        
    }

 

    public String toString() {
        String str = "";

        // ***************************************************
        // Print out the regions 
        // ***************************************************
        for (int r = 0; r < region.size(); r++) {
            str += region.get(r);
            str += "\n";
        }

        return str;
    }

    /* teacher task tommorow


     */
}
