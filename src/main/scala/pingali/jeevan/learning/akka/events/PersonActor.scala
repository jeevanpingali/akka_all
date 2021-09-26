package pingali.jeevan.learning.akka.events

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import all_events.AllEvents.Person

object PersonActor {

  def apply(): Behavior[Person] =
    Behaviors.setup { context =>
      context.log.info(s"Context: $context")

      Behaviors.receiveMessage { message =>
        context.log.info(s"Received message: ${message.getName}")
        Behaviors.same
      }
    }
}
