package shapes;

import java.util.Comparator;

public abstract class Shape implements Comparable<Shape> {

    // Abstract methods for height, volume, and area
    public abstract double getHeight();
    public abstract double getVolume();
    public abstract double getArea();

    // Implements the compareTo method to compare by height in descending order
    @Override
    public int compareTo(Shape other) {
        // Compare heights in descending order
        return Double.compare(other.getHeight(), this.getHeight());
    }

    // Comparator to compare shapes by base area in ascending order
    public static Comparator<Shape> AreaComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape s1, Shape s2) {
            return Double.compare(s1.getArea(), s2.getArea());
        }
    };

    // Comparator to compare shapes by volume in ascending order
    public static Comparator<Shape> VolumeComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape s1, Shape s2) {
            return Double.compare(s1.getVolume(), s2.getVolume());
        }
    };
}
