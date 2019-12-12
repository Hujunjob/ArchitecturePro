package com.hujun.mvp.base;

import java.util.ArrayList;

/**
 * Created by junhu on 2019-12-12
 */
public class Test {

    class A{}

    class B extends A{}

    public void test(){
        ArrayList<? extends B> list = new ArrayList<>();
        list.add(new A());
        A a = list.get(0);

        ArrayList<? super A> list1 = new ArrayList<>();
        list1.add(new B());
        A aa = list1.get(0);
    }
}
