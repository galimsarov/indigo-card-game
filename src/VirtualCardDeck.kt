val DECK = mutableListOf<Card>()

fun resetDeck() {
    DECK.clear()
    for (suit in Suit.values()) {
        for (rank in Rank.values()) {
            DECK.add(Card(rank, suit))
        }
    }
}

fun shuffleDeck() {
    DECK.shuffle()
}

fun getCards(cardsNumber: Int): List<Card> {
    val result = mutableListOf<Card>()
    repeat(cardsNumber) {
        val card = DECK.removeAt(0)
        result.add(card)
    }
    return result
}

fun printCards(cards: List<Card>): String {
    var result = ""
    for (card in cards) {
        result += "$card "
    }
    return result.substring(0, result.length - 1)
}

fun printStatus() {
    println(
        "\n" +
            if (CARDS_ON_TABLE.size == 0) {
                "No cards on the table"
            } else {
                "${CARDS_ON_TABLE.size} cards on the table, and the top card is ${CARDS_ON_TABLE.last()}"
            }
    )
}

fun printHandCards(playerCards: List<Card>, isPlayer: Boolean): String {
    var result = ""
    for (i in playerCards.indices) {
        result += if (isPlayer) {
            "${i + 1})"
        } else {
            ""
        } + "${playerCards[i]} "
    }
    return result.substring(0, result.length - 1)
}

fun isGameOver() = DECK.isEmpty() && PLAYER_CARDS.isEmpty() && COMPUTER_CARDS.isEmpty()