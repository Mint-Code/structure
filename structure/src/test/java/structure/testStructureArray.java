package structure;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

public class testStructureArray {
    
    private StructureArray<Integer> array;

    @Before
    public void init() {
        array = new StructureArray<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
    }

    @After
    public void clean() {
        array = null;
    }

    @Test
    public void testCreateArray() {
        Integer[] list = {1, 2, 3, 4, 5};
        array = new StructureArray<Integer>(list);
        Assert.assertEquals("[1, 2, 3, 4, 5]", array.toString());
        array = new StructureArray<Integer>(1, 2, 3, 4, 5);
        Assert.assertEquals("[1, 2, 3, 4, 5]", array.toString());
    }

    @Test
    public void testGetMetadata() {
        Integer[] list = {1, 2, 3, 4, 5};
        Assert.assertEquals(list[0], array.toArray()[0]);
        Assert.assertEquals(5, array.getLength());
    }

    @Test
    public void testGetElement() {
        Assert.assertEquals((Integer) 1, (Integer) (array.get(0)));
        Assert.assertNull(array.get(20));
    }

    @Test
    public void testAddElement() {
        array.add(0);
        Assert.assertEquals("[1, 2, 3, 4, 5, 0]", array.toString());
        Assert.assertEquals(0, (int) (array.get(5)));
        array.insert(0, 3);
        Assert.assertEquals("[1, 2, 3, 0, 4, 5, 0]", array.toString());
        Assert.assertEquals(0, (int) (array.get(3)));
    }

    @Test
    public void testRemoveElement() {
        array.remove();
        array.remove(0);
        Assert.assertEquals("[2, 3, 4]", array.toString());
    }
}
