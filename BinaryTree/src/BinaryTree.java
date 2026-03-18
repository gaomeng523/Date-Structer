import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        char val;

        TreeNode(char value){
            this.val = value;
        }
    }

    private TreeNode root;

    public TreeNode createBinaryTree(){
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }


    // 前序遍历
    void preOrder(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    // 中序遍历
    void inOrder(TreeNode root) {
        if(root == null){
            return;
        }
        preOrder(root.left);
        System.out.print(root.val + " ");
        preOrder(root.right);
    }
    // 后序遍历
    void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val + " ");
    }

    // 获取树中节点的个数
    int size(TreeNode root){
        // 节点个数 = 左子树节点个数 + 右子树节点个数 + 1
        // 可以利用递归的策略

        if(root == null){
            return 0;
        }

        return size(root.left) + size(root.right) + 1;
    }

    static int LeafNodeCount;
    // 获取叶⼦节点的个数
    void getLeafNodeCount(TreeNode root){
        if(root == null){
            return ;
        }
        //叶子节点个数 = 左子树的叶子节点个数 + 右子树的叶子节点个数
        if(root.left == null && root.right == null){
            LeafNodeCount++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
    }

    // 获取第K层节点的个数
    int getKLevelNodeCount(TreeNode root,int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelNodeCount(root.left , k-1) + getKLevelNodeCount(root.right , k-1);

    }
    // 获取⼆叉树的⾼度
    int getHeight(TreeNode root){
        if(root == null) {
            return 0;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        return Math.max(leftH , rightH) + 1;
    }

    // 检测值为value的元素是否存在
    TreeNode find(TreeNode root, char val){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode ret = find(root.left , val);
        if(ret != null){
            return ret;
        }
        TreeNode ret2 = find(root.right , val);

        if(ret2 != null){
            return ret2;
        }
        return null;
    }

    //层序遍历
    void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode ret = queue.poll();
            System.out.print(ret.val + " ");
            if(ret.left != null) queue.offer(ret.left);
            if(ret.right != null) queue.offer(ret.right);
        }
    }


    public List<List<Character>> levelOrder2(TreeNode root) {
        List<List<Character>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Character> rows = new ArrayList<>();
            int count = queue.size();
            while(count != 0){
                TreeNode node = queue.poll();
                rows.add(node.val);
                count--;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            ret.add(rows);
        }
        return ret;
    }

    /**
     * 判断两棵树是否相同
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || p != null && q ==null){
            return false;
        }

        if(p == null && q == null) return true;
        if(p.val != q.val) return false;

        return isSameTree(p.left , q.left) && isSameTree(p.right , q.right);
    }

    /**
     * 判断是否为子树
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null && subRoot != null){
            return false;
        }
        if(isSameTree(root , subRoot)){
            return true;
        }

        return isSubtree(root.left , subRoot) || isSubtree(root.right , subRoot);
    }

    /**
     * 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        if(root.left == null && root.right == null) return root;
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    /**
     * 使用返回值实现二叉树的翻转
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        // 递归终止条件：节点为空，直接返回
        if (root == null) {
            return null;
        }

        // 递归翻转左子树
        TreeNode left = invertTree(root.left);
        // 递归翻转右子树
        TreeNode right = invertTree(root.right);

        // 交换当前节点的左右子树
        root.left = right;
        root.right = left;

        return root;
    }

    public boolean isBalanced(TreeNode root) {

    }

}


















