data class Card(val rank: Rank, val suit: Suit) {
    fun hasScore() =
        rank == Rank.ACE || rank == Rank.TEN || rank == Rank.JACK || rank == Rank.QUEEN || rank == Rank.KING

    override fun toString() = rank.rank + suit.symbol
}
