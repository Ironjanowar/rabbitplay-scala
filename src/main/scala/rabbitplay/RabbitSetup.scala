package rabbitplay

//import com.rabbitmq.client.AMQP.{Exchange, Queue}
//import com.rabbitmq.client.{Channel, Connection, ConnectionFactory}
import com.newmotion.akka.rabbitmq._

trait RabbitSetup {
  val factory = new ConnectionFactory()
  factory.setHost("localhost")
  val connection: Connection = factory.newConnection()
  val channel: Channel = connection.createChannel()
  val exchange = channel.exchangeDeclare("logs", "fanout", false, false, null)
  val raw_queue = channel.queueDeclare("lequeue", false, false, false, null)
  val queue: String = raw_queue.getQueue
  channel.queueBind(queue, "logs", "")

  // Utils
  def fromBytes(x: Array[Byte]) = new String(x, "UTF-8")
  def toBytes(x: Long): Array[Byte] = x.toString.getBytes("UTF-8")
}
