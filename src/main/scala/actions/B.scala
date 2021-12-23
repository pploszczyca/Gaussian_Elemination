package pl.tw.lab6
package actions

class B(private val matrix: Array[Array[Double]],
        val i: Int,
        val j: Int,
        val k: Int,
        val multiplier: Double,
        var subtrahend: Double = 0.0) extends Thread{

  override def run(): Unit = subtrahend = matrix(i)(j) * multiplier
}
