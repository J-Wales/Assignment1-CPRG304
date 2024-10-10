package shapes;


public class Pyramid extends Shape {
	
    private double height;
    private double edgeLength;

    // Constructor
    public Pyramid(double height, double edgeLength) {
        this.height = height;
        this.edgeLength = edgeLength;
    }

    // Calculates the base area of the pyramid (assuming a square base)
    @Override
    public double getArea() {
        return Math.pow(edgeLength, 2);
    }

    // Calculates the volume of the pyramid: (1/3) * base area * height
    @Override
    public double getVolume() {
        return (1.0 / 3.0) * getArea() * height;
    }

    // Returns the height of the pyramid
    @Override
    public double getHeight() {
        return height;
    }

    
    @Override
    public String toString() {
        return "Pyramid [Height=" + height + ", Edge Length=" + edgeLength + "]";
    }
}
