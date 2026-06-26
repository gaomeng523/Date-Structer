package btree;

public class MyBtree {
    static class BTRNode{
        public static final int M=3;
        public int[] keys; //关键字
        public BTRNode[] subs; //孩子
        public BTRNode parent; //存储当前孩子节点的父亲节点
        public int usedSize;//记录当前节点中关键字的数量

        public BTRNode (){
            // 说明：这里多给一个 ， 是为了好进行分裂
            this.keys = new int[M];
            this.subs = new BTRNode[M + 1];
        }

        public BTRNode root;

        public boolean insert(int key){
            //1. 如果B树中没有任何数据
            if(root == null){
                root = new BTRNode();
                root.keys[0] = key;
                root.usedSize++;
                return true;
            }
            //2. 先查看现在的B树中是否存在这个key
            Pair<BTRNode,Integer> pair = find(key);
            if(pair.getVal() != -1){
                return false;
            }

            //3. 到这里说明不存在这个key， 可以进行插入
            BTRNode parent = pair.getKey();
            int index = parent.usedSize - 1;
            for(;index >= 0 ; index--){
                if(parent.keys[index] >= key){
                    parent.keys[index + 1] = parent.keys[index];
                }else{
                    break;
                }
            }

            parent.keys[index + 1] = key;
            parent.usedSize++;

            if(parent.usedSize >= M){
                //说明当前节点已经满了
                split(parent);
            }else{
                return true;
            }

            return false;
        }

        /**
         * 分裂
         * @param parent
         */
        private void split(BTRNode parent){

        }



        private Pair<BTRNode,Integer> find(int key){
            BTRNode cur = root;
            BTRNode parent = null;
            while(cur != null){
                int i = 0;
                while(i < cur.usedSize){
                    if(cur.keys[i] == key){
                        return new Pair<>(cur , i);
                    }else if (cur.keys[i] < key) {
                        i++;
                    }else{
                        break;
                    }
                }
                parent = cur;
                cur = cur.subs[i];
            }
            // 让返回值等于-1，可以确定B树中不存在这个key
            return new Pair<>(parent , -1);
        }
    }
}
