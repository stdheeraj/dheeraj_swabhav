package lsp.violation;

public class Square extends Rectangle {

	public Square(int side) {
		super(side,side);
	}

	@Override
	public void setWidth(int width) {
		this.width=this.hieght=width;
	}

	@Override
	public void setHieght(int hieght) {
		this.width=this.hieght=hieght;
	}

}
