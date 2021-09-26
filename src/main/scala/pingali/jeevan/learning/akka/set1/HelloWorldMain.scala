package pingali.jeevan.learning.akka
package set1

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import akka.event.slf4j.Logger

object HelloWorldMain {
  val logger= Logger("HelloWorldMain")

  def apply(): Behavior[SayHello] =
    Behaviors.setup { context =>
      logger.info(s"Context: $context")
      val greeter = context.spawn(HelloWorld(), "greeter")
      logger.info(s"Greeter: $greeter")

      Behaviors.receiveMessage { message =>
        logger.info(s"Received message $message")
        val replyTo = context.spawn(HelloWorldBot(max = 3), message.name)
        logger.info(s"Reply to $replyTo")
        greeter ! HelloWorld.Greet(message.name, replyTo)
        Behaviors.same
      }
    }

  final case class SayHello(name: String)

}
