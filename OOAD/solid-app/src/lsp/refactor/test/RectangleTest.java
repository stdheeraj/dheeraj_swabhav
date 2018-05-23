package lsp.refactor.test;

import lsp.refactor.Rectangle;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {

	@Test
	public void testRectangle() {
		shouldNotChangeHieghtIfWidthChanges(new Rectangle(30, 20));
	}
	
	private void shouldNotChangeHieghtIfWidthChanges(Rectangle rect){
		int before = rect.getHieght();
		rect.setWidth(10);
		int after = rect.getHieght();
		Assert.assertSame(before, after);
	}

}
