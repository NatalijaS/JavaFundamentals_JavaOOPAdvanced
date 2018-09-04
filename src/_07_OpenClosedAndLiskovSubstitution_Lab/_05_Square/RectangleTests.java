package _07_OpenClosedAndLiskovSubstitution_Lab._05_Square;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RectangleTests {

    private Rectangle rect;

    @Before
    public void initializeObject() {
        this.rect = new Rectangle(10, 5);
    }

    @Test
    public void getRectangleSidesTest() {
        Assert.assertEquals(10, rect.getWidth());
        Assert.assertEquals(5, rect.getHeight());
    }

    @Test
    public void getRectangleAreaTest() {
        Assert.assertEquals(50, rect.getArea());
    }

    @Test
    public void getSquareAreaTest() {
        Square square = new Square(5);
        Assert.assertEquals(25, square.getArea());
    }

    @Test
    public void SquareArgsTest() {
        Square square = new Square(5);
        Assert.assertEquals(25, square.getArea());
        Assert.assertEquals(5, square.getWidth());
        Assert.assertEquals(5, square.getHeight());
    }
}
