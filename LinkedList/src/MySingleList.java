public class MySingleList implements ILinkedList{

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
        checkPos(index);

        if(index == 0) {
            addFirst(data);
        }
        else if (index == size()) {
            addLast(data);
        }else{
            //中间位置的插入
            ListNode cur = findIndex(index);
            ListNode node = new ListNode(data);
            node.next = cur.next;
            cur.next = node;
        }
    }

    private ListNode findIndex(int index) {
        ListNode cur = head;
        int count = 0;
        while (count != index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }


    private void checkPos(int index){
        if(index < 0 || index > size()){
            throw new CheckPosException("index不合要求");
        }
    }


    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = head;

        while(cur != null){
            if(key == cur.val){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第⼀次出现关键字为key的节点
    public void remove(int key){
        ListNode node = search(key);
        if(node == null){
            System.out.println("未找到需要移除的key值");
        }
        if(head.val == key){
            head = head.next;
            return;
        }
        node.next  = node.next.next;
    }

    /**
     * 寻找key值对应的节点
     * @param key
     * @return
     */
    public ListNode search(int key){
        ListNode cur = head;
        if(cur.val == key) return head;
        while(cur.next != null){
            if(cur.next.val == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        if(head == null) {
            return;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        //最后判断一次头节点
        if(head.val == key) {
            head = head.next;
        }
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
        head = null;
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
