package pl.tw.lab6
package actions

class C(private val matrix: Array[Array[Double]],
        val i: Int,
        val j: Int,
        val k: Int,
        val subtrahend: Double) extends Thread{

  override def run(): Unit = matrix(k)(j) = matrix(k)(j) - subtrahend
}
