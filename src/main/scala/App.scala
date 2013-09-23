package com.takumibaba.babascriptforscala

import com.takumibaba.lindabase.client.Linda
import scala.util.parsing.json.JSONArray


object App {
  def main(args: Array[String]) {
    print("Hello com.takumibaba.BabaScriptForScala!")


    var baba:Baba = new Baba()
    baba.hogefuga("頑張れ", "どうにかしろ")
  }
}
