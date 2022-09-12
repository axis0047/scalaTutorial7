object Question4 {
    def main (args: Array[String]):Unit = {
        val bank1 = new Bank()

        val account1 = new Account("12345", 50,10000)
        val account2 = new Account("67890", 50, 30000)
        val account3 = new Account("45632", 20, 40000)
        val account4 = new Account("13243", 10, 25000)

        bank1.addAcc(account1)
        bank1.addAcc(account2)
        bank1.addAcc(account3)
        bank1.addAcc(account4)

        account3.withdraw(40000)
        account4.withdraw(30000)
        account2.transfer(account1, 32000)

        // 4.1
        println("Negative account balances are ") 
        bank1.listOfNegativeAccounts
        println()

        // 4.2
        print("Sum of all balances is ") 
        println(bank1.sumOfAllAccounts)
        println()

        //4.3
        println("List of all balances after interest is ") 
        bank1.interest
        //bank1.listAccounts
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
}