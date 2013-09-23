package com.takumibaba.babascriptforscala

import scala.language.dynamics
import com.takumibaba.lindabase.client.Linda
import scala.util.parsing.json.{JSONObject, JSONArray}
import scala.collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: takumi
 * Date: 2013/09/23
 * Time: 2:18
 * To change this template use File | Settings | File Templates.
 */
class Human extends Dynamic {
  var linda:Linda = new Linda()

  def applyDynamic(methodName:String)(args:Any*) = {
    var arguments:List[Any] = args.asInstanceOf[mutable.WrappedArray[Any]].toList
    send(methodName, arguments)
  }

  def send(methodName:String, arguments:List[Any]){
    if(!linda.io.isRunning){
      linda.io.once("connect", (resultTuple:List[Any])=>{
        var tuple:JSONArray = new JSONArray(List("babascript", "eval", methodName, new JSONArray(arguments), new JSONObject(Map("callback" -> linda.tupleSpace.callbackId()))))
        linda.tupleSpace.write(tuple, new JSONArray(List()))
      })
      linda.connect()
    }else{
      var tuple:JSONArray = new JSONArray(List("babascript", "eval", methodName, new JSONArray(arguments), new JSONObject(Map("callback" -> linda.tupleSpace.callbackId()))))
      linda.tupleSpace.write(tuple, new JSONArray(List()))
    }
  }
}
