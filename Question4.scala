object Question4 {
    def main (args: Array[String]):Unit = {
        
        val newbank = new Bank()

        val acc1 = new Account("990442037", 123, 20000)
        val acc2 = new Account("990442038", 124, -10000)
        val acc3 = new Account("990442039", 125, 30000)
        val acc4 = new Account("990442030", 126, 50000)

        newbank.addAcc(acc1)
        newbank.addAcc(acc2)
        newbank.addAcc(acc3)
        newbank.addAcc(acc4)

        println("Negative Accounts :")
        println(newbank.listOfNegativeAccounts)

        println("Sum of All accounts :")
        println(newbank.sumOfAllAccounts)

        newbank.interest
        newbank.printAcc


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

class Bank {

    var bank: List[Account] = List()

    def listOfNegativeAccounts = {
        bank.filter(_.balance < 0).foreach(println)
    }

    def sumOfAllAccounts = bank.map(_.balance).sum 

    def interest = {
        bank.filter(_.balance > 0).foreach(_.balance *= 1.05)
        bank.filter(_.balance < 0).foreach(_.balance *= 1.1)
    }

    def addAcc(a:Account) = {
        bank = a :: bank 
    }

    def printAcc = {
        bank.foreach(println)
    }
}