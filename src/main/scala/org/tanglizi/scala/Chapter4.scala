package org.tanglizi.scala

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader

import scala.collection.{immutable, mutable}
import scala.jdk.CollectionConverters._

object Chapter4 extends App {
  // 1
  val oriEquip=Map("x" -> 12, "y" -> 13)
  val newEquip=for ((k, v) <- oriEquip) yield (k, v*0.9)
  println(newEquip)

  // 2
  {
    val map=mutable.Map[String, Int]() withDefaultValue 0
    val in=new java.util.Scanner(this.getClass.getResourceAsStream("/myfile.txt"))
    while (in.hasNext) map(in.next)+=1
    println(map)
  }

  // 3
  {
    var map=immutable.Map[String, Int]() withDefaultValue 0
    val in=new java.util.Scanner(this.getClass.getResourceAsStream("/myfile.txt"))
    while (in.hasNext()){
      val k:String =in.next
      val v=map(k)
      map = map - k + (k -> (v+1))
    }
    println(map)
  }

  // 4
  {
    var map=immutable.SortedMap[String, Int]() withDefaultValue 0
    val in=new java.util.Scanner(this.getClass.getResourceAsStream("/myfile.txt"))
    while (in.hasNext()){
      val k:String =in.next
      val v=map(k)
      map = map - k + (k -> (v+1))
    }
    println(map)
  }

  // 5
  {
    val map = new java.util.TreeMap[String, Int]
    val in=new java.util.Scanner(this.getClass.getResourceAsStream("/myfile.txt"))
    while (in.hasNext()){
      val key=in.next
      map.put(key, map.getOrDefault(key, 0)+1)
    }
    println(map)
  }

  // 6
  {
    import java.util.Calendar._
    val hashMap=mutable.LinkedHashMap(
      "Monday" -> MONDAY,
      "Tuesday" -> TUESDAY,
      "Wednesday" -> WEDNESDAY,
      "Thursday" -> THURSDAY,
      "Friday" -> FRIDAY,
      "Saturday" -> SATURDAY,
      "Sunday" -> SUNDAY
    )
    println(hashMap)
  }

  // 7
  {
    val props=System.getProperties.asScala
    val maxKey=props.keySet.toArray.maxBy(_.length)
    for ((k, v) <- props)
      println(k + " "*(maxKey.length - k.length) + " | " + v)
  }

  // 8
  def minmax(xs: Array[Int]): (Int, Int) = (xs.min, xs.max)
  println(minmax(Array(1, 2, 3, 4)))

  // 9
  def lteqgt(xs: Array[Int], v: Int): (Int, Int, Int) = (xs.count(_ < v), xs.count(_ == v), xs.count(_ > v))
  println(lteqgt(Array(1, 2, 2 ,3, 3, 4), 3))

  println("Hello" zip "World")
}
