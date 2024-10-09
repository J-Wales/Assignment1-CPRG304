package shapes;

public class Cone extends Shape
{
	public double radius;
    public double height;

    public Cone(double height, double radius) {
        
        this.height = height;
        this.radius = radius;
    }

//  Volume = Pi * Radius^2 * Height 
    public double getVolume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }

    public double getHeight() {
        return height;
    }

//  Base Area = Pi * Radius^2 
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
