package shapes;

public class PentagonalPrism extends Shape
{
	public double height;
	public double side;
	
	public PentagonalPrism (double height, double side) {
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
		return ((5 * Math.pow(getSide(), 2) * Math.tan(54 * (Math.PI / 180))) / 4);
	}

	
	public double getVolume() {
		return getArea() * getHeight();
	}

	@Override
    public String toString() {
        return "The polygons.PentagonalPrism has a Volume of: " + getVolume();
    }
}
