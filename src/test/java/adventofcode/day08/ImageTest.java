package adventofcode.day08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import adventofcode.day08.Image;
import adventofcode.day08.Layer;

public class ImageTest {
	@Test
	public void testImageCreation() {
		Image image = new Image(3, 2, "123456789012");
		Layer layer1 = image.getLayer(0);
		assertEquals(1, layer1.get(0, 0));
		assertEquals(2, layer1.get(0, 1));
		assertEquals(3, layer1.get(0, 2));
		assertEquals(4, layer1.get(1, 0));
		assertEquals(5, layer1.get(1, 1));
		assertEquals(6, layer1.get(1, 2));

		Layer layer2 = image.getLayer(1);
		assertEquals(7, layer2.get(0, 0));
		assertEquals(8, layer2.get(0, 1));
		assertEquals(9, layer2.get(0, 2));
		assertEquals(0, layer2.get(1, 0));
		assertEquals(1, layer2.get(1, 1));
		assertEquals(2, layer2.get(1, 2));

		assertEquals(1, layer1.countDigit(4));
		assertEquals(0, layer2.countDigit(5));
	}
}
