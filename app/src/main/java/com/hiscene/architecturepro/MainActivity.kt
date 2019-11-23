package com.hiscene.architecturepro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

class MainActivity : AppCompatActivity(), DBOperation {
    lateinit var db: DBOperation
    override fun insert(name:String) {
        println("insert")
    }

    override fun delete(name:String) {
        println("delete")
    }

    override fun update(name:String) {
        println("update")
    }

    override fun save() {
        println("save")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_go.setOnClickListener {
            //            var intent = Intent(this,Main2Activity::class.java)
//            startActivity(intent)
            db.delete("hujun")
        }

        db = Proxy.newProxyInstance(
            DBOperation::class.java.classLoader, arrayOf(
                DBOperation::class.java
            ), DBHandler(this)
        ) as DBOperation
    }

    internal class DBHandler(var db: DBOperation) : InvocationHandler {
        override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
            println("proxy invoke")
            db.save()
            if (args != null)
                return method?.invoke(db, *args)
            else
                return method?.invoke(db)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}
