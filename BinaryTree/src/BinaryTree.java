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
}
