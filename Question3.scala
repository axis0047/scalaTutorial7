object Question3 {
    def main (args: Array[String]):Unit = {
       val account1 = new Account("12345", 50, 10000)
        val account2 = new Account("67890", 60, 30000)

        account2.transfer(account1, 5000)
    
        println(account1)
        println(account2) 
    }
}


class Account(id:String,n:Int,b:Double){

    var balance:Double = b 
    val nic:String = id
    val acnumber: Int = n

    override def toString = "["+nic+":"+acnumber +":"+ balance+"]"

    def withdraw(a:Double) = this.balance = this.balance - a 
    def deposit(a:Double) = this.balance = this.balance + a 
    def transfer(a:Account,b:Double) = {
        this.withdraw(b)
        a.deposit(b)
    }
    
}