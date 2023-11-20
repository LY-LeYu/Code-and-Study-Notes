package binarytree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Traversal {
    public static List<Integer> result;

    public static List<Integer> inorderTraversal1(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    public static List<Integer> preorderTraversal1(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if (temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }
        return result;
    }

    public static List<Integer> postorderTraversal1(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if(temp.left != null)
                stack.push(temp.left);
            if (temp.right != null)
                stack.push(temp.right);

        }
        Collections.reverse(result);
        return result;
    }


}
