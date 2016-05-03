
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/main("Targ\u00E9t")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
"""),format.raw/*4.1*/("""<script type='text/javascript' src='"""),_display_(/*4.38*/routes/*4.44*/.Assets.at("javascripts/index.js")),format.raw/*4.78*/("""'></script>

<p id="storemoney"></p>
<p id="storeinventory"></p>
<p id="selfmoney"></p>
<p id="selfinventory"></p>
<p id="message"></p>

<ul id="values"></ul>

<form method="POST" action=""""),_display_(/*14.30*/routes/*14.36*/.Application.buy()),format.raw/*14.54*/("""">
    <input type="text" name="valData" placeholder="item"/>
    <button>Buy</button>
</form>
<form method="POST" action=""""),_display_(/*18.30*/routes/*18.36*/.Application.sell()),format.raw/*18.55*/("""">
    <input type="text" name="valData" placeholder="item"/>
    <button>Sell</button>
</form>

<p id="pricelist"></p>
""")))}),format.raw/*24.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Thu Apr 28 18:59:32 PDT 2016
                  SOURCE: C:/cygwin/home/KG/p4/app/views/index.scala.html
                  HASH: 6d1cfca9916344cac8c5d911b64995732dc8ebf8
                  MATRIX: 738->1|834->3|862->6|889->25|928->27|955->28|1018->65|1032->71|1086->105|1302->294|1317->300|1356->318|1507->442|1522->448|1562->467|1713->588
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|35->4|35->4|35->4|45->14|45->14|45->14|49->18|49->18|49->18|55->24
                  -- GENERATED --
              */
          