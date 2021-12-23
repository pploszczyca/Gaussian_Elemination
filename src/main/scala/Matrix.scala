package pl.tw.lab6

object Matrix {
  private def readFileLines(filePath: String): List[String] = scala.io.Source.fromFile(filePath).getLines.toList

  private def makeMatrixFromFileLines(fileLines: List[String]): Array[Array[Double]] = {
    val matrixSize = fileLines.head.toInt
    val rhs = fileLines.last.split(" ").map(_.toDouble)

    fileLines.slice(1, matrixSize+1)
      .zipWithIndex
      .map{case (line, index) => line.split(" ").map(_.toDouble) :+ rhs(index)}
      .toArray
  }

  def makeMatrixFromFile(filePath: String) = makeMatrixFromFileLines(readFileLines(filePath))

  def print(matrix: Array[Array[Double]]): Unit = {
    matrix.foreach(row => println(row.mkString("Array(", ", ", ")")))
    println("")
  }
}
