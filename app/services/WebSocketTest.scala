package services

import actor.MyWebSocketActor
import play.api.mvc._
import play.api.libs.streams.ActorFlow
import javax.inject.Inject
import akka.actor.ActorSystem
import akka.stream.Materializer

class WebSocketTest @Inject()(cc:ControllerComponents) (implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc) {


  def socket = WebSocket.accept[String, String] { request =>
    ActorFlow.actorRef { out =>
      MyWebSocketActor.props(out)
    }
  }
}
