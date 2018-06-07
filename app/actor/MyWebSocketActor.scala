package actor

import akka.actor._

object MyWebSocketActor {
  def props(out: ActorRef) = Props(new MyWebSocketActor(out))
}

import scala.concurrent.duration._
import akka.actor.Timers

class MyWebSocketActor(out: ActorRef) extends Actor with Timers {

  timers.startPeriodicTimer("I like Scala", "I like Scala", 500.millis)

  def receive = {
    case msg: String =>
      //out ! ("I received your message: " + msg)
        out ! msg
  }
}
