public class Test {

    public static void main(String[] args){
        DLLQueue<Integer> test = new DLLQueue<Integer>();


        System.out.println(test.size());
        System.out.println(test.isEmpty());

        test.enqueue(new Integer(10));
        test.enqueue(new Integer(101));

        System.out.println(test.peek());
        System.out.println(test.size());
        System.out.println(test.isEmpty());


    }
}
