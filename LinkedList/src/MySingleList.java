public class MySingleList {

    static class ListNode{
        public int val;

        public ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    ListNode head;

    public void createList(){
        ListNode list1 = new ListNode(12);
        ListNode list2 = new ListNode(23);
        ListNode list3 = new ListNode(34);
        ListNode list4 = new ListNode(45);
        ListNode list5 = new ListNode(56);
        ListNode list6 = new ListNode(67);

        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        list5.next = list6;

        head = list1;
    }


    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }


    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        //1. 先判断head 节点是否为空 ，如果为空直接插入。
        if(head == null){
            head = node;
            return ;
        }
        //2. 找到尾巴，将节点加入尾巴。
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }


    //任意位置插⼊,第⼀个数据节点为0号下标
    public void addIndex(int index,int data){
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        return false;
    }
    //删除第⼀次出现关键字为key的节点
    public void remove(int key){

    }
    //删除所有值为key的节点
    public void removeAllKey(int key){

    }
    //得到单链表的⻓度
    public int size(){
        int size = 0;
        ListNode cur = head;

        while(cur != null){
            size++;
            cur = cur.next;
        }
        return size;
    }
    public void clear() {


    }

    /**
     * 遍历
     */
    public void display() {
        ListNode cur = head;

        while(cur != null){
            System.out.print (cur.val + " ");
            cur = cur.next;
        }
    }
}
