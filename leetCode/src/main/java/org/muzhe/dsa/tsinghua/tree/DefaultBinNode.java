package org.muzhe.dsa.tsinghua.tree;

import java.util.List;

/**
 * @author muzhe-wang on  18-10-8 下午12:49.
 */
public class DefaultBinNode<T> extends BinNode<T> {

    @Override
    public int size() {

        //记录本身节点
        int result = 1;

        //使用递归实现
        if (this.lChild != null) {
            result += this.lChild.size();
        }
        if (this.rChild != null) {
            result += this.rChild.size();
        }
        return result;
    }

    @Override
    public BinNode<T> insertAsLeft(T data) {
        //创建左子树节点
        BinNode<T> binNode = new DefaultBinNode<T>();
        binNode.data = data;
        binNode.parent = this;
        //赋值
        this.lChild = binNode;
        return binNode;
    }

    @Override
    public BinNode<T> insertAsRight(T data) {

        //创建右子树节点
        BinNode<T> rightNode = new DefaultBinNode<T>();
        rightNode.data = data;
        rightNode.parent = this;
        //赋值
        this.rChild = rightNode;
        return rightNode;
    }

    /**
     * 当前节点的后继节点
     *
     * @return
     */
    @Override
    public BinNode<T> succ() {
        //记录当前节点
        BinNode<T> s = this;
        if (s.rChild != null) {
            //如果有右子树，返回右子树的最左边的那个节点。
            s = s.rChild;
            while (s.lChild!=null){
                s = s.lChild;
            }
        } else {
            //如果没有右子树，就是当前节点的
        //todo todo 当前节点应该如何进行实现 muzhe

        }
        return s;
    }

    @Override
    public void travLevel(List<T> result) {

    }

    @Override
    public void travPre(List<T> result) {

    }

    @Override
    public void travPost(List<T> result) {

    }

    @Override
    public boolean low(BinNode<T> node) {
        return false;
    }

    @Override
    public boolean equals(BinNode<T> node) {
        return false;
    }

    @Override
    public BinNode<T> zig() {
        return null;
    }

    @Override
    public BinNode<T> zag() {
        return null;
    }

}
