package demo2;

public class MyArray {
    public Object[] array = new Object[10];

    public Object getPos(int pos){
        return this.array[pos];
    }

    public void setVal(int pos , Object val){
        this.array[pos] = val;
    }
}
