import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DLLQueueTest {
    DLLQueue<Integer> empty;
    DLLQueue<Integer> test1;

    @Before
    public void setup(){
        empty = new DLLQueue<Integer>();
        test1 = new DLLQueue<Integer>();

        for(int i = 0;i < 5; i++){
            test1.enqueue(i);
        }
    }

    @Test
    public void dllQueueContructorTest1(){
        DLLQueue<Integer> temp = new DLLQueue<Integer>();
        assertEquals(0, temp.size());
    }

    @Test
    public void dllQueueContructorTest2(){
        DLLQueue<Integer> temp = new DLLQueue<Integer>();
        assertEquals(true, empty.isEmpty());
    }

    @Test
    public void dllQueueContructorTest3(){
        DLLQueue<Integer> temp = new DLLQueue<Integer>();
        assertEquals(null ,temp.peek());
    }

    @Test
    public void sizeTest1(){
        assertEquals(0 ,empty.size());
    }

    @Test
    public void sizeTest2(){
        assertEquals(5 ,test1.size());
    }

    @Test
    public void sizeTest3(){
        assertEquals(5 ,test1.size());
        test1.dequeue();
        assertEquals(4, test1.size());
    }

    @Test
    public void isEmptyTest1(){
        assertEquals(true ,empty.isEmpty());
    }

    @Test
    public void isEmptyTest2(){
        assertEquals(false ,test1.isEmpty());
    }

    @Test
    public void isEmptyTest3(){
        assertEquals(true ,empty.isEmpty());
        empty.enqueue(10);
        assertEquals(false ,empty.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void enqueueTest_exception1(){
        test1.enqueue(null);
    }

    @Test
    public void enqueueTest1(){
        empty.enqueue(10);
        assertEquals(1,empty.size());
    }

    @Test
    public void enqueueTest2(){
        empty.enqueue(10);
        assertEquals(new Integer(10),empty.dequeue());
    }

    @Test
    public void enqueueTest3(){
        test1.enqueue(10);
        assertEquals(6,test1.size());
    }

    @Test
    public void dequeueTest1(){
        assertEquals(new Integer(0) ,test1.dequeue());
    }

    @Test
    public void dequeueTest2(){
        empty.enqueue(10);
        assertEquals(new Integer(10) ,empty.dequeue());
    }

    @Test
    public void dequeueTest3(){
        assertEquals(5 ,test1.size());
        test1.dequeue();
        test1.dequeue();
        assertEquals(3 ,test1.size());
    }

    @Test
    public void peekTest1(){
        assertEquals(new Integer(0) ,test1.peek());
    }

    @Test
    public void peekTest2(){
        assertEquals(5, test1.size());
        test1.peek();
        assertEquals(5, test1.size());
    }

    @Test
    public void peekTest3(){
        assertEquals(null ,empty.peek());
    }

}
