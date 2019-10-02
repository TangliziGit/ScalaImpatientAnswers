package org.tanglizi.scala

import scala.beans.BeanProperty

object Chapter5 extends App{
  val person: Person = new Person
  val outer: Outer = new Outer("scala outer class")
}

/*
* java coder应注意的scala类特点
* 1. 属性必须默认实现
* 2. def方法为共有方法
* 3. var属性产生**私有**属性及**共有getter/setter**
* 4. private var属性产生**私有**属性及**私有getter/setter**, 可以覆盖的写def方法
* 5. 主构造器定义属性, 同时有副构造器(使用时调用已有构造器this())
*
* 总结:
* 1. 任何可见属性都是私有, 任何可见方法都是共有
* 2. 属性加上private, 那么用户可以定义对应getter/setter; 不加则自动生成
* 3. 主构造器定义属性
* 4. @BeanProperty
*/
class Person(val personId: Int = 0){
  var name: String = ""
  private var privateAge: Int = 0
  @BeanProperty var isMale: Boolean = false
  println("a new person created, his id is "+personId) // this code is in the main constructor

  def age: Int = privateAge
  def age_=(age: Int): Unit = {
    privateAge=age
  }
}

/*
* In scala:
*   val outer = new Outer
*   val inner = new outer.Inner
*
* In java:
*   Outer outer = new outer()
*   Inner inner = outer.new Inner()
*/
class Outer(val name: String){ outer =>
  class Inner{
    println("Outer's name is "+outer.name)
  }

  private var inner: Inner = new Inner
}