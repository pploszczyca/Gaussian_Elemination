package pl.tw.lab6

object Main {
  def main(args: Array[String]): Unit = {
    val matrix = MatrixService.makeMatrixFromFile(args(0))
    GaussianElemination.solve(matrix)
    MatrixService.saveMatrixToFile(matrix, args(1))
  }
}
