package com.wujunwen.springbootplay.ref;

import java.lang.ref.SoftReference;

public class SoftRefrenceTest {
    /**
     * 软引用只会在内存满了以后才回收,所以手动GC并没有效果
     * 如果换成WeakReference会有不一样的效果
     * @param args
     */
    public static void main(String[] args) {
        SoftReference<Integer> weakRef = new SoftReference<>(128);
        System.out.println("GC前："+weakRef.get());
        System.gc();
        System.out.println("GC后："+weakRef.get());
    }
}
