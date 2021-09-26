package pingali.jeevan.learning.akka.events

import akka.actor.typed.ActorSystem
import akka.event.slf4j.Logger
import all_events.AllEvents._

object Main extends App {
  val logger = Logger("Events Main")
  logger.info("About to create Actor system")

  val system: ActorSystem[Person] = ActorSystem(PersonActor(), "personActor")
  logger.info(s"Actor system created $system, about to call SayHello")

  val person1 = Person.newBuilder()
  person1.setName("World")
  person1.setId(1)

  system ! person1.build()
  logger.info("First hello")

  val person2 = Person.newBuilder()
  person2.setName("Hello")
  person2.setId(2)
  system ! person2.build()
  logger.info("Second hello")

  val orderPlaced = OrderPlaced.newBuilder//(1, "Hi", false)
  orderPlaced.setId(1)
  orderPlaced.setName("Hi")
  orderPlaced.setFulfilled(false)
  val system2: ActorSystem[OrderPlaced] = ActorSystem(OrderPlacedActor(), "orderPlacedActor")
  system2 ! orderPlaced.build()

  Thread.sleep(5 * 1000)

  system.terminate()
  system2.terminate()

}
