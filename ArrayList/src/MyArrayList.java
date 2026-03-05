import java.util.Arrays;

public class MyArrayList implements IList{

    int[] array;
    int usedSize;


    public MyArrayList(){
        this.array = new int[Constant.DEFAULT_CAPACITY];
    }



    @Override
    public void add(int data) {
        if(isFull()){
            grow();
        }
        this.array[usedSize] = data;

        this.usedSize++;
    }

    /**
     * 判断顺序表是否满了
     * @return
     */
    public boolean isFull(){
        if(this.usedSize == this.array.length) {return true;}
        return false;
    }

    /**
     * 对顺序表进行扩容
     */
    public void grow(){
        this.array = Arrays.copyOf(this.array , 2*this.array.length);
    }
    @Override
    public void add(int pos, int data) {
        if(isFull()){
            grow();
        }
        String msg = Constant.ADD_POS_ILLEGALITY;
        checkPos(pos , msg);
        //2.判断是不是放在usedSize的位置
        if(pos == this.usedSize) {
            this.array[pos] = data;
            this.usedSize++;
            return;
        }
        //3.移动数据
        for(int i = this.usedSize - 1 ; i >= pos ; i--){
            array[i+1] = array[i];
        }
        array[pos] = data;
        this.usedSize++;
    }

    @Override
    public boolean contains(int toFind) {
        for(int i = 0 ; i < usedSize ;i++){
            if(this.array[i] == toFind){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int toFind) {
        for(int i = 0 ; i < usedSize ; i++){
            if(this.array[i] == toFind) return i;
        }
        return -1;
    }

    @Override
    public int get(int pos) {
        if(usedSize == 0){
            throw new EmptyListException(Constant.EMPTY_LIST);
        }
        String msg = Constant.GET_POS_ILLEGALITY;
        checkPos(pos , msg);

        return this.array[pos];
    }

    /**
     * 判断pos是否合法
     * @param pos
     * @param msg
     */
    public void checkPos(int pos , String msg){
        if(pos < 0 || pos >= Constant.DEFAULT_CAPACITY){
            throw new PosIllegalityException(msg);
        }
    }


    @Override
    public void set(int pos, int value) {
        if(usedSize == 0){
            throw new EmptyListException(Constant.EMPTY_LIST);
        }
        String msg = Constant.SET_POS_ILLEGALITY;
        checkPos(pos , msg);

        this.array[pos] = value;
    }

    @Override
    public void remove(int toRemove) {
        if(usedSize == 0) {
            throw new EmptyListException(Constant.EMPTY_LIST);
        }
        //2.查找要删除数据的下标
        int index = indexOf(toRemove);
        if(index == -1) {
            System.out.println("没有你要删除的数据...");
            return;
        }

        for (int i = index; i < usedSize-1; i++) {
            array[i] = array[i+1];
        }

        usedSize--;

        //elem[usedSize] = null; 如果是引用类型 需要手动置为空
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void clear() {
        for(int i = 0 ; i < usedSize ; i++){
            this.array[i] = 0;
        }
        usedSize = 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
}
