import com.raquo.laminar.api.L._
import org.scalajs.dom

import scala.util.Random

import animus._

object Frontend {

  val myApp = {

    val $tick = EventStream.periodic(1000)

    val $left: Signal[Double] = EventStream
      .periodic(1000)
      .toSignal(0)
      .mapTo(Random.nextDouble() * 1000)
    
    val $top: Signal[Double] = EventStream
      .periodic(500)
      .toSignal(0)
      .mapTo(Random.nextDouble() * 1000)

    val animatedBox =
      div(
        width("100px"),
        height("100px"),
        backgroundColor := "red",
        position.relative,
        left <-- $left.spring.px,
        top <-- $top.spring.px
      )

    div(
      div(
        "Tick #: ",
        child.text <-- $tick.map(_.toString)
      ),
      div(
        "Random #: ",
        child.text <-- $tick.mapTo((scala.util.Random.nextInt() % 100).toString)
      ),
      animatedBox
    )
  }

  def main(args: Array[String]): Unit = {
    documentEvents.onDomContentLoaded.foreach { _ =>
      render(dom.document.getElementById("appContainer"), myApp)
    }(unsafeWindowOwner)
  }
}
