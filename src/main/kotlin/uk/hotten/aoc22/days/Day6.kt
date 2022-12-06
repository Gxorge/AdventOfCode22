package uk.hotten.aoc22.days

import uk.hotten.aoc22.AOCDay

class Day6: AOCDay("day6.txt") {

    override fun part1() {
        val line = getInput()[0]

        val lastFour = mutableListOf<Char>()
        var currentChar = 1
        for (charInt in 0..line.length) {
            val char = line[charInt]
            println("$char current array is $lastFour at $currentChar")
            if (currentChar == 5) {
                if (lastFour.size == lastFour.distinct().count()) {
                    println("Is at $charInt")
                    break
                }

                lastFour.removeAt(0)
                lastFour.add(char)
                continue
            }

            lastFour.add(char)
            currentChar++
        }
    }

    override fun part2() {
        val line = getInput()[0]

        val lastFour = mutableListOf<Char>()
        var currentChar = 1
        for (charInt in 0..line.length) {
            val char = line[charInt]
            println("$char current array is $lastFour at $currentChar")
            if (currentChar == 15) {
                if (lastFour.size == lastFour.distinct().count()) {
                    println("Is at $charInt")
                    break
                }

                lastFour.removeAt(0)
                lastFour.add(char)
                continue
            }

            lastFour.add(char)
            currentChar++
        }
    }

}