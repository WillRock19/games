package vggames.meta

import vggames.shared.GameView
import vggames.shared.Game
import vggames.shared.task.JudgedTask
import scalatags._
import vggames.shared.task.IndexedTask

class MetaGameView extends GameView {

  def render(game : Game, task : IndexedTask, judgedTask : Option[JudgedTask], lastAttempt : String) = {

    div("row".cls)(
      div("span5".cls)(
        judgement(judgedTask),
        form("challenge".cls, "method".attr := "POST", action := s"/play/${game.path}/task/${task.index}")(
          label("for".attr := "challenge")(strong(raw(task.challenge))),
          input(id := "challenge-submit", "btn btn-primary".cls, "type".attr := "submit", value := "Check!")),
        progressBar(task, game)),
      taskDescription(task, "span7")).toString
  }
}