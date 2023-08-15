package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LinkedListTest {

    @Test
    public void test_addition_of_node_to_empty_list() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.getSize());
        list.insertAtHead(10);
        assertEquals(1, list.getSize());
    }

    @Test
    public void test_addition_of_node_at_head_of_empty_list() {
        //given
        LinkedList list = new LinkedList();
        list.insertAtHead(10);
        assertEquals(10, list.getHead().val);

        //test
        list.insertAtHead(20);
        assertEquals(2, list.getSize());
        assertEquals(20, list.getHead().val);
    }

}
