class Spellbook {
    val spells1 = listOf("aaaa", "bbb")

    @JvmField
    val spells2 = listOf("aaaa", "bbb")

    companion object {
        @JvmField
        val MAX_SPELL_COUNT = 10
        @JvmStatic
        fun getSpellbookGreeting() = println("companion object")
    }
}