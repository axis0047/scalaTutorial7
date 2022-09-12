object Question1 {
    def main (args: Array[String]):Unit = {
        
        val pi = new Rational(22,7)
        println(pi.neg())
    }
}


class Rational(x:Int,y:Int){

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    def numer = x/gcd(x,y)
    def denom = y/gcd(x,y)

    def neg(): Rational = new Rational(-x,y)

    override def toString = numer.toString + "/" + denom.toString
}