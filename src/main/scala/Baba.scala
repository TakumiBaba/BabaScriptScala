package com.takumibaba.babascriptforscala

import com.takumibaba.babascriptforscala.Human
import com.takumibaba.lindabase.client.Linda
import scala.collection.mutable.ListBuffer

/**
 * Created with IntelliJ IDEA.
 * User: takumi
 * Date: 2013/09/23
 * Time: 3:11
 * To change this template use File | Settings | File Templates.
 */
class Baba extends Human {
  linda.tupleSpace.name = "takumibaba"


  def run(methodName:String, args:Any*){
    var arguments:ListBuffer[Any] = ListBuffer()
    for(arg <- args){
      arguments += arg
    }
    send(methodName, arguments.toList)
  }
}
