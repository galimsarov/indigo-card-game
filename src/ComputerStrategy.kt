fun getCardIndexToPlay(): Int {
    if (COMPUTER_CARDS.size == 1) {
        return 0
    }
    val candidates = getCandidates()
    if (candidates.size == 1) {
        return COMPUTER_CARDS.indexOf(candidates[0])
    }
    // 3-й и 4-й пункты
    if (CARDS_ON_TABLE.size == 0 || (CARDS_ON_TABLE.size > 0 && candidates.isEmpty())) {
        val sameSuitCards = getSameSuitCards(COMPUTER_CARDS)
        if (sameSuitCards.isNotEmpty()) {
            return COMPUTER_CARDS.indexOf(sameSuitCards[0])
        }
        val sameRankCards = getSameRankCards(COMPUTER_CARDS)
        if (sameRankCards.isNotEmpty()) {
            return COMPUTER_CARDS.indexOf(sameRankCards[0])
        }
        return 0
    }
    val sameSuitCandidates = getSameSuitCards(candidates)
    if (sameSuitCandidates.size > 1) {
        return COMPUTER_CARDS.indexOf(sameSuitCandidates[0])
    }
    val sameRankCandidates = getSameRankCards(candidates)
    if (sameRankCandidates.size > 1) {
        return COMPUTER_CARDS.indexOf(sameRankCandidates[0])
    }
    return COMPUTER_CARDS.indexOf(candidates[0])
}

private fun getCandidates(): List<Card> {
    val candidates = mutableListOf<Card>()
    if (CARDS_ON_TABLE.size > 0) {
        for (computerCard in COMPUTER_CARDS) {
            if (computerCard.rank == CARDS_ON_TABLE.last().rank || computerCard.suit == CARDS_ON_TABLE.last().suit) {
                candidates.add(computerCard)
            }
        }
    }
    return candidates
}

private fun getSameSuitCards(candidates: List<Card>): List<Card> {
    val sameSuitCards = mutableListOf<Card>()
    for (i in candidates.indices) {
        for (j in (i + 1)..candidates.lastIndex) {
            if (candidates[i].suit == candidates[j].suit) {
                if (!sameSuitCards.contains(candidates[i])) {
                    sameSuitCards.add(candidates[i])
                }
                if (!sameSuitCards.contains(candidates[j])) {
                    sameSuitCards.add(candidates[j])
                }
            }
        }
    }
    return sameSuitCards
}

private fun getSameRankCards(candidates: List<Card>): List<Card> {
    val sameRankCards = mutableListOf<Card>()
    for (i in candidates.indices) {
        for (j in (i + 1)..candidates.lastIndex) {
            if (candidates[i].rank == candidates[j].rank) {
                if (!sameRankCards.contains(candidates[i])) {
                    sameRankCards.add(candidates[i])
                }
                if (!sameRankCards.contains(candidates[j])) {
                    sameRankCards.add(candidates[j])
                }
            }
        }
    }
    return sameRankCards
}