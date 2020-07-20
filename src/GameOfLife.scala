import Array._

object GameOfLife {
  def initGOL(num: Int): Array[Array[Boolean]] = {
    val matrix: Array[Array[Boolean]] = ofDim[Boolean](num, num)
    for (j <- 0 until num;
         i <- 0 until num) {
      matrix(i)(j) = false
    }
    matrix(1)(3) = true
    matrix(2)(3) = true
    matrix(3)(3) = true
    matrix(3)(2) = true
    matrix(2)(1) = true
    matrix
  }

  def checkState(i: Int, j: Int, matrix: Array[Array[Boolean]], num: Int, nMatrix: Array[Array[Boolean]]): Array[Array[Boolean]] = {
    var count = 0
    val nextMatrix: Array[Array[Boolean]] = nMatrix
    //print("\nPixel:" + i + "," + j)
    for (y <- j - 1 to j + 1; x <- i - 1 to i + 1) {
      if (x >= 0 && y >= 0 && x < num && y < num) {
        if (!(x == i && y == j)) {
          if (matrix(x)(y)) {
            count += 1
            //print("(found in " + x + ","+ y + ")")
          }
        }
      }
    }
    //print(" - count=" + count)
    if (matrix(i)(j)) {
      nextMatrix(i)(j) = true
      if (count < 2 || count > 3) {
        nextMatrix(i)(j) = false
      }
    } else {
      nextMatrix(i)(j) = false
      if (count == 3) {
        nextMatrix(i)(j) = true
      }
    }
    nextMatrix
  }

  def nextGen(matrix: Array[Array[Boolean]], num: Int): Array[Array[Boolean]] = {
    var nextMatrix: Array[Array[Boolean]] = ofDim[Boolean](num, num)
    for (j <- 0 until num;
         i <- 0 until num) {
      nextMatrix = checkState(i, j, matrix, num, nextMatrix)
    }
    nextMatrix
  }
}
