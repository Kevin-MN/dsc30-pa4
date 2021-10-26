import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    DoublyLinkedList<Integer> empty;
    DoublyLinkedList<Integer> test1;
    DoublyLinkedList<Integer> test2;

    @Before
    public void setup(){
         empty = new DoublyLinkedList<Integer>();
         test1 = new DoublyLinkedList<Integer>();
         test2 = new DoublyLinkedList<Integer>();

        for(int i = 0; i < 5; i++){
            test1.add(i + 1);
        }

        for(int j = 4; j < 9; j++){
            test2.add(j + 1);
        }

    }

    @Test
    public void dll_constructorTest1(){
            DoublyLinkedList<Integer> temp = new DoublyLinkedList<Integer>();

            assertEquals(true, temp.isEmpty());
    }

    @Test
    public void dll_constructorTest2(){
        DoublyLinkedList<Integer> temp = new DoublyLinkedList<Integer>();

        assertEquals(0, temp.size());
    }

    @Test
    public void dll_constructorTest3(){
        DoublyLinkedList<Integer> temp = new DoublyLinkedList<Integer>();

        assertEquals("[(head) -> (tail)]", temp.toString());
    }

    @Test (expected = NullPointerException.class)
    public void addTest_exception1(){
       test1.add(null);
    }

    @Test
    public void addTest1(){
        test1.add(10);

        assertEquals(new Integer(10), test1.get(test1.size() - 1));
    }

    @Test
    public void addTest2(){
        empty.add(10);

        assertEquals(1, empty.size());
    }

    @Test
    public void addTest3(){
        test1.add(100);

        assertEquals("[(head) -> 1 -> 2 -> 3 -> 4 -> 5 -> 100 -> (tail)]", test1.toString());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void add2Test_exception1(){
        test1.add(100, 100);
    }

    @Test (expected = NullPointerException.class)
    public void add2Test_exception2(){
        test1.add(0, null );
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void add2Test_exception3(){
        test1.add(-10, 100 );
    }

    @Test
    public void add2Test1(){
        empty.add(0,100);

        assertEquals("[(head) -> 100 -> (tail)]", empty.toString());
    }

    @Test
    public void add2Test2(){
        assertEquals(true, empty.isEmpty());
        empty.add(0,100);

        assertEquals("[(head) -> 100 -> (tail)]", empty.toString());
        assertEquals(false, empty.isEmpty());
    }

    @Test
    public void add2Test3(){
        test1.add(2,100);

        assertEquals("[(head) -> 1 -> 2 -> 100 -> 3 -> 4 -> 5 -> (tail)]", test1.toString());
    }

    @Test
    public void add2Test4(){
        test1.add(test1.size(),100);

        assertEquals("[(head) -> 1 -> 2 -> 3 -> 4 -> 5 -> 100 -> (tail)]", test1.toString());
    }

    @Test
    public void clearTest1(){
        test1.clear();

        assertEquals(true, test1.isEmpty());
    }

    @Test
    public void clearTest2(){
        assertEquals("[(head) -> 1 -> 2 -> 3 -> 4 -> 5 -> (tail)]", test1.toString());
        test1.clear();

        assertEquals("[(head) -> (tail)]", test1.toString());
    }

    @Test
    public void clearTest3(){
        assertEquals(5, test1.size());
        test1.clear();

        assertEquals(0, test1.size());
    }

    @Test
    public void containsTest1(){
        assertEquals(false, test1.contains(new Integer(-1)));
    }

    @Test
    public void containsTest2(){
        assertEquals(true, test1.contains(new Integer(3)));
    }

    @Test
    public void containsTest3(){
        assertEquals(false, test1.contains(new Integer(100)));
        test1.add(100);
        assertEquals(true, test1.contains(new Integer(100)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getTest_exception1(){
        empty.get(1);
    }

    @Test
    public void getTest1(){
        assertEquals(new Integer(1), test1.get(0));
    }

    @Test
    public void getTest2(){
        assertEquals(new Integer(5), test1.get(test1.size() - 1));
    }

    @Test
    public void getTest3(){
        assertEquals(5, test1.size());
        test1.get(0);
        assertEquals(5, test1.size());
    }

    @Test
    public void isEmptyTest1(){
        assertEquals(true, empty.isEmpty());
    }

    @Test
    public void isEmptyTest2(){
        assertEquals(false, test1.isEmpty());
        test1.clear();
    }

    @Test
    public void isEmptyTest3(){
        assertEquals(5, test1.size());
        test1.clear();
        assertEquals(0, test1.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeTest_exception_1(){
       test1.remove(-10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeTest_exception_2(){
        test1.remove(test1.size());
    }

    @Test
    public void removeTest1(){
        assertEquals(5, test1.size());
        test1.remove(0);
        assertEquals(4, test1.size());
    }

    @Test
    public void removeTest2(){
        assertEquals(new Integer(1), test1.remove(0));

    }

    @Test
    public void removeTest3(){
        test1.remove(0);
        assertEquals("[(head) -> 2 -> 3 -> 4 -> 5 -> (tail)]", test1.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setTest_exception1(){
       test1.set(-1, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setTest_exception2(){
        test1.set(test1.size(), 100);
    }

    @Test(expected = NullPointerException.class)
    public void setTest_exception3(){
        test1.set(0, null);
    }

    @Test
    public void setTest1(){
        assertEquals(5, test1.size());
        test1.set(0,100);
        assertEquals(5, test1.size());
    }

    @Test
    public void setTest2(){
        test1.set(0,100);
        assertEquals(new Integer(100), test1.get(0));
    }

    @Test
    public void setTest3(){
        test1.set(0,100);
        assertEquals("[(head) -> 100 -> 2 -> 3 -> 4 -> 5 -> (tail)]", test1.toString());
    }

    @Test
    public void sizeTest1(){
        assertEquals(5, test1.size());
    }

    @Test
    public void sizeTest2(){
        assertEquals(0, empty.size());
    }

    @Test
    public void sizeTest3(){
        assertEquals(5, test1.size());
        test1.remove(0);
        assertEquals(4, test1.size());
    }

    @Test
    public void toStringTest1(){
        assertEquals("[(head) -> (tail)]", empty.toString());
    }

    @Test
    public void toStringTest2(){
        assertEquals("[(head) -> 1 -> 2 -> 3 -> 4 -> 5 -> (tail)]", test1.toString());
    }

    @Test
    public void toStringTest3(){
        assertEquals("[(head) -> 1 -> 2 -> 3 -> 4 -> 5 -> (tail)]", test1.toString());
        test1.remove(3);
        assertEquals("[(head) -> 1 -> 2 -> 3 -> 5 -> (tail)]", test1.toString());
        test1.set(1, 50);
        assertEquals("[(head) -> 1 -> 50 -> 3 -> 5 -> (tail)]", test1.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeMultipleOfTest_exception1(){
        test1.removeMultipleOf(0);
    }

    @Test
    public void removeMultipleOfTest1(){
        test1.removeMultipleOf(2);
        assertEquals(2, test1.size());
    }

    @Test
    public void removeMultipleOfTest2(){
        test1.removeMultipleOf(1);
        assertEquals(true, test1.isEmpty());
    }

    @Test
    public void removeMultipleOfTest3(){
        DoublyLinkedList<Integer> test3 = new DoublyLinkedList<Integer>();
        for(int i = 0;i < 9;i++){
            test3.add(i+1);
        }

        test3.removeMultipleOf(3);
        assertEquals("[(head) -> 2 -> 3 -> 5 -> 6 -> 8 -> 9 -> (tail)]", test3.toString());
    }

    @Test
    public void swapSegmentTest1(){
        test1.swapSegment(test2, 2);
        assertEquals(5, test1.size());
        assertEquals(5, test2.size());
    }

    @Test
    public void swapSegmentTest2(){
        test1.swapSegment(test2, 2);
        assertEquals(5, test1.size());
        assertEquals(5, test2.size());
    }

    @Test
    public void swapSegmentTest3(){
        test1.swapSegment(test2, 2);
        assertEquals("[(head) -> 5 -> 6 -> 7 -> 4 -> 5 -> (tail)]", test1.toString());
        assertEquals("[(head) -> 1 -> 2 -> 3 -> 8 -> 9 -> (tail)]", test2.toString());
    }

}
