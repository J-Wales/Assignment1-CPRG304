package shapes;

public class OctagonalPrism extends Shape
{
	public double height;
	public double side;
	
	public OctagonalPrism (double height, double side) {
		this.height = height;
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}
	

	public double getHeight() {
		return height;
	}
	
	
	public double getArea() {
		return 2 * (1 + Math.sqrt(2)) * Math.pow(getSide(), 2);
	}

	
	public double getVolume() {
		return getArea() * getHeight();
	}

	@Override
    	public String toString() {
        	return "The polygons.OctagonalPrism has a Volume of: " + getVolume();
    }
}
