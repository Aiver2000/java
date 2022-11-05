package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(char val){
        this.val = val;
    }
}
public class BinaryTree {
    public TreeNode root;


    int i = 0;
    public TreeNode createTree(String str){
        TreeNode root = null;
        if(str.charAt(i) != '#'){
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else{
            i++;
        }
        return root;
    }

    int count = 0;
    int size1(TreeNode root){
        if(root == null){
            return 0;
        }
        count++;
        size1(root.left);
        size1(root.right);
        return count;
    }

    int size2(TreeNode root){
        if(root == null) return 0;
        return size2(root.left) + size2((root.right)) + 1;
    }

    int leafCount = 0;
     void getLeafNodeCount(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafCount++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);

    }
    int getLeafNodeCount2(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);

    }

    int getKLevelNodeCount(TreeNode root,int k){
         if(root == null || k<= 0 ){
             return 0;
         }
        if(k == 1){
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1)+getKLevelNodeCount(root.right,k-1);
    }

    int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return left > right ? left+1:right +1;
     }

    TreeNode find(TreeNode root,char val){
        if(root == null){
             return null;
         }
         if(root.val == val){
             return root;
         }
         TreeNode ret = find(root.left,val);
         if(ret != null){
             return ret ;
         }
         ret = find(root.right,val);
         if(ret != null){
             return ret ;
         }
         return null;
    }

    boolean isCompleteTree(TreeNode root){
         if(root == null) return true;
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         while (!queue.isEmpty()){
             TreeNode cur = queue.poll();
             if(cur != null){
                 queue.offer(root.left);
                 queue.offer(root.right);
             }else {
                 break;
             }
         }
         while (!queue.isEmpty()){
             TreeNode top = queue.peek();
             if(top != null){
                return false;
             }
             queue.poll();
         }
         return true;
    }









    /**
     * 二叉树遍历
     * @param root
     */
    void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public List<Character> preorderTraversal(TreeNode root) {
        List<Character> retList = new ArrayList<>();
        if(root == null){
            return retList;
        }
        retList.add(root.val);
        List<Character> leftTree =  preorderTraversal(root.left);
        retList.addAll(leftTree);
        List<Character> rightTree = preorderTraversal(root.right);
        retList.addAll(rightTree);
        return retList;
    }

    void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
    public List<Character> inorderTraversal(TreeNode root) {
        List<Character> retList = new ArrayList<>();
        if(root == null){
            return retList;
        }
        List<Character> leftTree =  inorderTraversal(root.left);
        retList.addAll(leftTree);
        retList.add(root.val);
        List<Character> rightTree = inorderTraversal(root.right);
        retList.addAll(rightTree);
        return retList;
    }

    void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }
    public List<Character> postorderTraversal(TreeNode root) {
        List<Character> retList = new ArrayList<>();
        if(root == null){
            return retList;
        }
        List<Character> leftTree =  postorderTraversal(root.left);
        retList.addAll(leftTree);
        List<Character> rightTree = postorderTraversal(root.right);
        retList.addAll(rightTree);
        retList.add(root.val);
        return retList;
    }

}
