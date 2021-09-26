package pingali.jeevan.learning.akka.events

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import akka.event.slf4j.Logger
import all_events.AllEvents.Person

object PersonActor {
  val logger = Logger("Person Actor")

  def apply(): Behavior[Person] =
    Behaviors.setup { context =>
      logger.info(s"Context: $context")

      Behaviors.receiveMessage { message =>
        logger.info(s"Received message: ${message.getName}")
        Behaviors.same
      }
    }
}
