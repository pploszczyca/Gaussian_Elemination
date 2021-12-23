package pl.tw.lab6

import actions.{A, B, C}

object GaussianElemination {
  private def forwardElemination(matrix: Array[Array[Double]]): Unit = {
    for(i <- matrix.indices) {
      val AMap = (for(k <- i+1 until matrix.length) yield new A(matrix, i, k)).map(a => a.k -> a).toMap
      ThreadRunner.run(AMap.values.toList)

      val BMap = (for(j <- i to matrix.length ;k <- i+1 until matrix.length)
        yield new B(matrix, i, j,k, AMap.get(k) match {case Some(a) => a.multiplier}))
        .map(b => (b.i, b.j, b.k) -> b).toMap

      ThreadRunner.run(BMap.values.toList)

      val CList = (for(j <- i to matrix.length ;k <- i+1 until matrix.length)
        yield new C(matrix, i, j,k, BMap.get((i,j,k)) match {case Some(b) => b.subtrahend}))
        .toList

      ThreadRunner.run(CList)
    }
  }

  private def backElemination(matrix: Array[Array[Double]]): Unit = {
    val sizeOfMatrix = matrix.length
    for(i <- matrix.indices.reverse) {
      for(j <-(i+1 until matrix.length).reverse) {
        matrix(i)(sizeOfMatrix) -= matrix(i)(j) * matrix(j)(sizeOfMatrix)
        matrix(i)(j) -= matrix(i)(j)
      }
      matrix(i)(sizeOfMatrix) /= matrix(i)(i)
      matrix(i)(i) /= matrix(i)(i)
    }
  }

  def solve(matrix: Array[Array[Double]]): Unit = {
    forwardElemination(matrix)
    backElemination(matrix)
  }
}
