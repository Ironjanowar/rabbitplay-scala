package rabbitplay

trait RabbitSender extends RabbitSetup {
  def send(message: String): Unit = {
    println(s"Sending message '$message' to queue '$queue'")
    channel.basicPublish("logs", "", null, message.getBytes)
  }
}
