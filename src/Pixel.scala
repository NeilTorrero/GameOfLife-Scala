import scalafx.Includes._
import scalafx.scene.canvas._
import scalafx.scene.input.MouseEvent
import scalafx.scene.input.MouseEvent._
import scalafx.scene.paint.Color._

class Pixel extends Canvas{
  val gc: GraphicsContext = graphicsContext2D
  gc.fill = White


  def clear(): Unit = {
    gc.clearRect(0,0, width.value, height.value)
  }

  def plotPixels(x: Long, y:Long): Unit = {
    gc.fillRect(x * 10, y * 10, 10, 10)
  }

  def removeCell(x: Long, y: Long): Unit = {
    gc.clearRect(x * 10, y * 10, 10, 10)
  }

  filterEvent(MouseEvent.Any) {
    me: MouseEvent =>
      me.eventType match {
        case MouseClicked | MouseDragged =>
          val x = ((me.x - (me.x % 10)) / 10).toLong
          val y = ((me.y - (me.y % 10)) / 10).toLong
          plotPixels(x, y)
        case _ =>
      }
      me.consume()
  }
}
