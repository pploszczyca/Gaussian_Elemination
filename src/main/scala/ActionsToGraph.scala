package pl.tw.lab6

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.collection.mutable.ListBuffer
import scala.language.postfixOps
import sys.process._

object ActionsToGraph {
  private def makeAString(i: Int, k: Int) = s"A_${i}_$k"

  private def makeBString(i: Int, j: Int, k: Int) = s"B_${i}_${j}_$k"

  private def makeCString(i: Int, j: Int, k: Int) = s"C_${i}_${j}_$k"

  private def makeEdges(sizeOfMatrix: Int): List[(String, String)] = {
    val resultList = ListBuffer[(String, String)]()

    for(i <- 0 until sizeOfMatrix; j <- i to sizeOfMatrix ;k <- i+1 until sizeOfMatrix) {
      resultList += ((makeAString(i, k), makeBString(i, j, k)))
      resultList += ((makeBString(i, j, k), makeCString(i, j, k)))
    }

    for(i <- 0 until sizeOfMatrix-2; j <- i+2 to sizeOfMatrix ;k <- i+2 until sizeOfMatrix) {
      resultList += ((makeCString(i, j, k), makeCString(i+1, j, k)))
    }

    for(i <- 0 until sizeOfMatrix; j <- i+1 until sizeOfMatrix ;k <- i+1 until sizeOfMatrix; if i+1 != j) {
      resultList += ((makeCString(i, j, k), makeBString(i+1, j, k+1)))
    }

    for(i <- 0 until sizeOfMatrix; k <- i+2 until sizeOfMatrix) {
      resultList += ((makeCString(i, i+1, i+1), makeAString(i+1, k)))
      resultList += ((makeCString(i, i+1, k), makeAString(i+1, k)))
    }

    resultList.toList
  }

  private def parseEdgesToDotFormat(edges: List[(String, String)]): String = "digraph {\n" +
    edges.map{case (fromVertex, toVertex) => s"   $fromVertex -> $toVertex"}.fold("") {(acc, edge) => acc + edge + "\n"} +
    "}\n"

  private def writeGraphToDotFileAndMakeSvgGraph(formattedGraph: String, outputFileName: String): Unit = {
    val graphNameFile = s"$outputFileName-graph.txt"
    Files.write(Paths.get(graphNameFile), formattedGraph.getBytes(StandardCharsets.UTF_8))
    s"cat $graphNameFile" #| s"dot -Tsvg -o $outputFileName-graph.svg" !
  }

  def writeGraphForMatrixToDotFormatAndMakeSvgGraph(sizeOfMatrix: Int, outputFileName: String): Unit = writeGraphToDotFileAndMakeSvgGraph(parseEdgesToDotFormat(makeEdges(sizeOfMatrix)), outputFileName)
}
