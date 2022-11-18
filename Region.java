// this is the folder you keep your code for project 5 in change it acordingly
package com.mycompany.mapcoloring;

import java.util.Vector;

public class Region {

    int id;
    public Vector<Integer> connections;
    public String color = null;
    public Vector<String> domain;

    public Region(int inID) {
        id = inID;
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

    
    
    public boolean isAssigned() {
        if (color != null) {
            return true;
        }
        return false;
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

    public Vector<String> getDomain() {
        return domain;
    }

    public void Tostring(Region Region) {

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
    }
// region needs to be fixed
    public static void main(String[] args) {
        Region R = new Region();
        R.play();
    }
// treat as main
    public void play() {
        Vector<Region> regions = new Vector<>();

        // creating regions
        for (int r = 0; r < 5; r++) {
            Region region = new Region(r);
            regions.add(region);
            Tostring(region);
        }

        // Connect regions
        regions.get(0).addConnection(1);

    }

}
