import akka.stream.scaladsl._

object HelloWorld {

  def main(args: Array[String]): Unit = {

    // Create an Akka Stream that prints "Hello" to the console.
    val source = Source.fromPublisher(Http().outgoingConnection("localhost", 8080))
    val sink = Sink.foreach(r => println(r.uri))
    // Run the stream.
    source.to(sink).run()

    // Create a new Akka Stream that listens for messages on port 8080.
    val sink = Sink.foreach[String](println)

    // Run the stream.
    sink.runWith(Source.fromSocket("localhost", 8080))
  }
}
