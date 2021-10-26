import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DLLStackTest {
    DLLStack<Integer> empty;
    DLLStack<Integer> test1;

    @Before
    public void setup(){
        empty = new DLLStack<Integer>();
        test1 = new DLLStack<Integer>();

        for(int i = 0;i < 5; i++){
            test1.push(i);
        }
    }

    @Test
    public void dllStackContructorTest1(){
        DLLQueue<Integer> temp = new DLLQueue<Integer>();
        assertEquals(0, temp.size());
    }

    @Test
    public void dllStackContructorTest2(){
        DLLQueue<Integer> temp = new DLLQueue<Integer>();
        assertEquals(true, empty.isEmpty());
    }

    @Test
    public void dllStackContructorTest3(){
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
        test1.pop();
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
        empty.push(10);
        assertEquals(false ,empty.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void pushTest_exception1(){
        test1.push(null);
    }

    @Test
    public void pushTest1(){
        empty.push(10);
        assertEquals(1,empty.size());
    }

    @Test
    public void pushTest2(){
        empty.push(10);
        assertEquals(new Integer(10),empty.pop());
    }

    @Test
    public void pushTest3(){
        test1.push(10);
        assertEquals(6,test1.size());
    }

    @Test
    public void popTest1(){
        assertEquals(new Integer(4) ,test1.pop());
    }

    @Test
    public void popTest2(){
        empty.push(10);
        assertEquals(new Integer(10) ,empty.pop());
    }

    @Test
    public void popTest3(){
        assertEquals(5 ,test1.size());
        test1.pop();
        test1.pop();
        assertEquals(3 ,test1.size());
    }

    @Test
    public void peekTest1(){
        assertEquals(new Integer(4) ,test1.peek());
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
