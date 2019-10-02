package org.tanglizi.scala

import scala.util.Random
import scala.collection.mutable._
import java.util.TimeZone

import scala.collection.mutable

object Chapter3{
  def main(args: Array[String]): Unit = {}

  // 1
  def randArray(n: Int): Array[Int] = {
    (new Array[Int](n)).map(_ => Random.nextInt(n))
  }
  println(randArray(10).toList)

  // 2
  def arraySwap(xs: Array[Int]): Array[Int] = {
    if (xs.length<=1) xs
    else Array(xs(1), xs(0)) ++ arraySwap(xs.drop(2))
  }
  val array: Array[Int] =Array[Int](1, -2, -3, 4, 5)
  println(arraySwap(array).toList)

  // 3
  def arraySwap2(xs: Array[Int]): scala.IndexedSeq[Int] = {
    for (i <- xs.indices) yield
      if (i%2==1) xs(i-1)
      else if (i+1 < xs.length) xs(i+1)
      else xs(i)
  }
  println(arraySwap2(array).toList)

  // 4
  def rearrange(xs: Array[Int]): Array[Int] = {
    (for (x <- xs; if x>0) yield x) ++ (for (x <- xs; if x<=0) yield x)
  }
  println(rearrange(array).toList)

  // 5
  println(array.sum/array.length)

  // 6
  println(array.reverse.toList)
  println(array.toBuffer.reverse.toList)

  // 7
  println(Array(1, 2, 2, 1, 2).distinct.toList)

  // 8
  def rearrange2(xs: mutable.Buffer[Int]): Array[Int] = {
    val index = (for (i <- 0 until xs.length; if xs(i)<0) yield i).reverse.dropRight(1)
    for (i <- index) xs.remove(i)
    xs.toArray
  }
  println(rearrange2(array.toBuffer).toList)

  // 9
  println(TimeZone.getAvailableIDs()
    .filter(_.startsWith("America/"))
    .map(_.stripPrefix("America/"))
    .sorted
    .toList)

  // 10
  import java.awt.datatransfer._
  val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
  println(flavors.getNativesForFlavor(DataFlavor.imageFlavor).toArray.toBuffer)
}
