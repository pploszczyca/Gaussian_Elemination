package pl.tw.lab6

object Main {
  def main(args: Array[String]): Unit = {
    val matrix = Matrix.makeMatrixFromFile("resources/input_data.txt")
    GaussianElemination.solve(matrix)
    Matrix.print(matrix)
  }
}
