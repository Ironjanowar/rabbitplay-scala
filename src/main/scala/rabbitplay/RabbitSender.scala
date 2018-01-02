package rabbitplay

trait RabbitSender extends RabbitSetup {
  def send(message: String, routingKey: String): Unit = {
    println(s"Sending message '$message' to routingKey '$routingKey'")
    channel.basicPublish(exchange_name, routingKey, null, message.getBytes)
  }
}
