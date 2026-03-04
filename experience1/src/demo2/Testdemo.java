package demo2;

public class Testdemo {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.setVal(0 , 10);
        myArray.setVal(1 , "hello");

    //    String ret = myArray.getPos(1); 如果不强制类型转换会编译报错
        String ret = (String)myArray.getPos(1);
        System.out.println(ret);
    }
}
