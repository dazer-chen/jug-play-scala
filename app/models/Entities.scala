package models

import scala.slick.driver.BasicDriver.simple._

import Database.threadLocalSession
import java.sql.Timestamp


case class User(id: Option[Long],email: Option[String])

object Users extends Table[User]("User"){
  def id = column[Long]("id", O.PrimaryKey)
  def email = column[String]("email")
  def * = id.? ~ email.? <> (User, User.unapply _)

  def all() = Query(Users).list
}
case class Answer(id: Option[Long],answer: String,votes: Option[Long],poll_id: Long)

object Answers extends Table[Answer]("answer"){
  def id = column[Long]("id", O.PrimaryKey)
  def answer = column[String]("answer")
  def votes = column[Long]("votes")
  def poll_id = column[Long]("poll_id")
  def * = id.? ~ answer ~ votes.? ~ poll_id <> (Answer, Answer.unapply _)

  def all() = Query(Answers).list
}
case class Event(id: Option[Long],capacity: Int,date: Option[Timestamp],description: Option[String],location: Option[String],map: Option[String],open: Boolean,registrationurl: Option[String],report: Option[String],title: Option[String],partner_id: Option[Long])
object Events extends Table[Event]("event"){
  def id = column[Long]("id", O.PrimaryKey)
  def capacity = column[Int]("capacity")
  def date = column[Timestamp]("date")
  def description = column[String]("description")
  def location = column[String]("location")
  def map = column[String]("map")
  def open = column[Boolean]("open")
  def registrationurl = column[String]("registrationurl")
  def report = column[String]("report")
  def title = column[String]("title")
  def partner_id = column[Long]("partner_id")
  def * = id.? ~ capacity ~ date.? ~ description.? ~ location.? ~ map.? ~ open ~ registrationurl.? ~ report.? ~ title.? ~ partner_id.? <> (Event, Event.unapply _)

  
  def all() = Query(Events).list
}
case class Eventpartner(id: Option[Long],description: Option[String],logourl: Option[String],name: Option[String],url: Option[String])

object Eventpartners extends Table[Eventpartner]("eventpartner"){
  def id = column[Long]("id", O.PrimaryKey)
  def description = column[String]("description")
  def logourl = column[String]("logourl")
  def name = column[String]("name")
  def url = column[String]("url")
  def * = id.? ~ description.? ~ logourl.? ~ name.? ~ url.? <> (Eventpartner, Eventpartner.unapply _)

  def all() = Query(Eventpartners).list
}
case class News(id: Option[Long],comments: Boolean,content: Option[String],date: Option[Timestamp],title: Option[String])

object Newss extends Table[News]("news"){
  def id = column[Long]("id", O.PrimaryKey)
  def comments = column[Boolean]("comments")
  def content = column[String]("content")
  def date = column[Timestamp]("date")
  def title = column[String]("title")
  def * = id.? ~ comments ~ content.? ~ date.? ~ title.? <> (News, News.unapply _)

  def all() = Query(Newss).list
}
case class Participation(id: Option[Long],code: Option[String],status: Option[Int],event_id: Option[Long],user_id: Option[Long])

object Participations extends Table[Participation]("participation"){
  def id = column[Long]("id", O.PrimaryKey)
  def code = column[String]("code")
  def status = column[Int]("status")
  def event_id = column[Long]("event_id")
  def user_id = column[Long]("user_id")
  def * = id.? ~ code.? ~ status.? ~ event_id.? ~ user_id.? <> (Participation, Participation.unapply _)

  def all() = Query(Participations).list
}
case class Play_evolutions(id: Int,hash: String,applied_at: Timestamp,apply_script: Option[String],revert_script: Option[String],state: Option[String],last_problem: Option[String])

object Play_evolutionss extends Table[Play_evolutions]("play_evolutions"){
  def id = column[Int]("id", O.PrimaryKey)
  def hash = column[String]("hash")
  def applied_at = column[Timestamp]("applied_at")
  def apply_script = column[String]("apply_script")
  def revert_script = column[String]("revert_script")
  def state = column[String]("state")
  def last_problem = column[String]("last_problem")
  def * = id ~ hash ~ applied_at ~ apply_script.? ~ revert_script.? ~ state.? ~ last_problem.? <> (Play_evolutions, Play_evolutions.unapply _)

