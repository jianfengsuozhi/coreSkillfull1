package com.binaryTrees;

import java.util.List;

/**
 * 哈夫曼树：如将字符串转化为唯一的编码(压缩时使用：最短)
 * Created by weideliang on 2016/10/24.
 */
public class HafuManTree {
    public static class HNode<T> {
        T data;
        double weight;
        HNode leftChild;
        HNode rightChild;

        public HNode(T data,double weight){
            this.data = data;
            this.weight = weight;
        }
    }

    public static HNode createHafumanTree(List<HNode> hNodes){

        return null;
    }

    /**
     * 实现快速排序
     * @param hNodes
     */
    private static void subSort(List<HNode> hNodes,int start,int end){

    }
}
