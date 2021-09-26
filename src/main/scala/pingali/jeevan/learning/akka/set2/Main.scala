package pingali.jeevan.learning.akka
package set2

import akka.actor.typed.ActorSystem
import akka.event.slf4j.Logger

object Main extends App {
  val logger = Logger("Main")
  logger.info("About to create Actor system")

  val system: ActorSystem[Actor1.EventOne] = ActorSystem(Actor1(), "hello")
  logger.info(s"Actor system created $system, about to call SayHello")

  system ! Actor1.EventOne("World")
  logger.info("First hello")
  system ! Actor1.EventOne("Akka")
  logger.info("Second hello")

  Thread.sleep(10 * 1000)
  system.terminate()
}
