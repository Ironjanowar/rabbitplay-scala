package rabbitplay

object Main extends App with RabbitSender with RabbitReceiver {
  consume()

  send("MEEEEEEEEEH!")
}
