import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        BinaryTree.TreeNode root = binaryTree.createBinaryTree();

        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.postOrder(root);

        System.out.println();
        System.out.println("节点个数: " + binaryTree.size(root));

        binaryTree.getLeafNodeCount(root);
        System.out.println("叶子节点的个数: " + BinaryTree.LeafNodeCount);

        System.out.println("层节点个数： "+ binaryTree.getKLevelNodeCount(root , 1));

        System.out.println("二叉树的高度：" + binaryTree.getHeight(root));

        System.out.println(binaryTree.find(root , 'M'));

        binaryTree.levelOrder(root);
        System.out.println();
        List<List<Character>> ret = new ArrayList<>();
         ret = binaryTree.levelOrder2(root);
        System.out.println(ret);
    }


}
