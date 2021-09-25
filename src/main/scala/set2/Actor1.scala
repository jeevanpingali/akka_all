package pingali.jeevan.learning.akka
package set2

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import akka.event.slf4j.Logger

object Actor1 {
  val logger= Logger("HelloWorldMain")

  def apply(): Behavior[EventOne] =
    Behaviors.setup { context =>
      logger.info(s"Context: $context")

      Behaviors.receiveMessage { message =>
        logger.info(s"Received message: ${message.name}")
        Behaviors.same
      }
    }

  final case class EventOne(name: String)

}
