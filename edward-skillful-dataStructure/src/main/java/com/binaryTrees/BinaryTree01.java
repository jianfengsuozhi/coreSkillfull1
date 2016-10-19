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
        root = new TreeNode(1, "rootNode(a)");
    }

    public void createBinaryTree(){
        TreeNode b = new TreeNode(2, "b");
        TreeNode c = new TreeNode(3, "c");
        root.leftChild = b;
        root.rightChild = c;

        TreeNode d = new TreeNode(4, "d");
        TreeNode f = new TreeNode(5, "f");
        b.leftChild = d;
        b.rightChild = f;

        TreeNode e = new TreeNode(9, "e");
        d.rightChild = e;

        TreeNode g = new TreeNode(10, "g");
        f.leftChild = g;
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

    private TreeNode parent(TreeNode subElement,TreeNode element){
        if(null == subElement){//截止
            return null;
        }
        if(element == subElement.leftChild || element == subElement.rightChild){//判断是否相等
           return subElement;
        }

        TreeNode p;
        if(null != (p = parent(subElement.leftChild,element))){//若左子树没有找到,则查找右子树
            return p;
        }else {
            return parent(subElement.rightChild, element);
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

    private int size(TreeNode element){
        if(null == element){
            return 0;
        }
        return 1 + size(element.leftChild) + size(element.rightChild);
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

    /**
     * 左孩子结点
     * @param element
     * @return
     */
    public TreeNode getLeftChildNode(TreeNode element){
        return null != element ? element.leftChild : null;
    }

    /**
     * 右孩子结点
     * @param element
     * @return
     */
    public TreeNode getRightChildNode(TreeNode element){
        return null != element ? element.rightChild : null;
    }

    /**
     * 删除结点 TODO
     * @param element
     */
    public void destroy(TreeNode element){
        if(null != element){
            //按后序遍历销毁
            this.destroy(element.leftChild);
            this.destroy(element.rightChild);
            element = null;
        }

    }

    /**
     * 前序遍历:递归实现
     */
    public void preOrder(TreeNode element){
        if(null != element){//当前元素不为null时,递归结束
            this.visited(element);
            this.preOrder(element.leftChild);
            this.preOrder(element.rightChild);
        }
    }

    /**
     * 中序遍历:递归实现
     */
    public void middleOrder(TreeNode element){
        if(null != element){
            this.middleOrder(element.leftChild);
            this.visited(element);
            this.middleOrder(element.rightChild);
        }
    }

    /**
     * 后序遍历:递归实现
     */
    public void postOrder(TreeNode element){
        if(null != element){
            this.postOrder(element.leftChild);
            this.postOrder(element.rightChild);
            this.visited(element);
        }
    }

    /**
     * 输出当前结点信息
     * @param element
     */
    public void visited(TreeNode element){
        System.out.println("key:" + element.key + ",data:" + element.data);
    }

    public static void main(String[] args) {
        BinaryTree01 binaryTree01 = new BinaryTree01();
        binaryTree01.createBinaryTree();
/*        System.out.println(binaryTree01.getParent(binaryTree01.getRoot()));
        System.out.println(binaryTree01.getParent(binaryTree01.getRoot().leftChild.rightChild).key);
        System.out.println(binaryTree01.getParent(binaryTree01.getRoot().rightChild.rightChild).key);*/

//        System.out.println(binaryTree01.height(binaryTree01.getRoot().leftChild.leftChild));
//        System.out.println(binaryTree01.size());

/*        System.out.println("-------------前缀遍历------------");
        binaryTree01.preOrder(binaryTree01.getRoot());
        System.out.println("-------------中缀遍历------------");
        binaryTree01.middleOrder(binaryTree01.getRoot());
        System.out.println("-------------后缀遍历------------");
        binaryTree01.postOrder(binaryTree01.getRoot());*/

        binaryTree01.destroy(binaryTree01.root.leftChild.leftChild);
        binaryTree01.preOrder(binaryTree01.getRoot());
    }


    private static class TreeNode{
        private int key = 0;//序号
        private String data;//数据
        private TreeNode leftChild;//左孩子结点
        private TreeNode rightChild;//右孩子结点

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
