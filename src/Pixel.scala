import Main.NMatrix
import scalafx.Includes._
import scalafx.scene.canvas._
import scalafx.scene.input.MouseEvent
import scalafx.scene.input.MouseEvent._
import scalafx.scene.paint.Color._

import scala.Array.ofDim

class Pixel extends Canvas{
  var matrix: Array[Array[Boolean]] = ofDim[Boolean](NMatrix, NMatrix)
  val gc: GraphicsContext = graphicsContext2D
  gc.fill = Blue

  def getStartingMatrix: Array[Array[Boolean]] = matrix

  def clear(): Unit = {
    gc.clearRect(0,0, width.value, height.value)
  }

  def plotPixels(x: Long, y:Long): Unit = {
    gc.fillRect(x * 10, y * 10, 10, 10)
    matrix(x.toInt)(y.toInt) = true
  }

  def removePixel(x: Long, y: Long): Unit = {
    gc.clearRect(x * 10, y * 10, 10, 10)
    matrix(x.toInt)(y.toInt) = false
  }

  filterEvent(MouseEvent.Any) {
    me: MouseEvent =>
      me.eventType match {
        case MouseClicked | MouseDragged =>
          val x = ((me.x - (me.x % 10)) / 10).toLong
          val y = ((me.y - (me.y % 10)) / 10).toLong
          if (matrix(x.toInt)(y.toInt)) removePixel(x,y)
          else plotPixels(x,y)
        case _ =>
      }
      me.consume()
  }
}
