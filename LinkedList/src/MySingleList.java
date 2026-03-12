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
        ListNode cur = head;
        while(cur != null){
            cur.next = null;
            cur.val = 0;
        }
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


    public ListNode reverseList() {
        //1.判断链表是不是空的
        if(head == null) {
            return null;
        }
        //2. 判断是不是只有1个节点
        if(head.next == null) {
            return head;
        }
        //3. 说明至少有2个节点及其以上
        ListNode cur = head.next;
        head.next = null;

        while(cur != null) {
            ListNode curN = cur.next;
            //这2行代码在进行头插
            cur.next = head;
            head = cur;
            //
            cur = curN;
        }
        return head;
    }

    /**
     * 重载的方法
     * @param newHead
     */
    public void display(ListNode newHead) {
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }


    /**
     * 中间节点
     * @param
     * @return
     */
    public ListNode middleNode() {

        ListNode fast= head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            //while (fast.next != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 倒数第K个节点
     * @param k
     * @return
     */
    public int kthToLast(int k) {
        //1.判断k的值的 合法性
        if(k <= 0 || head == null) {
            return -1;
        }

        //2.先让fast走K-1步
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while (count != k-1) {
            fast = fast.next;
            if(fast == null) {
                return -1;
            }
            count++;
        }
        //3.开始同时出发
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }


    public boolean chkPalindrome() {
        // write code here
        if(head == null) {
            return true;
        }
        //1.找中间节点
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2.slow此时指向了中间位置 开始翻转后半部分
        ListNode cur = slow.next;
        while(cur != null) {
            ListNode curN = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curN;
        }
        //3. 此时head和cur一直走 直到相遇
        while(head != slow) {
            if(head.val != slow.val) {
                return false;
            }
            //判断偶数的情况
            if(head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead == null) {
            return null;
        }

        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;

        ListNode cur = pHead;
        while( cur != null) {
            if(cur.val < x) {
                //小于x
                if(bs == null) {
                    //说明这是第一次进行插入
                    bs = be = cur;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                //大于等于x
                if(as == null) {
                    as = ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //第一个段 没有数据
        if(bs == null) {
            return as;
        }
        be.next = as;
        if(as != null) {
            ae.next = null;
        }
        return bs;
    }


    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    public void createLoop() {
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = head.next;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }

        //1.没有环    2.有环（遇到break结束）
        if(fast == null || fast.next == null) {
            return null;//没有环
        }

        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }
}
