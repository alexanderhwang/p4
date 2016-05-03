
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/cygwin/home/KG/p4/conf/routes
// @DATE:Thu Apr 28 18:59:32 PDT 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:18
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def priceList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.priceList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pricelist"})
        }
      """
    )
  
    // @LINE:12
    def selfMoney: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.selfMoney",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "selfmoney"})
        }
      """
    )
  
    // @LINE:14
    def message: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.message",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
        }
      """
    )
  
    // @LINE:8
    def sell: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.sell",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sell"})
        }
      """
    )
  
    // @LINE:11
    def storeInventory: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.storeInventory",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "storeinventory"})
        }
      """
    )
  
    // @LINE:13
    def selfInventory: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.selfInventory",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "selfinventory"})
        }
      """
    )
  
    // @LINE:7
    def buy: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.buy",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "buy"})
        }
      """
    )
  
    // @LINE:9
    def getValues: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getValues",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "values"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:10
    def storeMoney: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.storeMoney",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "storemoney"})
        }
      """
    )
  
  }


}
