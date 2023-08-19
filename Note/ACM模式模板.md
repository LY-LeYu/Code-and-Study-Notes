```
//基础模板
import java.lang.*;
import java.util.*;
public class Main{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            
        }
    }
}
```

```
//构造二叉树
import java.lang.*;
import java.util.*;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    public TreeNode(char val) {
        this.val = val;
    }
}

public class Main{
    
    static TreeNode[] nodes = new TreeNode[30];
    //初始化节点数组
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
        	//节点数
            int len = sc.nextInt();
            //初始化节点并保存至数组
            for (int i = 0; i < len; i++) {
                char val = sc.next().charAt(0);
                int left = sc.nextInt();
                int right = sc.nextInt();
                
                if (nodes[i + 1] == null) {
                    nodes[i + 1] = new TreeNode(val);
                } else {
                    nodes[i + 1].val = val;
                }
                // 说明有左节点
                if (left != 0) {
                    if (nodes[left] == null) {
                        nodes[left] = new TreeNode('\0');
                    }
                    nodes[i + 1].left = nodes[left];
                }
                if (right != 0) {
                    if (nodes[right] == null) {
                        nodes[right] = new TreeNode('\0');
                    }
                    nodes[i + 1].right = nodes[right];
                }
            }
        }
  }
```

