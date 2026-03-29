
public class HashBacket {

    private static class Node{
        private int key;
        private int value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    private Node[] array;
    private int size; // 当前的数据个数
    private static final double LOAD_FACTOR = 0.75;

    public HashBacket(Node[] array, int size) {
        this.array = array;
        this.size = size;
    }

    public int put(int key , int value){
        int index = key % array.length;

        for(Node cur = array[index] ; cur != null ; cur = cur.next){
            if (key == cur.key){
                int OldValue = cur.value;
                cur.value = value;
                return OldValue;
            }
        }

        Node node = new Node(key, value);
        node.next = array[index];
        array[index] = node;
        size++;

        if (loadFactor() >= LOAD_FACTOR) {
            resize();
        }
        return -1;
    }

    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node next;
            for (Node cur = array[i]; cur != null; cur = next) {
                next = cur.next;
                int index = cur.key % newArray.length;
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        array = newArray;
    }

    private double loadFactor() {
        return size * 0.1 / array.length;
    }


    public int get(int key) {
        int index = key % array.length;
        Node head = array[index];
        for (Node cur = head; cur != null; cur = cur.next) {
            if (key == cur.key) {
                return cur.value;
            }
        }
        return -1;
    }


}
