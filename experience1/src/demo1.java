public class demo1 {
    public static void main1(String[] args) {
        int i = 10;

        //装箱操作，新建一个 Integer 类型对象，将i 的值放入对象的某个属性中
        Integer ii = Integer.valueOf(i);
        Integer ij = new Integer(i);

        //拆箱操作， 将Integer 对象中的值取出， 放到一个基本数据类型中
        int j = ii.intValue();
    }

    public static void main2(String[] args) {
        int i = 10;
        Integer ii = i; // ⾃动装箱
        Integer ij = (Integer)i; // ⾃动装箱
        int j = ii; // ⾃动拆箱
        int k = (int)ii; // ⾃动拆箱
    }

    public static void main3(String[] args) {
        Integer a = -128;
        Integer b = -128;

        Integer c = 128;
        Integer d = 128;
        System.out.println(a == b);    // true
        System.out.println(c == d);    // false
    }
}
