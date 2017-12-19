package rabbitplay

import com.rabbitmq.client.AMQP.Exchange
import com.rabbitmq.client.{Channel, Connection, ConnectionFactory}

trait RabbitSetup {
  val factory = new ConnectionFactory()
  factory.setHost("localhost")
  val connection: Connection = factory.newConnection()
  val channel: Channel = connection.createChannel()
  val exchange: Exchange.DeclareOk = channel.exchangeDeclare("logs", "fanout")
  val queue: String = channel.queueDeclare().getQueue
  channel.queueBind(queue, "logs", "")

  // Utils
  def fromBytes(x: Array[Byte]) = new String(x, "UTF-8")
  def toBytes(x: Long): Array[Byte] = x.toString.getBytes("UTF-8")
}
