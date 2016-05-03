
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/cygwin/home/KG/p4/conf/routes
// @DATE:Thu Apr 28 18:59:32 PDT 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
