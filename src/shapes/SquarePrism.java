package shapes;

public class SquarePrism extends Shape
{
	public double height;
	public double side;
	
	public SquarePrism (double height, double side) {
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
		return Math.pow(getSide(), 2);
	}

	@Override
	public double getVolume() {
		return getArea() * getHeight();
	}
}
