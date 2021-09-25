package pingali.jeevan.learning.akka
package set1

import akka.actor.typed.ActorSystem
import akka.event.slf4j.Logger

object Main extends App {
  val logger = Logger("Main")
  logger.info("About to create Actor system")

  val system: ActorSystem[HelloWorldMain.SayHello] = ActorSystem(HelloWorldMain(), "hello")
  logger.info(s"Actor system created $system, about to call SayHello")

  system ! HelloWorldMain.SayHello("World")
  logger.info("First hello")
  system ! HelloWorldMain.SayHello("Akka")
  logger.info("Second hello")

  Thread.sleep(10 * 1000)
  system.terminate()
}
