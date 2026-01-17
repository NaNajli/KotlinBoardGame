//function that flip the coin when press enter
fun coin(): String {
    val coin = listOf("Tails", "Heads")
    val input = readln()
    val choose = coin.random()
    println(input)
    return choose // return a string
}

// This function indicates the position of the player
fun move(position: Int) {

    for (x in 1..10) {
        when (x == position) {
            true -> print("🧑‍🦳")
            false -> print("⏹️")
        }
    }
}

// class board
data class Board(
    val squared: List<Int>,
    var wonder: List <Boolean>,
)


// Data class to be able to save data , information about the player
data class Player (
    val id: Int,
    val name: String ,
    var turn : Boolean,
    var position: Int,
    var gift : Int ,
    var end : Boolean,
)


fun main() {    // To start game
    println("WELCOME TO THE BOARD GAME")
    // game participants
    val player = Player(1, "Rachel", true, 0, 0, false)
    val player2 = Player(2, "Chandler", true, 0, 0, false)

    // Squared of the board and places where are the gift
    //val board = Board(squared = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), wonder = listOf(false, true, false, false, true, false))

    var finish = true
    val players = listOf(player, player2) // list to be able to play two players

    //How the movement will be  during the game and how gamers position will change
    while (finish && !player.end) {
        for (currentPlayer in players) {
            if (currentPlayer.turn) {
                println()
                println("Is the turn of ${currentPlayer.name}")
                print(" Flit the coin")
                val flip = coin()
                println(flip)
                when (flip) {
                    "Tails" -> {
                        currentPlayer.position += 5
                    }

                    "Heads" -> {
                        println(" Forward (F) or backward (B)")
                        val result = readln()
                        when (result.lowercase()) {
                            "F" -> currentPlayer.position += 1
                            "B" -> currentPlayer.position -= 1
                        }
                        currentPlayer.turn = false
                        }
                    }
                move(currentPlayer.position)
                if (currentPlayer.position >= 10 ) {
                    finish = false
                    currentPlayer.end
                    print(" ${currentPlayer.name}You Won!! ")

                }

            }

        }

    }

}

