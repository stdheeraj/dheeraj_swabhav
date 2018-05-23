package lsp.refactor;

public class Rectangle implements IPolygon {
	
	private int width;
	private int hieght;
	
	public Rectangle(int width, int hieght) {
		this.width = width;
		this.hieght = hieght;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHieght() {
		return hieght;
	}

	public void setHieght(int hieght) {
		this.hieght = hieght;
	}

	@Override
	public int calculateArea() {
		return this.getHieght()*this.getWidth();
	}

}
