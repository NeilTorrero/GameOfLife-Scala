import GameOfLife.{initGOL, nextGen}
import Main.{NMatrix, printMatrix}
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.event.ActionEvent
import scalafx.scene.control.{Button, Separator, ToolBar}
import scalafx.scene.{Group, Scene}
import scalafx.scene.layout.BorderPane
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle

import scala.Array.ofDim

object Screen extends JFXApp{
  val pixelCanvas = new Pixel
  var matrix: Array[Array[Boolean]] = ofDim[Boolean](NMatrix, NMatrix)
  matrix = initGOL(NMatrix)
  stage = new JFXApp.PrimaryStage {
    title.value = "Game Of Life"
    scene = new Scene(NMatrix*10, NMatrix*10+40) {
      fill = Grey
      root = new BorderPane {

        top = new ToolBar {
          private val nextButton = new Button("Next") {
            handleEvent(ActionEvent.Any) {
              _: ActionEvent =>
                printMatrix(matrix)
                matrix = nextGen(matrix, NMatrix)
                for (j <- 0 until NMatrix;
                     i <- 0 until NMatrix) {
                  if (matrix(i)(j)) pixelCanvas.plotPixels(i, j)
                  else pixelCanvas.removePixel(i,j)
                }
            }
          }

          content = List(
            new Separator,
            nextButton)
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
