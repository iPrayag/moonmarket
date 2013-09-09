import net.liftweb.http.S

class Success {
  val amount = S.param("amount") openOr "No parameter given"
  println(amount)
  //def render = "#amount" #> "amount"
}
