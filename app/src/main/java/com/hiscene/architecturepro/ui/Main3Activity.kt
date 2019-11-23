package com.hiscene.architecturepro.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hiscene.architecturepro.R
import com.hiscene.architecturepro.annotation.ClickBehavior
import com.hiscene.architecturepro.annotation.LoginCheck
import com.hiscene.architecturepro.data.LoginStatus
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {
    companion object{
        val TAG = "Main3Activity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        btn_coins.setOnClickListener{coins()}
        btn_space.setOnClickListener{space()}
        btn_login.setOnClickListener{login()}
        btn_ticket.setOnClickListener{ticket()}
        btn_logout.setOnClickListener{logout()}
    }

    @ClickBehavior("登陆")
    fun login(){
        println("登陆")
        LoginStatus.login = true
    }

    @ClickBehavior("登出")
    fun logout(){
        LoginStatus.login = false
    }

    @ClickBehavior("我的空间")
    @LoginCheck
    fun space(){
        println("我的空间")
        gotoOther()
    }

    @ClickBehavior("我的票")
    @LoginCheck
    fun ticket(){
        println("我的票")
        gotoOther()
    }

    @ClickBehavior("我的积分")
    @LoginCheck
    fun coins(){
        println("我的积分")
        gotoOther()
    }

    fun gotoOther(){
        Toast.makeText(this,"成功执行",Toast.LENGTH_SHORT).show()
//        startActivity(Intent(this,OtherActivity::class.java))
    }
}
