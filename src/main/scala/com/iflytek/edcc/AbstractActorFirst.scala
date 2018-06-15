package com.iflytek.edcc

/**
  * Created with Intellij IDEA.
  * User: ztwu2
  * Date: 2018/6/15
  * Time: 14:17
  * Description 类似java的接口，作为接口来使用
  * 类使用extends继承Trait，与Java不同，这里不是implement，在Scala中，无论继承类还是继承Trait都是用extends关键字。
  *
  * 在Scala中，类继承Trait后，必须实现其中的抽象方法，实现时不需要使用override关键字，
  * 同时Scala同Java一样，不支持类多继承，但支持多重继承Trait，使用with关键字即可。
  *
  */

trait AbstractActorFirst {

  def firstTrait(name:String):String;

}
