package org.muzhe.dsa.tsinghua.sequence;

/**
 * @author muzhe-wang on  18-10-8 下午12:26.
 */
public interface Stack<T> {

    /**
     * 将value添加到当前stack中去
     * @param value
     */
    void push(T value);

    /**
     * 弹出栈顶部元素，并返回对应的值
     * @return
     */
    T pop();

    /**
     * 获取栈顶部元素
     * @return
     */
    T top();


}
