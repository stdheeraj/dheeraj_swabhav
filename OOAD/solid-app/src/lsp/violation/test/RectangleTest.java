package lsp.violation.test;

import lsp.violation.Rectangle;
import lsp.violation.Square;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {

	@Test
	public void testRectangle() {
		shouldNotChangeHieghtIfWidthChanges(new Rectangle(30, 20));
	}
	
	@Test
	public void testSquare() {
		shouldNotChangeHieghtIfWidthChanges(new Square(30));
	}
	
	private void shouldNotChangeHieghtIfWidthChanges(Rectangle rect){
		int before = rect.getHieght();
		rect.setWidth(10);
		int after = rect.getHieght();
		Assert.assertSame(before, after);
	}

}
