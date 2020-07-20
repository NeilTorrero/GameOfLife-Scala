import Array._

class GameOfLife(num: Int) {
  var matrix: Array[Array[Boolean]] = ofDim[Boolean](num,num)
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
}
