package pl.tw.lab6

object Main {
  def main(args: Array[String]): Unit = {
    val matrix = Matrix.makeMatrixFromFile(args(0))
    GaussianElemination.solve(matrix)
    Matrix.saveMatrixToFile(matrix, args(1))
    ActionsToGraph.writeGraphForMatrixToDotFormatAndMakeSvgGraph(matrix.length, args(2))
  }
}
