package com.timneville.Lists;

import com.google.common.collect.testing.features.CollectionFeature;
import com.google.common.collect.testing.testers.CollectionContainsAllTester;
import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

import static com.google.common.collect.testing.features.CollectionFeature.SUPPORTS_ADD;
import static org.junit.Assert.*;


/**
 * Created by timneville on 5/7/17.
 */
public class SinglyLinkedListImpListTest {

    private SinglyLinkedListImpList myList;

    @Before
    public void setUp() throws Exception {
        myList = new SinglyLinkedListImpList();
    }

    @Test
    public void containsElementsAfterAddingItemsToList() throws Exception {
        myList.add("Bike");
        myList.add("Dog");

        assertEquals("contains Bike test", true, myList.contains("Bike"));
        assertEquals("contains Dog test", true, myList.contains("Dog"));
        assertEquals(false, myList.contains("Cat"));
        assertEquals(2, myList.size());
    }

    @Test
    public void iteratorOnEmptyListDoesNotHaveNext() throws Exception {
        assertEquals(false, myList.iterator().hasNext());
    }

    @Test
    public void iteratorReturnsNext() throws Exception {
        myList.add("Bike");
        myList.add("Dog");

        assertEquals("Bike", myList.iterator().next());
        assertFalse(myList.iterator().next() == "Dog");
    }

    @Test
    public void listContainsElementAfterAddAtIndex() throws Exception {
        Object nullObject = new Object[]{null};

        myList.add("Frogs");
        myList.add("Logs");
        myList.add("Planes");
        myList.add("Cars");
        myList.add("Trains");
        myList.add(1, "Dogs");
        myList.add(1, nullObject);

        assertEquals("testAtIndex Dogs",true, myList.contains("Dogs"));
        assertEquals("testAdd Planes", true, myList.contains("Planes"));
        assertEquals("testAdd Planes", true, myList.contains("Cars"));
        assertEquals("testAdd Planes", true, myList.contains("Frogs"));
        assertEquals("contains Logs still", true, myList.contains("Logs"));
        assertEquals("contains Trains still", true, myList.contains("Trains"));
        assertEquals("contains null object", true, myList.contains(nullObject));
    }

    @Test
    public void removeReturnsTrue() throws Exception {
    }

//    @Test
//    public void testAddAll_supportedNonePresent() {
//
//        myList.addAll(Arrays.asList("d","e"));
//        for (Object o : myList) {
//            System.out.println(o);
//        }
//        System.out.println(myList);
//    }

    @Test
    public void listIteratorTest() throws Exception {
        myList.add("b");
        ListIterator myListIterator = myList.listIterator();

        myListIterator.add("e");
        myListIterator.add("e");
        assertEquals("b", myListIterator.next());
        myListIterator.remove();

//        assertTrue(myListIterator.hasNext());
//        assertEquals("b", myListIterator.next()); //b
//        myListIterator.remove();
//        assertFalse(myListIterator.hasPrevious());

//        for (Object o : myList) {
//            System.out.println(o);
//        }
//        System.out.println(myList);

    }
}