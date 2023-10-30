package binarytree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int num = 4;
        TreeNode root = treeify(num);
        List<Integer> result1 = Traversal.inorderTraversal1(root);
        List<Integer> result2 = Traversal.preorderTraversal1(root);
        List<Integer> result3 = Traversal.postorderTraversal1(root);

        System.out.println("前序遍历结果为："+result1);
        System.out.println("中序遍历结果为："+result2);
        System.out.println("后序遍历结果为："+result3);

    }

    public static TreeNode treeify(int len) {
        TreeNode[] nodes = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = new TreeNode(i + 1);
        }
        if (len > 0) {
            for (int i = 0; i <= len / 2 - 1; i++) { //从第一个节点开始树化至最后一个非叶子节点
                if (i * 2 + 1 < len) {
                    nodes[i].left = nodes[i * 2 + 1];
                }
                if (i * 2 + 2 < len) {
                    nodes[i].right = nodes[i * 2 + 2];
                }
            }
        }
        return nodes[0];
    }
}
