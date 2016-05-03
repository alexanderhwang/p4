
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/cygwin/home/KG/p4/conf/routes
// @DATE:Thu Apr 28 18:59:32 PDT 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_1: controllers.Application,
  // @LINE:18
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_1: controllers.Application,
    // @LINE:18
    Assets_0: controllers.Assets
  ) = this(errorHandler, Application_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """buy""", """controllers.Application.buy()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sell""", """controllers.Application.sell()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """values""", """controllers.Application.getValues"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """storemoney""", """controllers.Application.storeMoney"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """storeinventory""", """controllers.Application.storeInventory"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """selfmoney""", """controllers.Application.selfMoney"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """selfinventory""", """controllers.Application.selfInventory"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.Application.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pricelist""", """controllers.Application.priceList"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_1.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Application_buy1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("buy")))
  )
  private[this] lazy val controllers_Application_buy1_invoker = createInvoker(
    Application_1.buy(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "buy",
      Nil,
      "POST",
      """""",
      this.prefix + """buy"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Application_sell2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sell")))
  )
  private[this] lazy val controllers_Application_sell2_invoker = createInvoker(
    Application_1.sell(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "sell",
      Nil,
      "POST",
      """""",
      this.prefix + """sell"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_getValues3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("values")))
  )
  private[this] lazy val controllers_Application_getValues3_invoker = createInvoker(
    Application_1.getValues,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getValues",
      Nil,
      "GET",
      """""",
      this.prefix + """values"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_storeMoney4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("storemoney")))
  )
  private[this] lazy val controllers_Application_storeMoney4_invoker = createInvoker(
    Application_1.storeMoney,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "storeMoney",
      Nil,
      "GET",
      """""",
      this.prefix + """storemoney"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_storeInventory5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("storeinventory")))
  )
  private[this] lazy val controllers_Application_storeInventory5_invoker = createInvoker(
    Application_1.storeInventory,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "storeInventory",
      Nil,
      "GET",
      """""",
      this.prefix + """storeinventory"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Application_selfMoney6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("selfmoney")))
  )
  private[this] lazy val controllers_Application_selfMoney6_invoker = createInvoker(
    Application_1.selfMoney,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "selfMoney",
      Nil,
      "GET",
      """""",
      this.prefix + """selfmoney"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Application_selfInventory7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("selfinventory")))
  )
  private[this] lazy val controllers_Application_selfInventory7_invoker = createInvoker(
    Application_1.selfInventory,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "selfInventory",
      Nil,
      "GET",
      """""",
      this.prefix + """selfinventory"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Application_message8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_Application_message8_invoker = createInvoker(
    Application_1.message,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "message",
      Nil,
      "GET",
      """""",
      this.prefix + """message"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Application_priceList9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pricelist")))
  )
  private[this] lazy val controllers_Application_priceList9_invoker = createInvoker(
    Application_1.priceList,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "priceList",
      Nil,
      "GET",
      """""",
      this.prefix + """pricelist"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Assets_at10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at10_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_1.index())
      }
  
    // @LINE:7
    case controllers_Application_buy1_route(params) =>
      call { 
        controllers_Application_buy1_invoker.call(Application_1.buy())
      }
  
    // @LINE:8
    case controllers_Application_sell2_route(params) =>
      call { 
        controllers_Application_sell2_invoker.call(Application_1.sell())
      }
  
    // @LINE:9
    case controllers_Application_getValues3_route(params) =>
      call { 
        controllers_Application_getValues3_invoker.call(Application_1.getValues)
      }
  
    // @LINE:10
    case controllers_Application_storeMoney4_route(params) =>
      call { 
        controllers_Application_storeMoney4_invoker.call(Application_1.storeMoney)
      }
  
    // @LINE:11
    case controllers_Application_storeInventory5_route(params) =>
      call { 
        controllers_Application_storeInventory5_invoker.call(Application_1.storeInventory)
      }
  
    // @LINE:12
    case controllers_Application_selfMoney6_route(params) =>
      call { 
        controllers_Application_selfMoney6_invoker.call(Application_1.selfMoney)
      }
  
    // @LINE:13
    case controllers_Application_selfInventory7_route(params) =>
      call { 
        controllers_Application_selfInventory7_invoker.call(Application_1.selfInventory)
      }
  
    // @LINE:14
    case controllers_Application_message8_route(params) =>
      call { 
        controllers_Application_message8_invoker.call(Application_1.message)
      }
  
    // @LINE:15
    case controllers_Application_priceList9_route(params) =>
      call { 
        controllers_Application_priceList9_invoker.call(Application_1.priceList)
      }
  
    // @LINE:18
    case controllers_Assets_at10_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at10_invoker.call(Assets_0.at(path, file))
      }
  }
}
