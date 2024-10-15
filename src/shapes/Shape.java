package shapes;

import java.util.Comparator;

public abstract class Shape implements Comparable<Shape> {

    // Abstract methods for height, volume, and area
    public abstract double getHeight();
    public abstract double getVolume();
    public abstract double getArea();

 
    @Override
    public int compareTo(Shape other) {
        // Compares heights in descending order
        return Double.compare(other.getHeight(), this.getHeight());
    }

  
    public static Comparator<Shape> AreaComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape s1, Shape s2) {
            return Double.compare(s1.getArea(), s2.getArea());
        }
    };

  
    public static Comparator<Shape> VolumeComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape s1, Shape s2) {
            return Double.compare(s1.getVolume(), s2.getVolume());
        }
    };
    
}
