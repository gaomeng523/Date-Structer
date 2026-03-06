import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class test {
    /**
     * 实现杨辉三角
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ret = new ArrayList<>();

        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        ret.add(row1);
        for(int i = 1 ; i < numRows ;i++){
            List<Integer> curRow = new ArrayList<>();
            //第一个数字
            curRow.add(1);

            List<Integer> preRow = ret.get(i - 1);
            for (int j = 1; j < i; j++) {
                int x = preRow.get(j) + preRow.get(j - 1);
                curRow.add(x);
            }
            //最后一个数字
            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }





    /**
     * 常用的arrayList方法
     * @param args
     */
    public static void main3(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("JavaSE");
        list.add("JavaWeb");
        list.add("JavaEE");
        list.add("JVM");
        list.add("测试课程");
        System.out.println(list.size());

        //获取和设置index位置上的元素，注意index必须介入[0 , size)之间
        System.out.println(list.get(1));
        list.set(1 , "JavaWEB");
        System.out.println(list.get(1));

        //在list的index位置插⼊指定元素，index及后续的元素统⼀往后搬移⼀个位置
        list.add(1 , "java数据结构");
        System.out.println(list);
        // 删除指定元素，找到了就删除，该元素之后的元素统⼀往前搬移⼀个位置
        list.remove("JVM");
        System.out.println(list);
        // 删除list中index位置上的元素，注意index不要超过list中有效元素个数
        list.remove(list.size() - 1);
        System.out.println(list);
        // 检测list中是否包含指定元素，包含返回true，否则返回false
        if(list.contains("测试课程")){
            list.add("测试课程");
        }

        // 查找指定元素第⼀次出现的位置：indexOf从前往后找，lastIndexOf从后往前找
        list.add("JavaSE");
        System.out.println(list.indexOf("JavaSE"));
        System.out.println(list.lastIndexOf("JavaSE"));
        // 使⽤list中[0, 4)之间的元素构成⼀个新的SubList返回,但是和ArrayList共⽤⼀个elementData数组

        List<String> ret = list.subList(0, 4);
        System.out.println(ret);
        list.clear();
        System.out.println(list.size());

        //使用迭代器遍历
        ListIterator<String> it = list.listIterator();
        while(it.hasNext()){
            System.out.println(it.next() + " ");
        }
        System.out.println();

    }


    public static void main2(String[] args) {

        //构造一个空的列表
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        //构造一个具有10个容量的列表
        List<Integer> list2 = new ArrayList<>(10);

        //List3构造好之后，与list中的元素一致
        ArrayList<Integer> list3 = new ArrayList<>(list2);
    }
    public static void main1(String[] args) {
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
