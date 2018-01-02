package rabbitplay

object Main extends App with RabbitSender with RabbitReceiver {
  // Consuming queue chat.*
  consume("chat.*")

  // Sending to chat.patata
  send("LeTest", "chat.patata")
}
