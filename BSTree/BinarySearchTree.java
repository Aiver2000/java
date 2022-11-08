package BSTree;

class Node{
    public int val;
    public Node left;
    public Node right;
    public Node(int val){
        this.val = val;
    }
}
public class BinarySearchTree {
    public Node root = null;

    public Node search(int key){
        Node cur = root;
        while (cur != null){
            if(key>cur.val){
                cur = cur.right;
            }else if(key<cur.val){
                cur = cur.left;
            }else {
                return cur;
            }
        }
        return null;
    }
    public boolean insert(int val){
        if(root == null){
            root = new Node(val);
            return true;
        }
        Node parent = null;
        Node cur = root;
        while (cur != null){
            if(val > cur.val){
                parent = cur;
                cur = cur.right;
            }else if(val <cur.val){
                parent = cur;
                cur = cur.left;
            }else {
                return false;
            }
        }
        if(val>parent.val){
            parent.right = new Node(val);
        }
        if(val < parent.val){
            parent.left = new Node(val);
        }
        return true;

    }

    public void remove(int key){
        Node cur = root;
        Node parent = null;
        while (cur!=null){
            if(cur.val  == key){
                removeNode(cur,parent);
                break;
            }else if(cur.val < key){
                parent= cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }

    }
    public void removeNode(Node cur,Node parent){
        if(cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        }else if(cur.right == null){
            if(cur == root){
                root = cur.left;
            }else if(cur == parent.left){
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            Node targetParent = cur;
            Node target = cur.right;
            while (target.left!=null){
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if(target == targetParent.left){
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }

    }

    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+ " ");
        inOrder(root.right);
    }

}
