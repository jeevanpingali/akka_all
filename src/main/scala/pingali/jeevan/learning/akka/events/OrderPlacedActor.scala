package pingali.jeevan.learning.akka.events

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import all_events.AllEvents.OrderPlaced

object OrderPlacedActor {

  def apply(): Behavior[OrderPlaced] =
    Behaviors.setup { context =>
      context.log.info("Context: {}", context)

      Behaviors.receiveMessage { message =>
        context.log.info("Received message: {}", message.getName)
        Behaviors.same
      }
    }

}
