public class MyLinkedList implements ILinkedList{
    /**
     * @Author 12629
     * @Description：
     */


        static class ListNode {
            public int val;
            public ListNode prev;
            public ListNode next;

            public ListNode(int val) {
                this.val = val;
            }
        }


        public ListNode head;

        public ListNode last;


        @Override
        public void addFirst(int data) {
            ListNode node = new ListNode(data);
            if(head == null) {
                head = node;
                last = node;
            }else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        @Override
        public void addLast(int data) {
            ListNode node = new ListNode(data);
            if(head == null) {
                head = node;
                last = node;
            }else {
                last.next = node;
                node.prev = last;
                last = node;
            }
        }

        @Override
        public void addIndex(int index, int data) {
            //1.检查index的合法性

            //2.特殊位置处理
            if(index == 0) {
                addFirst(data);
                return;
            }
            if(index == size()) {
                addLast(data);
                return;
            }
            //3.
            ListNode cur = searchIndex(index);
            ListNode node = new ListNode(data);

            node.next = cur;
            cur.prev.next = node;
            node.prev = cur.prev;
            cur.prev = node;
        }
        private ListNode searchIndex(int index) {
            ListNode cur = head;
            while (index != 0) {
                cur = cur.next;
                index--;
            }
            return cur;
        }

        @Override
        public boolean contains(int key) {
            ListNode cur = head;
            while (cur != null) {
                if(cur.val == key) {
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }

        @Override
        public void remove(int key) {
            ListNode cur = head;
            while (cur != null) {
                if(cur.val == key) {
                    //开始删除
                    if(cur == head) {
                        //删除的节点是头节点
                        head = head.next;
                        if(head != null) {
                            //防止 当前双向链表 只有1个节点
                            head.prev = null;
                        }
                    }else {
                        cur.prev.next = cur.next;
                        //删除的节点不是头节点
                        if(cur.next == null) {
                            //删除尾巴节点
                            last = last.prev;
                        }else {
                            //删除中间节点
                            cur.next.prev = cur.prev;
                        }
                    }
                    return;
                }
                cur = cur.next;
            }
        }

        @Override
        public void removeAllKey(int key) {
            ListNode cur = head;
            while (cur != null) {
                if(cur.val == key) {
                    //开始删除
                    if(cur == head) {
                        //删除的节点是头节点
                        head = head.next;
                        if(head != null) {
                            //防止 当前双向链表 只有1个节点
                            head.prev = null;
                        }
                    }else {
                        cur.prev.next = cur.next;
                        //删除的节点不是头节点
                        if(cur.next == null) {
                            //删除尾巴节点
                            last = last.prev;
                        }else {
                            //删除中间节点
                            cur.next.prev = cur.prev;
                        }
                    }
                    //return;
                }
                cur = cur.next;
            }
        }

        @Override
        public int size() {
            int count = 0;
            ListNode cur = head;
            while (cur != null) {
                count++;
                cur = cur.next;
            }
            return count;
        }

        @Override
        public void clear() {
            ListNode cur = head;
            while (cur != null) {
                ListNode curN = cur.next;
                cur.prev = null;
                cur.next = null;
                cur = curN;
            }
            head = null;
            last = null;
        }

        @Override
        public void display() {
            ListNode cur = head;
            while (cur != null) {
                System.out.print(cur.val+" ");
                cur = cur.next;
            }
            System.out.println();
        }
}
