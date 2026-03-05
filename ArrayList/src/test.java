import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.display();
        list.add(2,10);

        list.display();
        System.out.println(list.contains(4));
        System.out.println(list.indexOf(10));

        list.remove(5);
        list.display();

    }
}
