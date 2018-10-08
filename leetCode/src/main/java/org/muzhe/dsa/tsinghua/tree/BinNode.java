package org.muzhe.dsa.tsinghua.tree;

import lombok.Data;

import java.util.List;

/**
 * 树的节点
 *
 * @author muzhe-wang on  18-10-8 下午12:31.
 */

public abstract class BinNode<T> {

    public T data;

    /**
     * 父节点
     */
    public BinNode parent;

    /**
     * 左节点
     */
    public BinNode lChild;

    /**
     * 右节点
     */
    public BinNode rChild;

    /**
     * 高度
     */
    public int high;

    /**
     * 当前节点颜色
     */
    public int color;

    /**
     * 当前节点后代后代的总数
     *
     * @return
     */
    public abstract int size();

    /**
     * 将data作为左孩子插入到当前节点
     *
     * @param data
     * @return
     */
    public abstract BinNode<T> insertAsLeft(T data);

    /**
     * 将data作为右孩子插入到当前节点
     *
     * @param data
     * @return
     */
    public abstract BinNode<T> insertAsRight(T data);

    /**
     * 获取当前节点后继节点
     *
     * @return
     */
    public abstract BinNode<T> succ();

    /**
     * 对当前节点进行 层次遍历，其中结果写到result中去
     *
     * @param result
     */
    public abstract void travLevel(List<T> result);

    /**
     * 对当前节点的树进行先序遍历，结果写到　result中去
     *
     * @param result
     */
    public abstract void travPre(List<T> result);

    /**
     * 对当前节点的跟进行后续遍历
     *
     * @param result
     */
    public abstract void travPost(List<T> result);

    /**
     * 当前节点是否小于　node节点
     *
     * @param node
     * @return
     */
    public abstract boolean low(BinNode<T> node);

    /**
     * 当前节点和node是否相等
     *
     * @param node
     * @return
     */
    public abstract boolean equals(BinNode<T> node);

    /**
     * 顺时针旋转
     *
     * @return
     */
    public abstract BinNode<T> zig();

    /**
     * 逆时针旋转
     *
     * @return
     */
    public abstract BinNode<T> zag();

}
