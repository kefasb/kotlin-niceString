package nicestring

fun String.isNice(): Boolean {
    fun doesNotHaveBadWords(): Boolean {
        return !(contains("bu") || contains("ba") || contains("be"))
    }

    fun hasAtLeastThreeVowels(): Boolean {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        return count { vowels.contains(it) } >= 3
    }

    fun hasDoubledLetters(): Boolean {
        return zipWithNext().any { it.first == it.second }
    }

    return listOf(
        doesNotHaveBadWords(), hasAtLeastThreeVowels(), hasDoubledLetters()
    )
        .count { it == true } >= 2
}


