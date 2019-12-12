package com.hujun.mvp.base

import android.app.Activity

/**
 * Created by junhu on 2019-12-12
 * Model层
 * 需要调用P层的方法，所以需要持有P
 */
abstract class BaseModel<P : BasePresenter<*, *, *>, CONTRACT>(var p: P) {
    abstract fun getContract(): CONTRACT


}

open class A

class B : A()


class C {
    fun test() {
        val arrayB: Array<B> = arrayOf(B())
        arrayB[1] = B()
        val arrayA: Array<out A> = arrayB
        var a: A = arrayA[1]

        val listB: List<B> = listOf(B())
        var b: B = listB[1]
        val listA: List<A> = listB

        val listBB: List<B> = listA

    }

    fun copy(from: List<A>, to: ArrayList<in A>) {
        for (i in from.indices){
            to[i] = from[i]
        }
    }

    fun test(a: Comparable<A>) {
        val b: Comparable<B> = a
    }

    fun test1(b: Comparable<B>) {
        val a: Comparable<A> = b
    }
}
