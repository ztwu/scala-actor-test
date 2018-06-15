package com.iflytek.edcc

/**
  * Created with Intellij IDEA.
  * User: ztwu2
  * Date: 2018/6/15
  * Time: 14:04
  * Description actor模型的高并发开发
  *
  * Scala的Actor类似于Java中的多线程编程。但是不同的是，Scala的Actor提供的模型与多线程有所不同。
  * Scala的Actor尽可能地避免锁和共享状态，从而避免多线程并发时出现资源争用的情况，进而提升多线程编程的性能。
  * 此外，Scala Actor的这种模型还可以避免死锁等一系列传统多线程编程的问题。
  * Spark中使用的分布式多线程框架，是Akka。Akka也实现了类似Scala Actor的模型，其核心概念同样也是Actor
  *
  * 对象，scala没有java里的静态方法和静态字段，通过object实现
  *
  */

object ActorDemo {

  def main(args:Array[String]):Unit = {

    val actor1 = ActorFirst()
    val actor2 = ActorSecond()

    actor1()
    actor2()

    actor1.firstTrait("测试1")
    actor1.secondTrait("测试1")
    actor2.firstTrait("测试2")
    actor2.secondTrait("测试2")

    actor1.start()
    //发送异步消息
//    actor1.!("你好1")
//    actor1.!("你好2")
//    actor1.!("你好3")
//    actor1.!("你好4")
//    actor1.!("你好5")

    //发送同步消息
    actor1 !? ("你好2")
    actor1 !? ("你好3")
    actor1 !? ("你好4")
    actor1 !? ("你好5")
    actor1 !? ("你好1")

    //发送异步消息，异步发送一个消息，但是在后续要获得消息的返回值
//    val future1  = actor1 !! ("你好1")
//    val reply = future1()
//    println(reply)
//
//    val future2  = actor1 !! ("你好2")
//    val reply2 = future2()
//    println(reply2)

  }

}
