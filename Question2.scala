object Question2 {
    def main (args: Array[String]):Unit = {

        val x = new Rational(3, 4)
        val y = new Rational(5, 8)
        val z = new Rational(2, 7) 

        println((x.sub(y)).sub(z))
       
    }
}


class Rational(x:Int,y:Int){

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    val g = gcd(x,y)
    
    def numer = x/g
    def denom = y/g

    def neg(): Rational = new Rational(-x,y)

    def sub(r:Rational) = new Rational(numer * r.denom - r.numer * denom,denom * r.denom)

    override def toString = numer.toString + "/" + denom.toString
}