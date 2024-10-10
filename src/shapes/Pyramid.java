package shapes;

public class Pyramid extends Shape {
	
    private double height;
    private double side;

    // Constructor
    public Pyramid(double height, double side) {
        this.height = height;
        this.side = side;
    }

    // Calculates the base area of the pyramid (assuming a square base)
    @Override
    public double getArea() {
        return Math.pow(side, 2);
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
        return "Pyramid [Height=" + height + ", Edge Length=" + side + "]";
    }
}
