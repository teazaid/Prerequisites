package dev.zaidel.ui

import java.io.{File, PrintWriter}
import scala.io.Source
import scala.util.Using

trait ReadFromFileWithFallback {
  def readWithFallback(file: File, fallback: List[String]): List[String] =
    (if (file.exists())
      Using(Source.fromFile(file)) {
        resource => resource.getLines().toList
      }
    else
      Using(new PrintWriter(file)) { pw =>
        fallback.foreach(pw.println)
        fallback
      }
      ).getOrElse(fallback)
}
