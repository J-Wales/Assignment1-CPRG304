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
	
	@Override
	public double getHeight() {
		return height;
	}
	
	@Override
	public double getArea() {
		return ((5 * Math.pow(getSide(), 2) * Math.tan(54 * (Math.PI / 180))) / 4);
	}

	@Override
	public double getVolume() {
		return getArea() * getHeight();
	}
}
