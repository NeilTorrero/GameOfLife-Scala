object Main {
  def NMatrix = 10
  def printMatrix(gol: GameOfLife) {
    for (j <- 0 until NMatrix;
         i <- 0 until NMatrix) {
      if (gol.matrix(i)(j)) {
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
    val gol = new GameOfLife(NMatrix)
    gol.initGOL()
        printMatrix(gol)
}
