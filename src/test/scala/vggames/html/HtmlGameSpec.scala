package vggames.html;

import java.util.concurrent.TimeUnit
import org.junit.runner.RunWith
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import vggames.browser.WebBrowser

@RunWith(classOf[JUnitRunner])
class HtmlGameSpec extends Specification with WebBrowser {

  sequential

  var ind = 0

  "HtmlGame" should {

    "basic 0" in {

      task("html", ind)
      solve("<p>Hello world!</p>")
      verifyOk must beTrue

    }

    "basic fail" in {

      task("html", ind)
      solve("<p>Hello world!!!!</p>")
      verifyOk must beFalse

    }
    "basic 1" in {
      ind += 1
      task("html", ind)
      solve("<h1>título</h1>")
      verifyOk must beTrue
    }

    "basic 2" in {
      ind += 1
      task("html", ind)
      solve("<h2>título 2</h2>")
      verifyOk must beTrue
    }

    "basic 3" in {
      ind += 1
      task("html", ind)
      solve("<h3>título 3</h3>")
      verifyOk must beTrue
    }

    "structure 1" in
      {
        ind += 1
        task("html", ind)
        solve("<html><head><title>Página html</title></head><body>Oi mundo</body></html>")
        verifyOk must beTrue
      }

    "structure 2" in
      {
        ind += 1
        task("html", ind)
        solve("<html><head><title>Minha página</title></head><body><b>Conteúdo da minha página</b></body></html>")
        verifyOk must beTrue
      }

    "structure 3" in
      {
        ind += 1
        task("html", ind)
        solve("""<html><head><title>Página com link</title></head><body><a href="www.google.com">Google</a></body></html>""")
        verifyOk must beTrue
      }

    "paragraph 1" in
      {
        ind += 2
        task("html", ind)
        solve("<p>Oi mundo</p>")
        verifyOk must beTrue
      }

    "paragraph 2" in
      {
        ind += 1
        task("html", ind)
        solve("<p><b>Oi</b> mundo</p>")
        verifyOk must beTrue
      }

    "format 1" in
      {
        ind += 1
        task("html", ind)
        solve("texto em <i>itálico</i>")
        verifyOk must beTrue
      }

    "format 2" in
      {
        ind += 1
        task("html", ind)
        solve("texto <big>grande</big>")
        verifyOk must beTrue
      }

    "format 3" in
      {
        ind += 1
        task("html", ind)
        solve("texto <small>pequeno</small>")
        verifyOk must beTrue
      }

    "format 4" in
      {
        ind += 1
        task("html", ind)
        solve("O html permite texto em <b>negrito</b>, <i>itálico</i>, <big>grande</big>, <small>pequeno</small> e muito mais.")
        verifyOk must beTrue
      }

    "format 5" in
      {
        ind += 1
        task("html", ind)
        solve("""<code>System.out.println("Hello world!")</code>""")
        verifyOk must beTrue
      }

    "format 6" in // TODO: Arrumar esse teste quando n��o houver mais bugs no verificador
      {
        ind += 1
        task("html", ind)
        solve("<pre>Esse texto    contém 4 espaços e uma quebra de linha</pre>")
        verifyOk must beTrue // Alterar!
      }

    "link 1" in
      {
        ind += 1
        task("html", ind)
        solve("""<a href="http://www.google.com">Google</a>""")
        verifyOk must beTrue
      }

    "link 2" in
      {
        ind += 1
        task("html", ind)
        solve("""<a href="http://home.com"><h1>Home</h1></a>""")
        verifyOk must beTrue
      }

    "link 3" in
      {
        ind += 1
        task("html", ind)
        solve("""<a href="#indice">Vai</a><a name="indice">Indice 1</a>""")
        verifyOk must beTrue
      }

    "image 1" in
      {
        ind += 1
        task("html", ind)
        solve("""<img src="http://www.vidageek.net/images/logo.png" alt="logo">""")
        verifyOk must beTrue
      }

    "image 2" in
      {
        ind += 1
        task("html", ind)
        solve("""<img src="http://www.vidageek.net/images/logo.png" height="100" alt="logo">""")
        verifyOk must beTrue
      }

    "image 3" in
      {
        ind += 1
        task("html", ind)
        solve("""<img src="http://www.vidageek.net/images/logo.png" height="100" width="200" alt="logo">""")
        verifyOk must beTrue
      }

    "multi 1" in
      {
        ind += 2
        task("html", ind)
        solve("""<video width=320 height=240 controls><source src="http://www.html5rocks.com/en/tutorials/video/basics/Chrome_ImF.ogv" type="video/mp4"></video>""")
        verifyOk must beTrue
      }

    "multi 2" in
      {
        ind += 1
        task("html", ind)
        solve("""<audio controls><source src="http://www.w3schools.com/html/horse.ogg" type="audio/ogg"></audio>""")
        verifyOk must beTrue
      }

    "list 1" in
      {
        ind += 1
        task("html", ind)
        solve("""<ul><li> Carro </li><li> Moto </li><li> Barco </li></ul>""")
        verifyOk must beTrue
      }

    "list 2" in
      {
        ind += 1
        task("html", ind)
        solve("""<ol><li> Abacaxi </li><li> Uva </li><li> Banana </li></ol>""")
        verifyOk must beTrue
      }

    "list 3" in
      {
        ind += 1
        task("html", ind)
        solve("""<dl><dt>Grama</dt><dd>Verde</dd><dt>Sol</dt><dd>Amarelo</dd></dl>""")
        verifyOk must beTrue
      }

    "table 1" in
      {
        ind += 1
        task("html", ind)
        solve("""<table border="1"><tr><td>1</td><td>2</td></tr><tr><td>3</td><td>4</td></tr></table>""")
        verifyOk must beTrue
      }

    "table 2" in
      {
        ind += 1
        task("html", ind)
        solve("""<table border=1><tr><td colspan=2><b>Negrito</b></td></tr><tr><td>Esquerda</td><td>Direita</td></tr></table>""")
        verifyOk must beTrue
      }

    "table 3" in
      {
        ind += 1
        task("html", ind)
        solve("""<table border=1><tr><td rowspan=2><b>Negrito</b></td><td>Acima</td></tr><tr><td>Abaixo</td></tr></table>""")
        verifyOk must beTrue
      }

    "div 1" in
      {
        ind += 1
        task("html", ind)
        solve("""<div><span>Minha querida div</span></div>""")
        verifyOk must beTrue
      }

    "svg 1" in
      {
        ind += 1
        task("html", ind)
        solve("""<svg><circle cx="50" cy="50" r="50" fill="blue" /></svg>""")
        verifyOk must beTrue
      }

    "svg 2" in
      {
        ind += 1
        task("html", ind)
        solve("""<svg><rect x="50" y="50" width="40" height="20" fill="grey" /></svg>""")
        verifyOk must beTrue
      }

    "svg 3" in
      {
        ind += 1
        task("html", ind)
        solve("""<svg><circle cx="40" cy="40" r="10" fill="white" stroke="black" stroke-width="3" /></svg>""")
        verifyOk must beTrue
      }

    "datalist 1" in
      {
        ind += 1
        task("html", ind)
        solve("""<input list="transporte"><datalist id="transporte"><option value="Carro"><option value="Moto"><option value="Barco"></datalist>""")
        verifyOk must beTrue
      }

  }
}
