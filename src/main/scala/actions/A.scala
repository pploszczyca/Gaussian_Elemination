package pl.tw.lab6
package actions

class A(private val matrix: Array[Array[Double]],
        val i: Int,
        val k: Int,
        var multiplier: Double = 0.0) extends Thread{


  override def run(): Unit = multiplier = matrix(k)(i)/matrix(i)(i)
}
