import kotlin.system.exitProcess

val CARDS_ON_TABLE = mutableListOf<Card>()
val PLAYER_CARDS = mutableListOf<Card>()
val COMPUTER_CARDS = mutableListOf<Card>()

fun getUserFirst(): Boolean {
    var result = false
    while (true) {
        println("Play first?")
        when (readln()) {
            "yes" -> {
                result = true
                break
            }
            "no" -> {
                break
            }
        }
    }
    return result
}

fun getInitialCards() {
    val initialCards = 4
    resetDeck()
    shuffleDeck()
    CARDS_ON_TABLE.addAll(getCards(initialCards))
    println("Initial cards on the table: ${printCards(CARDS_ON_TABLE)}")
}

fun playerTurn() {
    val exitProcessStatus = 1
    val initialCards = 6
    printStatus()
    if (PLAYER_CARDS.isEmpty()) {
        PLAYER_CARDS.addAll(getCards(initialCards))
    }
    println("Cards in hand: ${printHandCards(PLAYER_CARDS, true)}")
    var cardToPlay: Int
    while (true) {
        println("Choose a card to play (1-${PLAYER_CARDS.size}):")
        val input = readln()
        try {
            val playerInput = input.toInt()
            if (playerInput in 1..PLAYER_CARDS.size) {
                cardToPlay = playerInput
                break
            }
        } catch (_: Exception) {
            if (input == "exit") {
                println("Game Over")
                exitProcess(exitProcessStatus)
            }
        }
    }
    CARDS_ON_TABLE.add(PLAYER_CARDS[cardToPlay - 1])
    checkWinCards(true)
    PLAYER_CARDS.removeAt(cardToPlay - 1)
}

fun computerTurn() {
    val initialCards = 6
    printStatus()
    if (COMPUTER_CARDS.isEmpty()) {
        COMPUTER_CARDS.addAll(getCards(initialCards))
    }
    println(printHandCards(COMPUTER_CARDS, false))
    val cardIndexToPlay = getCardIndexToPlay()
    println("Computer plays ${COMPUTER_CARDS[cardIndexToPlay]}")
    CARDS_ON_TABLE.add(COMPUTER_CARDS[cardIndexToPlay])
    checkWinCards(false)
    COMPUTER_CARDS.removeAt(cardIndexToPlay)
}