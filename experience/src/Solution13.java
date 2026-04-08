import java.util.*;

public class Solution13 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     *N 叉树的层序遍历（medium）
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int sz = q.size();
            for(int i = 0; i < sz; i++)
            {
                Node t = q.poll();
                tmp.add(t.val);
                for(Node child : t.children) // 让孩⼦⼊队
                {
                    if(child != null)
                        q.add(child);
                }
            }
            ret.add(tmp);
        }
        return ret;
    }

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;

      }
  }

    /**
     * ⼆叉树的锯⻮形层序遍历（medium）
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        int tmp = 1;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            List<Integer> row = new ArrayList<>();
            //计算每一行有几个元素
            int count = qu.size();
            while(count-- != 0){
                TreeNode node = qu.poll();
                if(node.left != null) qu.offer(node.left);
                if(node.right != null) qu.offer(node.right);
                row.add(node.val);
            }
            if(tmp % 2 == 0) Collections.reverse(row);
            tmp++;
            ret.add(row);
        }
        return ret;
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }
    public int widthOfBinaryTree(TreeNode root) {
        List<Pair<TreeNode , Integer>> row = new ArrayList<>();

        row.add(new Pair<TreeNode , Integer>(root , 1));

        int ret = 0;
        while(!row.isEmpty()){
            //更新一下最后结果
            Pair<TreeNode , Integer> t1 = row.get(0);
            Pair<TreeNode , Integer> t2 = row.get(row.size() - 1);

            ret = Math.max(t2.getValue() - t1.getValue() + 1 , ret);

            // 让下⼀层进队
            List<Pair<TreeNode, Integer>> tmp = new ArrayList<>();
            for(Pair<TreeNode , Integer> m : row){
                TreeNode node = m.getKey();
                int index = m.getValue();

                if(node.left != null) tmp.add(new Pair<TreeNode , Integer>(node.left , 2*index));
                if(node.right != null) tmp.add(new Pair<TreeNode , Integer>(node.right , 2*index + 1));

            }
            row = tmp;
        }
        return ret;
    }

    /**
     * 在每个树⾏中找最⼤值（medium）
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);

        while(!qu.isEmpty()){
            int count = qu.size();
            int max = Integer.MIN_VALUE;
            while(count-- != 0){
                TreeNode node = qu.poll();
                max = Math.max(max , node.val);
                if(node.left != null) qu.offer(node.left);
                if(node.right != null) qu.offer(node.right);
            }
            ret.add(max);
        }
        return ret;
    }
}
