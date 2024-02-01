package task;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class StringIteratorTest {

    private String[] list;
    private StringIterator iterator;

    @Before
    public void init() {
        this.list = new String[] {"first", "second", "third"};
    }

    @After
    public void teardown() {
        this.list = null;
    }

    @Test(expected = RuntimeException.class)
    public void nullTest() {
        this.list = null;
        this.iterator = new StringIterator(this.list);
    }

    @Test(expected = RuntimeException.class)
    public void emptyTest() {
        this.list = new String[] {};
        this.iterator = new StringIterator(this.list);
    }

    @Test
    public void checkAccessTest() {
        this.iterator = new StringIterator(this.list);

        assertTrue(this.iterator.hasNext());
        assertEquals("first", this.iterator.next());
        assertEquals("second", this.iterator.next());
        assertEquals("third", this.iterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void lastElementTest() {
        this.iterator = new StringIterator(this.list);
        this.iterator.next();
        this.iterator.next();
        this.iterator.next();
        this.iterator.next();
    }

    @Test
    public void emptyArrayTest() {
        this.iterator = new StringIterator(this.list);
        this.list = new String[]{};
        assertEquals("first", this.iterator.next());
    }

}