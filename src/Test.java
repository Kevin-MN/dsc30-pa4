public class Test {

    public static void main(String[] args){
        DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();

        System.out.println(test.isEmpty());
        System.out.println(test.size());

        test.add(new Integer(10));
        test.add(new Integer(100));
        System.out.println(test.toString());
        System.out.println(test.isEmpty());
        System.out.println(test.size());


        test.clear();
        System.out.println(test.toString());
        System.out.println(test.isEmpty());
        System.out.println(test.size());

        test.add(0,new Integer(10));

        System.out.println(test.toString());
        System.out.println(test.isEmpty());
        System.out.println(test.size());

        test.add(1,new Integer(101));

        System.out.println(test.toString());
        System.out.println(test.isEmpty());
        System.out.println(test.size());

        System.out.println("\n\n\n" + test.set(0, new Integer(90)) + "\n\n\n");

        System.out.println(test.toString());
        System.out.println(test.isEmpty());
        System.out.println(test.size());


        test.clear();
        System.out.println(test.toString());
        System.out.println(test.isEmpty());
        System.out.println(test.size());
    }
}
