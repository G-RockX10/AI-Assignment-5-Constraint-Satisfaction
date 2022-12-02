// this is the folder you keep your code for project 5 in change it acordingly
package com.mycompany.mapcoloring;

import java.util.Vector;

public class BackTrackClass {

    Vector<Region> region = new Vector<>();

    /**
     * Performs back tracking search on the color mapping CSP
     *
     * Much of the work is done using methods in the CSP and Region classes: CSP
     * - assignmentComplete CheckRegion - selectedUnassignedRegion selectRegion
     * - isConsistent checkColor(Region test, String color) - copy (to create a
     * playground for the current assignment of color to a region) CSPcopy() -
     * getRegion getRegion(int index) Region - getDomain getDomain() - assign
     * isAssigned() - removeColor (from the domain of colors) removeColor(String
     * color)
     *
     *
     *
     *
     * @param csp - Initial call made with initial CSP, recursive calls made
     * with a playground version.
     * @param level - Used for testing purposes to check the level of recursion
     * @return CSP object, which should be the result of a correct assignment or
     * null
     */
    // what is it backTrackingSearch is suppose to do
    //find region with no color
    public MapColoring backTrackingSearch(MapColoring csp, int level) {

        if (csp.CheckRegion() == true) {
            return csp;

        }
        Region region = csp.selectRegion();
        int ID = region.getId();

        for (int i = 0; i < region.getDomain().size(); i++) {

            String color = region.getDomain().get(i);

            if (csp.checkColor(region, color) == false) {
                System.out.println("in checkColor");
                MapColoring copy = csp.CSPcopy();

                Region copyRegion = copy.getRegion(ID);
                System.out.println(copyRegion);
                copyRegion.setColor(color);
                System.out.println(copyRegion);
                if (forwardChecking(copyRegion, csp) == true) {

                    System.out.println("in forwardChecking");
                    System.out.println(copyRegion);

                    copy = backTrackingSearch(copy, level);

                    if (copy != null) {
                        System.out.println("in copy");
                        System.out.println(copy);

                        return copy;
                    }
                }
            }
        }
        return null;
    }

    /**
     * **********************************************************************
     * Forward checking Remove the region's assigned color from all of it's
     * connected regions. Methods that may be helpful: CSP - getRegion Region -
     * getAssign - isDomainEmpty
     *
     * @param region - Region with a newly assigned color
     * @param csp - Needed to access neighbor objects (we only store id's in a
     * regions list of connections).
     * @return Return false if a neighbor's domain becomes empty after removing
     * the color
     * **********************************************************************
     */
    //Test
    public boolean forwardChecking(Region region, MapColoring csp) {
        System.out.println();
        System.out.println("in Forward Checking with region" + region);

        int t = region.getId();
        int c = csp.getRegion(t).connections.size();
System.out.println(c);
        // go through each neighbor
        for (int i = 0; i <= c; i++) {

            int connect = csp.getRegion(t).connections.get(i);

            System.out.println("Neighbor" + connect);
            Region Test = csp.getRegion(connect);

            System.out.println("Neighbor region" + Test + "should be removing" + region.getColor());
            Test.removeColor(region.getColor());
            System.out.println("Neighbor after trying to remove" + Test);
            if (Test.isDomainEmpty() == true) {
                return false;
            }
        }
        System.out.println(region);
        return true;
    }

    /**
     * Start search 1. Creates CSP object and names it csp 2. Calls initialize
     * on csp 3. Call backTrackingSearch with the csp and level 0. Assign result
     * back to csp 4. if csp is not null, print out the final solution
     */
    public void startSearch() {
        MapColoring csp = new MapColoring();
        csp.start();
        csp = backTrackingSearch(csp, 0);

        if (csp != null) {
            System.out.println("Final solution: " + csp);
        }
    }

    /**
     * Create BackTrackClass object and call startSearch on it.
     *
     * @param args
     */
    public static void main(String[] args) {
        BackTrackClass btc = new BackTrackClass();
        btc.startSearch();
    }
}
