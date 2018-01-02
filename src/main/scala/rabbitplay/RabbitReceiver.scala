package rabbitplay

//import akka.dispatch.Envelope
//import com.rabbitmq.client.{BasicProperties, DefaultConsumer}
import com.newmotion.akka.rabbitmq._

trait RabbitReceiver extends RabbitSetup {
  def consume(routingKey: String): String = {
    //println(s"Consumer Ready in queue: $queue")

    val queue: String = channel.queueDeclare().getQueue

    channel.queueBind(queue, exchange_name, routingKey)

    val consumer = new DefaultConsumer(channel) {
      override def handleDelivery(consumerTag: String, envelope: Envelope, properties: BasicProperties, body: Array[Byte]): Unit = {
        println(s"[$routingKey]Received: " + fromBytes(body))
      }
    }
    channel.basicConsume(queue, true, consumer)
  }
}
