import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);

        System.out.println(set);
        System.out.println(set.size());
        //set不能重复添加，具有自动去重的效果
        set.add(2);
        System.out.println(set);

        set.remove(2);
        System.out.println(set);

        System.out.println(set.contains(1));
        System.out.println(set.contains(2));

        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
