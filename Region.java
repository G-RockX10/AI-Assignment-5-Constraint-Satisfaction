// this is the folder you keep your code for project 5 in change it acordingly
package com.mycompany.mapcoloring;

import java.util.Vector;

public class Region {

    int id;
    public Vector<Integer> connections;
    public String color = null;
    public Vector<String> domain;
    boolean assigned = false;

    public Region(int inID) {
        id = inID;

    }

    public void InitializeRegion() {
        domain = new Vector<>();
        domain.add("Red");
        domain.add("Yellow");
        domain.add("Blue");
        domain.add("Green");
        connections = new Vector<>();
    }

    public void addConnection(Integer id) {
        connections.add(id);
    }
    
 public void addConnection(Region inRegion) {       
        //System.out.println("About to connect region " + id + " with region" + inRegion.getId());     
        connections.add(inRegion.getId());     
    }

 public int getId(){
     return id;
 }

    public boolean isAssigned() {
        if (color != null) {
            return true;
        }
        return false;
    }

   public boolean isDomainEmpty(){
       return domain.isEmpty();
   }
    
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
// go through domain and remove a specified color 

    public void removeColor(String color) {

        for (int c = 0; c < domain.size(); c++) {
            if (domain.get(c).equals(color)) {
                domain.remove(c);
                return;
            }
        }
    }

    public void assign(String inColor) {
        color = inColor;
        assigned = true;
    }

    public Vector<String> getDomain() {
        return domain;
    }

    public Region Regioncopy() {

        Region copy = new Region(id);

        copy.domain = new Vector<String>();
        copy.connections = new Vector<Integer>();
        for (int i = 0; i < domain.size(); i++) {
            copy.domain.add(domain.get(i));
        }

        for (int i = 0; i < connections.size(); i++) {
            copy.connections.add(connections.get(i));
        }
        return copy;
    }

    public String toString() {

        String str = "";

        str += ("Id:" + id);
        str += (" color: " + color);

        int c;
        str += " List of neighbor ID's: ";
        for (c = 0; c < connections.size(); c++) {
            str += (" " + connections.get(c));
        }

        str += " ";
        str += "Colors in the domain: ";
        for (c = 0; c < domain.size(); c++) {
            str += (" " + domain.get(c));
        }
        return str;
    }
// region needs to be fixed

    public static void main(String[] args) {
        Vector<Region> region = new Vector<>();

        for (int i = 0; i < 5; i++) {
            Region newRegion = new Region(i);
            newRegion.InitializeRegion();
            region.add(newRegion);
            System.out.println(region.get(i));
        }

        // add connections for the regions 
        region.get(0).addConnection(region.get(2));  // connect 0 to 2 (two way)
        region.get(2).addConnection(region.get(0));  // connect 0 to 2 (two way)

        region.get(1).addConnection(region.get(3));  // connect 1 to 3 (two way
        region.get(3).addConnection(region.get(1));  // connect 1 to 3 (two way

        region.get(1).addConnection(region.get(4));  // connect 1 to 4 (two way)
        region.get(4).addConnection(region.get(1));  // connect 1 to 4 (two way)

        region.get(3).addConnection(region.get(4));  // connect 3 to 4 (two way)
        region.get(4).addConnection(region.get(3));  // connect 3 to 4 (two way)

        // ***************************************************
        // Print out the regions with their neighbors 
        // ***************************************************
        for (int r = 0; r < region.size(); r++) {
            System.out.println(region.get(r));
        }

        // **************************************************
        // Create a clone of a region
        // **************************************************
        Region tempRegion0 = region.get(0).Regioncopy();

        // **************************************************
        // Test the removeColor method
        // **************************************************
        System.out.println("Testing the method to remove a color from the domain");
        region.get(0).removeColor("Red");
        System.out.println("Testing the method to assign a color to a region");
        region.get(0).assign("Red");
        System.out.println("Orginal and changed region " + region.get(0));
        System.out.println("Copied region: " + tempRegion0);
    }

}
