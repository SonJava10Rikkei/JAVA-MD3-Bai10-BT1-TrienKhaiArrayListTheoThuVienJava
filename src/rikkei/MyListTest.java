package rikkei;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myListInteger = new MyList<Integer>();
        myListInteger.add(0, 0);
        myListInteger.add(1, 1);
        myListInteger.add(2, 3);
        myListInteger.add(3, 4);
        myListInteger.add(4, 4);
        myListInteger.add(5, 4);
        myListInteger.add(6, 4);
        myListInteger.add(7, 4);
        myListInteger.add(8, 4);
        myListInteger.add(9, 4);
        myListInteger.add(10, 4);


        System.out.println(myListInteger.get(3));
        int a = myListInteger.indexOf(4);
        System.out.println(a);
    }
}
