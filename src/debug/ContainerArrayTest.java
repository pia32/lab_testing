package debug;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ContainerArrayTest {
    private ContainerArray<String> myContainer = null;

    @Before
    public void setUp () {
        myContainer = new ContainerArray<>();
    }
    
    @Test
    public void testGetNegative()
    {
        assertEquals("Get negative", null, myContainer.get(-10));
    }
    
    @Test
    public void testRemoveMany()
    {
    	for(int i = 0; i < 100; i++)
    		myContainer.remove(Integer.toString(i));
    	
        assertEquals("Removes many", 0, myContainer.size());
    }
    
    @Test
    public void testAddMany()
    {
    	for(int i = 0; i < 100; i++)
    		myContainer.add(Integer.toString(i));
    	
        assertEquals("Add many", 100, myContainer.size());
    }
    
    @Test
    public void testGetUnset()
    {
    	myContainer.add("Alligator");
        myContainer.add("Bear");
        myContainer.add("Camel");
        
        assertEquals("Get unset item", null, myContainer.get(10));
    }
    
    @Test
    public void testRemove()
    {
    	myContainer.add("Alligator");
        myContainer.add("Bear");
        myContainer.add("Camel");
        myContainer.remove("Alligator");
        
        assertEquals("Remove object", "Bear", myContainer.get(0));
    }
    
    @Test
    public void testSizeChangeWithAdd () {
        myContainer.add("Alligator");
        myContainer.add("Bear");
        myContainer.add("Camel");
        assertEquals("Add size", 3, myContainer.size());
    }

    @Test
    public void testObjectIsStored () {
        String alligator = "Alligator";
        myContainer.add(alligator);
        assertEquals("Add should be same reference", alligator, myContainer.get(0));
    }

    @Test
    public void testSizeChangeWithRemove () {
        myContainer.add("Alligator");
        myContainer.add("Bear");
        myContainer.remove("Alligator");
        assertEquals("Remove size", 1, myContainer.size());
    }

    @Test
    public void testObjectIsRemoved () {
        String alligator = "Alligator";
        myContainer.add("Alligator");
        myContainer.add("Bear");
        myContainer.remove("Bear");
        assertEquals("Remove should be same reference", alligator, myContainer.get(0));
    }
}
