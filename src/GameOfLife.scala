import Array._

object GameOfLife {
  def initGOL(num: Int): Array[Array[Boolean]] = {
    val matrix: Array[Array[Boolean]] = ofDim[Boolean](num, num)
    for (j <- 0 until num;
         i <- 0 until num) {
      matrix(i)(j) = false
    }

    //Glider
    matrix(1)(3) = true
    matrix(2)(3) = true
    matrix(3)(3) = true
    matrix(3)(2) = true
    matrix(2)(1) = true

    //Tumbler
    matrix(90)(5) = true
    matrix(91)(5) = true
    matrix(90)(6) = true
    matrix(91)(6) = true
    matrix(93)(5) = true
    matrix(94)(5) = true
    matrix(93)(6) = true
    matrix(94)(6) = true
    matrix(91)(7) = true
    matrix(91)(8) = true
    matrix(91)(9) = true
    matrix(90)(10) = true
    matrix(89)(10) = true
    matrix(89)(9) = true
    matrix(89)(8) = true
    matrix(93)(7) = true
    matrix(93)(8) = true
    matrix(93)(9) = true
    matrix(94)(10) = true
    matrix(95)(10) = true
    matrix(95)(9) = true
    matrix(95)(8) = true

    //Exploder
    matrix(10)(30) = true
    matrix(10)(31) = true
    matrix(10)(32) = true
    matrix(10)(33) = true
    matrix(10)(34) = true
    matrix(12)(30) = true
    matrix(12)(34) = true
    matrix(14)(30) = true
    matrix(14)(31) = true
    matrix(14)(32) = true
    matrix(14)(33) = true
    matrix(14)(34) = true

    //10 Cell Row
    matrix(40)(10) = true
    matrix(41)(10) = true
    matrix(42)(10) = true
    matrix(43)(10) = true
    matrix(44)(10) = true
    matrix(45)(10) = true
    matrix(46)(10) = true
    matrix(47)(10) = true
    matrix(48)(10) = true
    matrix(49)(10) = true

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
