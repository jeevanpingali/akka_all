package pingali.jeevan.learning.akka
package events

import akka.actor.typed.ActorSystem
import akka.event.slf4j.Logger
import tutorial.addressbook.{OrderPlaced, Person}

object Main extends App {
  val logger = Logger("Events Main")
  logger.info("About to create Actor system")

  val system: ActorSystem[Person] = ActorSystem(PersonActor(), "personActor")
  logger.info(s"Actor system created $system, about to call SayHello")

  system ! Person("World", 1)
  logger.info("First hello")
  system ! Person("Hello", 2)
  logger.info("Second hello")

  val orderPlaced = new OrderPlaced(1, "Hi", false)
  val system2: ActorSystem[OrderPlaced] = ActorSystem(OrderPlacedActor(), "orderPlacedActor")
  system2 ! orderPlaced

  Thread.sleep(10 * 1000)

  system.terminate()
  system2.terminate()

}
