package uk.hotten.aoc22.days

import uk.hotten.aoc22.AOCDay

class Day1: AOCDay("day1.txt") {

    val elfs = mutableMapOf<Int, Int>()

    init {
        var currentElf: Int = 1;
        var currentValue: Int = 0;
        for (line in getInput()) {
            if (line == "" || line == " ") {
                elfs[currentElf] = currentValue;
                println("Elf $currentElf has got value $currentValue")
                currentValue = 0;
                currentElf++;
                continue;
            }

            currentValue += line.toInt();
        }
    }

    override fun part1() {
        var highestElf = 0;
        var highestVal = 0;
        for (entry in elfs.entries.iterator()) {
            if (entry.value > highestVal) {
                highestElf = entry.key;
                highestVal = entry.value;
            }
        }

        println("The elf with the most calories is Elf #$highestElf with $highestVal calories.")
    }

    override fun part2() {
        val topElfs = mutableListOf<Int>()
        var totalCals: Int = 0

        for (i in 1..3) {
            var highestElf = 0
            var highestVal = 0
            for (entry in elfs.entries.iterator()) {
                if (topElfs.contains(entry.key))
                    continue
                if (entry.value > highestVal) {
                    highestElf = entry.key
                    highestVal = entry.value
                }
            }

            totalCals += highestVal
            topElfs.add(highestElf)
        }

        println("Total calories for top 3 elfs ${topElfs.toString()} is $totalCals calories.")
    }
}