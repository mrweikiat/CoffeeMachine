package machine

class CoffeeMachine {
    enum class CoffeeState() {
        Action, ChoosingCoffee
    }
    
    var water = 400
    var milk = 540
    var coffeeBeans = 120
    var cups = 9
    var money = 550
    var coffeeState = CoffeeMachine.CoffeeState.Action
    
    fun buyCoffee() {
        coffeeState = CoffeeMachine.CoffeeState.ChoosingCoffee
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    }
    
    fun buyEspresso() {
        if (water - 250 < 0) {
            println("Sorry, not enough water")
        } else if (coffeeBeans - 16 < 0) {
            println("Sorry, not enough coffee beans")
        } else if (cups - 1 < 0) {
            println("Sorry, not enough cups")
        } else {
            println("I have enough resources, making you a coffee!")
            water -= 250
            coffeeBeans -= 16
            money += 4
            cups -= 1
        }
        coffeeState = CoffeeMachine.CoffeeState.Action
    }
    
    fun buyLatte() {
        if (water - 350 < 0) {
            println("Sorry, not enough water")
        } else if (coffeeBeans - 20 < 0) {
            println("Sorry, not enough coffee beans")
        } else if (cups - 1 < 0) {
            println("Sorry, not enough cups")
        } else if (milk - 75 < 0) {
            println("Sorry, not enough milk")
        } else {
            println("I have enough resources, making you a coffee!")
            water -= 350
            milk -= 75
            coffeeBeans -= 20
            money += 7
            cups -= 1
        }
        coffeeState = CoffeeMachine.CoffeeState.Action
    }
    
    fun buyCappo() {
        if (water - 200 < 0) {
            println("Sorry, not enough water")
        } else if (coffeeBeans - 12 < 0) {
            println("Sorry, not enough coffee beans")
        } else if (cups - 1 < 0) {
            println("Sorry, not enough cups")
        } else if (milk - 100 < 0) {
            println("Sorry, not enough milk")
        } else {
            println("I have enough resources, making you a coffee!")
            water -= 200
            milk -= 100
            coffeeBeans -= 12
            money += 6
            cups -= 1
        }
        coffeeState = CoffeeMachine.CoffeeState.Action
    }
    
    fun takeMoney() {
        println("I gave you $$money")
        money = 0
    }
    
    fun fill(_water:Int, _milk: Int, _coffeeBeans: Int, _cups: Int) {
        water += _water
        milk += _milk
        coffeeBeans += _coffeeBeans
        cups += _cups
    }
    
    fun checkStatus() {
        println("The coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$coffeeBeans of coffee beans")
        println("$cups of disposable cups")
        println("$money of money")
    }
    
}


fun main() {
    
    val coffeeMachine = CoffeeMachine()
    
    do {
        println()
        println("Write action (buy, fill, take, remaining, exit):")
        println()
        
        val action = readLine()!!
        
        when(action) {
            "buy" -> {
            coffeeMachine.buyCoffee()
            val action2 = readLine()!!
            if (action2 != "back") {
                val number = action2.toInt()
                when(number) {
                1 -> {
                    coffeeMachine.buyEspresso()
                }
                2 -> {
                    coffeeMachine.buyLatte()
                }
                3 -> {
                    coffeeMachine.buyCappo()
                }
            }
            }
        }
        "take" -> {
            coffeeMachine.takeMoney()
        }
        "fill" -> {
            println("Write how many ml of water do you want to add:")
            val waterToAdd = readLine()!!.toInt()
            println("Write how many ml of milk do you want to add:")
            val milkToAdd = readLine()!!.toInt()
            println("Write how many grams of coffee beans do you want to add:")
            val coffeeToAdd = readLine()!!.toInt()
            println("Write how many disposable cups of coffee do you want to add:")
            val cupsToAdd = readLine()!!.toInt()
            
            coffeeMachine.fill(waterToAdd, milkToAdd, coffeeToAdd, cupsToAdd)
        }
        "remaining" -> {
            coffeeMachine.checkStatus()
        }
        }
    } while (!(action == "exit"))
    
}
