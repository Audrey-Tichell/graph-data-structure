package graph

import zio.json._
import graph.JsonCodecs._
import graph.extensions.DotExport._

object Main extends App {

  // Création d'un graphe simple
  val g = DirectedGraph(Map("A" -> Set(("B", 1), ("C", 2))))

  // Encodage en JSON
  val json = g.toJson
  println(s"Graph as JSON: $json")

  // Décodage depuis JSON
  val decoded = json.fromJson[DirectedGraph[String]]
  decoded match {
    case Right(graph) =>
      println(s"Decoded graph: $graph")
      println("Graph in DOT format:")
      println(graph.toDot)
    case Left(error) =>
      println(s"Failed to decode graph: $error")
  }
}
