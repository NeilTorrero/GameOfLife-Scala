import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.{Group, Scene}
import scalafx.scene.layout.BorderPane
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle

object Screen extends JFXApp{
    val pixelCanvas = new Pixel
    stage = new JFXApp.PrimaryStage {
      title.value = "Game Of Life"
      scene = new Scene(600, 450) {
        root = new BorderPane {
          fill = Gray
          content = new Rectangle {
            x = 25
            y = 40
            width = 100
            height = 100
            fill <== when(pressed) choose Green otherwise Red
          }

          center = new Group {
            pixelCanvas.width <== width
            pixelCanvas.height <== height
            children = pixelCanvas
          }
        }
      }
    }
}
