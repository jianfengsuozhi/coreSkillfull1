package com.binaryTrees;

/**
 * 完全二叉树
 *  树 二叉树 完全二叉树 满二叉树： 树：唯一根结点,不相交  二叉树：最多只有两个结点  完全二叉树：若有序号则和满二叉树序号相同 满二叉树：完美的二叉树
 *  遍历算法：根节点的位置分为层次二叉树,前序二叉树(根节点-左结点-右结点),中序二叉树(左结点-根节点-右结点),后序二叉树(左结点-右结点-根节点)
 *  空树和只有一个根节点： 空树：没有结点  根节点只有一个
 *  二叉树的性质：根节点为i,左结点：2i,右结点:2i+1 完全二叉树从1开始
 * Created by weideliang on 2016/10/19.
 */
public class BinaryTree01 {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    private BinaryTree01(){
        root = new TreeNode(1, "rootNode(A)");
    }

    public void createBinaryTree(){
        TreeNode b = new TreeNode(2, "B");
        TreeNode c = new TreeNode(3, "C");
        root.leftChild = b;
        root.rightChild = c;

        TreeNode d = new TreeNode(4, "D");
        TreeNode e = new TreeNode(5, "E");
        b.leftChild = d;
        b.rightChild = e;

        TreeNode f = new TreeNode(6, "F");
        TreeNode g = new TreeNode(7, "G");
        c.leftChild = f;
        c.rightChild = g;
    }

    /**
     * 没有父结点这个名词,是双亲结点
     * @param element
     * @return
     */
    public TreeNode getParent(TreeNode element){
        //空树和根节点没有父结点
        return (null == root || root == element) ? null : this.parent(root,element);
    }

    private TreeNode parent(TreeNode subTree,TreeNode element){
        if(null == subTree){//截止
            return null;
        }
        if(element == subTree.leftChild || element == subTree.rightChild){//判断是否相等
           return subTree;
        }

        TreeNode p;
        if(null != (p = parent(subTree.leftChild,element))){//若左子树没有找到,则查找右子树
            return p;
        }else {
            return parent(subTree.rightChild, element);
        }
    }

    /**
     * 是否是空树
     * @return
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * 结点个数
     * @return
     */
    public int size(){
        return size(root);
    }

    private int size(TreeNode subTree){
        if(null == subTree){
            return 0;
        }
        return 1 + size(subTree.leftChild) + size(subTree.rightChild);
    }

    /**
     * 判断高度
     * @return
     */
    public int height(TreeNode element){
        if(null == element){
            return -1;
        }
        return Logarithm.log(element.key,2) + 1;
    }


    public static void main(String[] args) {
        BinaryTree01 binaryTree01 = new BinaryTree01();
        binaryTree01.createBinaryTree();
/*        System.out.println(binaryTree01.getParent(binaryTree01.getRoot()));
        System.out.println(binaryTree01.getParent(binaryTree01.getRoot().leftChild.rightChild).key);
        System.out.println(binaryTree01.getParent(binaryTree01.getRoot().rightChild.rightChild).key);*/

//        System.out.println(binaryTree01.height(binaryTree01.getRoot().leftChild.leftChild));
        System.out.println(binaryTree01.size());
    }


    private static class TreeNode{
        private int key = 0;
        private String data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode() {
        }

        public TreeNode(int key, String data) {
            this.key = key;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
}
