package shapes;


public class Pyramid extends Shape {
    private double height;
    private double edgeLength;


    public Pyramid(double height, double edgeLength) {
        this.height = height;
        this.edgeLength = edgeLength;
    }

 
    public double getArea() {
        return Math.pow(edgeLength, 2);
    }

    
    public double getVolume() {
        return (1.0 / 3.0) * getArea() * height;
    }

    
    public double getHeight() {
        return height;
    }

    
    @Override
    public String toString() {
        return "The shape.Pyramid has a Volume of: " + getVolume();
    }
}
