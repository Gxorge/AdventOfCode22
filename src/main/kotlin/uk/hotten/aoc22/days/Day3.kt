package uk.hotten.aoc22.days

import uk.hotten.aoc22.AOCDay

class Day3: AOCDay("day3.txt") {

    val values: CharArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()

    override fun part1() {
        var totalPriority = 0
        for (line in getInput()) {
            val half = line.length / 2
            val split = arrayOf(line.substring(0, half), line.substring(half))

            val firstSplitArray = split[0].toCharArray()
            for (char in split[1]) {
                if (firstSplitArray.contains(char)) {
                    val priority = getPriority(char)
                    totalPriority += priority
                    println("Similar char is $char, $priority")
                    break
                }
            }
        }
        println("Total priority is $totalPriority")
    }

    override fun part2() {
        var totalPriority = 0
        var currentLine = 1;
        var lineArrays = mutableListOf<String>()
        var pleaseBreak = false
        for (line in getInput()) {
            if (currentLine == 3) {
                for (lineOneChar in lineArrays[0]) {
                    for (lineTwoChar in lineArrays[1]) {
                        for (lineThreeChar in line) {
                            if (lineOneChar == lineThreeChar && lineTwoChar == lineThreeChar) {
                                val priority = getPriority(lineThreeChar)
                                totalPriority += priority
                                println("The similar char is $lineThreeChar with a priority of $priority")
                                pleaseBreak = true
                                break
                            }
                        }
                        if (pleaseBreak)
                            break
                    }
                    if (pleaseBreak)
                        break
                }
                currentLine = 1
                lineArrays = mutableListOf()
                pleaseBreak = false
                continue
            }

            lineArrays.add(line)
            currentLine++
        }
        println("Total priority is $totalPriority")
    }

    private fun getPriority(char: Char): Int {
        return values.indexOf(char) + 1;
    }
}