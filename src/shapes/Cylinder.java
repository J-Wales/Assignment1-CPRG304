package shapes;

public class Cylinder extends Shape
{
	public double height;
	
	public double radius;
	
	public double baseArea;
	
	public double volume;
	
	public Cylinder(double height, double radius) {
		this.height = height;
		this.radius = radius;
		
		baseArea = (Math.PI * Math.pow(radius, 2));
		volume = (Math.PI * Math.pow(radius, 2) * height);
	}
	
	@Override
	public double getHeight() {
		return this.height;
	}
	
	@Override
	public double getVolume() {
		return this.volume;
	}
	
	@Override
	public double getArea() {
		return this.baseArea;
	}
}
