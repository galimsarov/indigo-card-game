var PLAYER_SCORE = 0
var COMPUTER_SCORE = 0
var PLAYER_CARDS_COUNT = 0
var COMPUTER_CARDS_COUNT = 0
var PLAYER_WON_LAST = true

fun checkWinCards(isPlayer: Boolean) {
    if (CARDS_ON_TABLE.size > 1) {
        if (
            CARDS_ON_TABLE.last().suit == CARDS_ON_TABLE[CARDS_ON_TABLE.lastIndex - 1].suit ||
            CARDS_ON_TABLE.last().rank == CARDS_ON_TABLE[CARDS_ON_TABLE.lastIndex - 1].rank
        ) {
            println(
                if (isPlayer) {
                    "Player"
                } else {
                    "Computer"
                } + " wins cards"
            )
            if (isPlayer) {
                PLAYER_SCORE += getCardsScore()
                PLAYER_CARDS_COUNT += CARDS_ON_TABLE.size
                PLAYER_WON_LAST = true
            } else {
                COMPUTER_SCORE += getCardsScore()
                COMPUTER_CARDS_COUNT += CARDS_ON_TABLE.size
                PLAYER_WON_LAST = false
            }
            println("Score: Player $PLAYER_SCORE - Computer $COMPUTER_SCORE")
            println("Cards: Player $PLAYER_CARDS_COUNT - Computer $COMPUTER_CARDS_COUNT")
            CARDS_ON_TABLE.clear()
        }
    }
}

fun collectRemainingCards() {
    if (PLAYER_CARDS_COUNT == 0 && COMPUTER_CARDS_COUNT == 0) {
        if (IS_USER_FIRST) {
            PLAYER_SCORE += getCardsScore()
            PLAYER_CARDS_COUNT += CARDS_ON_TABLE.size
        } else {
            COMPUTER_SCORE += getCardsScore()
            COMPUTER_CARDS_COUNT += CARDS_ON_TABLE.size
        }
    } else {
        if (PLAYER_WON_LAST) {
            PLAYER_SCORE += getCardsScore()
            PLAYER_CARDS_COUNT += CARDS_ON_TABLE.size
        } else {
            COMPUTER_SCORE += getCardsScore()
            COMPUTER_CARDS_COUNT += CARDS_ON_TABLE.size
        }
    }
    when {
        PLAYER_CARDS_COUNT > COMPUTER_CARDS_COUNT -> PLAYER_SCORE += 3
        PLAYER_CARDS_COUNT < COMPUTER_CARDS_COUNT -> COMPUTER_SCORE += 3
        else -> {
            if (IS_USER_FIRST) {
                PLAYER_SCORE += 3
            } else {
                COMPUTER_SCORE += 3
            }
        }
    }
    println("Score: Player $PLAYER_SCORE - Computer $COMPUTER_SCORE")
    println("Cards: Player $PLAYER_CARDS_COUNT - Computer $COMPUTER_CARDS_COUNT")
}

private fun getCardsScore(): Int {
    var result = 0
    for (card in CARDS_ON_TABLE) {
        if (card.hasScore()) {
            result++
        }
    }
    return result
}