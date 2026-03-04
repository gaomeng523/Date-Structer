package demo3;

public class TestDemo {
    public static void main(String[] args) {
        MyArray<Integer> myArray = new MyArray<>();//1
        myArray.setVal(0,10);
        myArray.setVal(1,12);
        int ret = myArray.getPos(1);//2
        System.out.println(ret);

        MyArray<String> myArray1 = new MyArray<>();
        myArray1.setVal(2,"bit");//3
    }
}
