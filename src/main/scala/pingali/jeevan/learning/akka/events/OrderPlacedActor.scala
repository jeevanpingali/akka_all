package pingali.jeevan.learning.akka.events

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import akka.event.slf4j.Logger
import all_events.AllEvents.OrderPlaced

object OrderPlacedActor {
  val logger= Logger("Order Placed Actor")

  def apply(): Behavior[OrderPlaced] =
    Behaviors.setup { context =>
      logger.info(s"Context: $context")

      Behaviors.receiveMessage { message =>
        logger.info(s"Received message: ${message.getName}")
        Behaviors.same
      }
    }

}
