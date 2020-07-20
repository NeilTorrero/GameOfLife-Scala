import scala.Array.ofDim
import GameOfLife._

object Main {
  def NMatrix = 100
  def printMatrix(matrix: Array[Array[Boolean]]) {
    for (j <- 0 until NMatrix;
         i <- 0 until NMatrix) {
      if (matrix(i)(j)) {
        print("[x]")
      } else {
        print("[ ]")
      }
      if (i == NMatrix-1) {
        print("\n")
      }
    }
  }


  def main(args: Array[String]) {
    var matrix: Array[Array[Boolean]] = ofDim[Boolean](NMatrix, NMatrix)
    matrix = initGOL(NMatrix)
    while(true) {
      if (scala.io.StdIn.readLine() == "y") {
        print("\n\tNext Generation\n")
        printMatrix(matrix)
        matrix = nextGen(matrix, NMatrix)
      }
    }
  }
}
