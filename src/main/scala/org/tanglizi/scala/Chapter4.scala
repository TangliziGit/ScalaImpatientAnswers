package org.tanglizi.scala

import scala.collection.{immutable, mutable}

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
    var map=new java.util.TreeMap[String, Int]
    val in=new java.util.Scanner(this.getClass.getResourceAsStream("/myfile.txt"))
    while (in.hasNext()){
      val key=in.next
      map.put(key, map.getOrDefault(key, 0)+1)
    }
    println(map)
  }
}
