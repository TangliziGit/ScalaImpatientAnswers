package org.tanglizi.scala

import scala.beans.BeanProperty

object Chapter5 extends App{
  // 1
  class Counter(private var value: Int = Int.MaxValue-1){
    def increment(): Unit = {
      if (value < Int.MaxValue) value+=1
    }
    def current: Int = value
    override def toString: String = value.toString
  }
  val counter: Counter = new Counter
  println(counter)
  counter.increment()
  println(counter)
  counter.increment()
  println(counter)

  // 2
  class BankAccount(private var _balance: Int = 0){
    def deposite(x: Int): Unit = _balance+=x
    def withdraw(x: Int): Unit = _balance-=x
    def balance: Int = _balance
  }

  // 3
  {
    class Time(private var _hours: Int, private var _minutes: Int){
      _hours=_hours.min(23).max(0)
      _minutes=_minutes.min(59).max(0)

      def hours: Int=_hours
      def minutes: Int=_minutes
      def before(other: Time): Boolean = hours<other.hours || (hours==other.hours && minutes<other.minutes)
    }
  }

  // 4
  {
    class Time2(private var _hours: Int, private var _minutes: Int){
      _hours=_hours.min(23).max(0)
      _minutes=_minutes.min(59).max(0)

      def hours: Int=_hours
      def minutes: Int=_minutes
      def sinceMidNight: Int= hours*60+minutes
      def before(other: Time2): Boolean = sinceMidNight < other.sinceMidNight
    }
  }

  // 5
  class Student(@BeanProperty var name: String = ""){}
  var student: Student = new Student("tim")
  println(student.getName)

  // 6
  {
    class Person(var age: Int){
      age=age.max(0)
    }
  }

  // 7
  // the arg con not be a field of class
  {
    class Person2(name: String) {
      val firstName: String = name.split(" ")(0)
      val lastName: String = name.split(" ")(-1)

      override def toString: String = firstName + "-" + lastName
    }

    val person2: Person2 = new Person2("Fred Smith")
    println(person2)
  }

  // 8
  class Car(
             var publisher: String,
             var typeName: String,
             var typeYear: Int = -1,
             var licensePlate: String = ""
           ){

  }

  // 9

  // 10
  {
    class Employee(val name: String = "John", var salary: Double = 0.0){
    }
  }
}
