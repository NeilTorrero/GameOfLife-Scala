object Main {
  def NMatrix = 10

  def main(args: Array[String]) {
    val gol = new GameOfLife(NMatrix)
    gol.initGOL()
}
