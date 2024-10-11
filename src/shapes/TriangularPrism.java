package shapes;

public class TriangularPrism extends Shape
{
	public double height;
	public double side;
	
	public TriangularPrism (double height, double side) {
		this.height = height;
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}
	
	@Override
	public double getHeight() {
		return height;
	}
	
	@Override
	public double getArea() {
		return ((Math.pow(getSide(), 2) * Math.sqrt(3)) / 4);
	}

	@Override
	public double getVolume() {
		return getArea() * getHeight();
	}

	@Override
    public String toString() {
        return "The polygons.TriangularPrism has a Volume of: " + getVolume();
    }
}
