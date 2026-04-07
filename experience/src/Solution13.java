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



}
