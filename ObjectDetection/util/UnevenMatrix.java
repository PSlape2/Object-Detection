package ObjectDetection.util;

import java.util.ArrayList;

import ObjectDetection.image.PixelGroup;

public class UnevenMatrix {
    private final ArrayList<PixelGroup>[] groups;
    
    // @SuppressWarnings("unchecked")
    public UnevenMatrix(int maxLength, int maxHeight) {
        ArrayList<ArrayList<PixelGroup>> groupList = new ArrayList<ArrayList<PixelGroup>>();
        for(int i = 0; i < maxLength; i++) {
            groupList.add(new ArrayList<PixelGroup>());
        }

        groups = (ArrayList<PixelGroup>[]) groupList.toArray(); // Fix this later

        for(ArrayList<PixelGroup> group : groups) {
            group.ensureCapacity(maxHeight);
        }
    }

    /**
     * Adds a new PixelGroup to the matrix.
     * 
     * @param pixelGroup The PixelGroup to add to the matrix.
     */
    public void add(PixelGroup pixelGroup) {
        try {
            Pair locPair = pixelGroup.getLocation();
            Integer x = (Integer) locPair.x;
            Integer y = (Integer) locPair.y;

            groups[x].set(y,pixelGroup);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Gets the PixelGroup at a certain (x, y) coordinate.
     * 
     * @param x     The x coordinate of the PixelGroup.
     * @param y     The y coordinate of the PixelGroup.
     * @return      The PixelGroup at (x, y).
     */
    public PixelGroup get(int x, int y) {
        try {
            return groups[x].get(y);
        } catch(IndexOutOfBoundsException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
