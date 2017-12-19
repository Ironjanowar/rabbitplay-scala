package rabbitplay

trait RabbitSender extends RabbitSetup {
  def send(message: String): Unit = {
    println(s"Sending: $message")
    channel.basicPublish("logs", "", null, message.getBytes)
  }
}
