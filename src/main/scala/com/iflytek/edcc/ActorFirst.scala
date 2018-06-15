package com.iflytek.edcc

import scala.actors.Actor

/**
  * Created with Intellij IDEA.
  * User: ztwu2
  * Date: 2018/6/15
  * Time: 14:06
  * Description
  */

//主构造函数
class ActorFirst extends Actor with AbstractActorFirst with AbstractActorSecond{

  override def firstTrait(name: String): String = {
    val result = "我是第一个特征"
    println(result,name)
    return result+" : "+name
  }

  override def secondTrait(name: String): String = {
    val result = "我是第二个特征"
    println(result,name)
    return result+" : "+name
  }

  //重写Actor trait的act方法，即可实现自己的线程执行体，与Java中重写run方法类似
  override def act(): Unit = {
    while (true) {
      receive({
        case msg:String => {
          println("first actor 接收到信息 ："+msg)
          //回复信息
          sender ! "first actor 返回信息 ："+msg
        }
        case _=>{println("first actor no anything")}
      })
    }
  }

  def apply(): Unit = {
    println("ActorFirst类的apply方法")
  }

  //辅助构造函数
  def this(name:String) {
    //调用主构造函数
    this()
  }

}

/**
*  object没有构造函数，作为同名类的伴生对象
  */
object ActorFirst {

  def apply(): ActorFirst = {
    println("ActorFirst伴生对象里调用伴生类的构造函数")
    new ActorFirst()
  }

}
