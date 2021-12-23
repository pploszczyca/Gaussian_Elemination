package pl.tw.lab6

import java.io.{File, PrintWriter}

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

  def makeMatrixFromFile(filePath: String): Array[Array[Double]] = makeMatrixFromFileLines(readFileLines(filePath))

  private def convertMatrixToString(matrix: Array[Array[Double]]): String = matrix.length.toString +
    "\n" +
    matrix
      .map(row => row.take(row.length-1).fold("") { (acc, number) => acc + number.toString + " "})
      .fold("") {(acc, row) => acc + row.toString + "\n"} +
    matrix.map(row => row.last).fold("") { (acc, number) => acc + number.toString + " "}

  def saveMatrixToFile(matrix: Array[Array[Double]], outputPath: String): Unit = {
    val printWriter = new PrintWriter(new File(outputPath))

    printWriter.write(convertMatrixToString(matrix))
    printWriter.close()
  }

  def print(matrix: Array[Array[Double]]): Unit = {
    matrix.foreach(row => println(row.mkString("Array(", ", ", ")")))
    println("")
  }
}