  def all() = Query(Play_evolutionss).list
}
case class Poll(id: Option[Long],question: String,expirydate: Option[Timestamp],visible: Option[Boolean])

object Polls extends Table[Poll]("poll"){
  def id = column[Long]("id", O.PrimaryKey)
  def question = column[String]("question")
  def expirydate = column[Timestamp]("expirydate")
  def visible = column[Boolean]("visible")
  def * = id.? ~ question ~ expirydate.? ~ visible.? <> (Poll, Poll.unapply _)

  def all() = Query(Polls).list
}
case class Speaker(id: Option[Long],activity: Option[String],compan: Option[String],description: Option[String],fullname: Option[String],jugmember: Option[Boolean],memberfct: Option[String],photourl: Option[String],url: Option[String],email: Option[String],personalurl: Option[String])

object Speakers extends Table[Speaker]("speaker"){
  def id = column[Long]("id", O.PrimaryKey)
  def activity = column[String]("activity")
  def compan = column[String]("compan")
  def description = column[String]("description")
  def fullname = column[String]("fullname")
  def jugmember = column[Boolean]("jugmember")
  def memberfct = column[String]("memberfct")
  def photourl = column[String]("photourl")
  def url = column[String]("url")
  def email = column[String]("email")
  def personalurl = column[String]("personalurl")
  def * = id.? ~ activity.? ~ compan.? ~ description.? ~ fullname.? ~ jugmember.? ~ memberfct.? ~ photourl.? ~ url.? ~ email.? ~ personalurl.? <> (Speaker, Speaker.unapply _)

  def all() = Query(Speakers).list
}
case class Tag(id: Option[Long],name: Option[String])

object Tags extends Table[Tag]("tag"){
  def id = column[Long]("id", O.PrimaryKey)
  def name = column[String]("name")
  def * = id.? ~ name.? <> (Tag, Tag.unapply _)

  def all() = Query(Tags).list
}
case class Talk(id: Option[Long],orderinevent: Int,teaser: Option[String],datetime: Option[String],title: Option[String],event_id: Option[Long],speaker_id: Option[Long])

object Talks extends Table[Talk]("talk"){
  def id = column[Long]("id", O.PrimaryKey)
  def orderinevent = column[Int]("orderinevent")
  def teaser = column[String]("teaser")
  def datetime = column[String]("datetime")
  def title = column[String]("title")
  def event_id = column[Long]("event_id")
  def speaker_id = column[Long]("speaker_id")
  def * = id.? ~ orderinevent ~ teaser.? ~ datetime.? ~ title.? ~ event_id.? ~ speaker_id.? <> (Talk, Talk.unapply _)

  
  def speaker = foreignKey("speaker_id", speaker_id, Speakers)(_.id)
  
  def all() = Query(Talks).list
}
case class Talk_tag(talk_id: Long,tags_id: Long)

object Talk_tags extends Table[Talk_tag]("talk_tag"){
  def talk_id = column[Long]("talk_id", O.PrimaryKey)
  def tags_id = column[Long]("tags_id", O.PrimaryKey)
  def * = talk_id ~ tags_id <> (Talk_tag, Talk_tag.unapply _)

  def all() = Query(Talk_tags).list
}
case class Yearpartner(id: Option[Long],description: Option[String],logourl: Option[String],name: Option[String],startdate: Option[Timestamp],stopdate: Option[Timestamp],url: Option[String])

object Yearpartners extends Table[Yearpartner]("yearpartner"){
  def id = column[Long]("id", O.PrimaryKey)
  def description = column[String]("description")
  def logourl = column[String]("logourl")
  def name = column[String]("name")
  def startdate = column[Timestamp]("startdate")
  def stopdate = column[Timestamp]("stopdate")
  def url = column[String]("url")
  def * = id.? ~ description.? ~ logourl.? ~ name.? ~ startdate.? ~ stopdate.? ~ url.? <> (Yearpartner, Yearpartner.unapply _)

  def all() = Query(Yearpartners).list
}





// def speaker = foreignKey("speaker_id", speaker_id, Speakers)(_.id)


//  def all = {
//    val q = for {
//      c <- Speakers
//    } yield (c)
//
//    q.list
//  }
