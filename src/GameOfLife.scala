import Array._

class GameOfLife(num: Int) {
  var matrix: Array[Array[Boolean]] = ofDim[Boolean](num,num)
  var nextMatrix: Array[Array[Boolean]] = ofDim[Boolean](num,num)

  def initGOL(){
    for (j <- 0 until num;
         i <- 0 until num) {
      matrix(i)(j) = false
    }
    matrix(1)(3) = true
    matrix(2)(3) = true
    matrix(3)(3) = true
    matrix(3)(2) = true
    matrix(2)(1) = true
  }

  def checkState(i: Int, j: Int) {
    var count = 0
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
  }

  def nextGen() {
    for (j <- 0 until num;
         i <- 0 until num) {
      checkState(i,j)
    }
    for (j <- 0 until num;
         i <- 0 until num) {
      matrix(i)(j) = nextMatrix(i)(j)
    }
  }
}
