package rabbitplay

import akka.dispatch.Envelope
import com.rabbitmq.client.{BasicProperties, DefaultConsumer}

trait RabbitReceiver extends RabbitSetup {
  val consumer = new DefaultConsumer(channel) {
    def handleDelivery(consumerTag: String, envelope: Envelope, properties: BasicProperties, body: Array[Byte]) {
      println("Received: " + fromBytes(body))
    }
  }

  def consume(): String = {
    channel.basicConsume(queue, true, consumer)
  }
}
