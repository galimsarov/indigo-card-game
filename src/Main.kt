var IS_USER_FIRST = false

fun main() {
    println("Indigo Card Game")
    IS_USER_FIRST = getUserFirst()
    getInitialCards()
    if (IS_USER_FIRST) {
        playerTurn()
    }
    while (true) {
        computerTurn()
        if (isGameOver()) {
            break
        }
        playerTurn()
        if (isGameOver()) {
            break
        }
    }
    printStatus()
    collectRemainingCards()
    println("Game Over")
}