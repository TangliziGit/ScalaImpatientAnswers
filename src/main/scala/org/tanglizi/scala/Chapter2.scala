package org.tanglizi.scala

object Chapter2 extends App{
  // 9
  def product(str: String):BigInt = {
    str match {
      case "" => 1
      case _  => str.head*product(str.tail)
    }
  }
  println("Hello")

  // 10
  def pow(x: BigInt, n: Int): BigInt = {
    n match {
      case 0 => 1
      case n if n<0 => -1*pow(x, -n)
      case n if n%2==0 => pow(x, n/2)*pow(x, n/2)
      case n if n%2==1 => pow(x, n-1)*x
    }
  }
  print(pow(12, 2))
}
