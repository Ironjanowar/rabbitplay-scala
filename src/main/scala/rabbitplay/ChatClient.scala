package rabbitplay

class ChatClient(clientId: String) extends RabbitReceiver with RabbitSender {
    def joinTo(chat: String): Unit = {
      // Subscribes to messages from specific chats
    }

    def sendTo(chat: String): Unit = {
      // Sends message to specific chat
    }
}
