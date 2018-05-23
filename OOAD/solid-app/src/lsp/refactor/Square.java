package lsp.refactor;

public class Square implements IPolygon {
	
	private int side;

	public Square(int side) {
		this.side = side;
	}
	
	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	@Override
	public int calculateArea() {
		return this.side*this.side;
	}

}
