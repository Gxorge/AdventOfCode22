package uk.hotten.aoc22.days

import uk.hotten.aoc22.AOCDay

class Day4: AOCDay("day4.txt") {

    override fun part1() {
        var amountOfOverlaps = 0;
        for (line in getInput()) {
            // Elf 1
            val elfOneTotal = line.split(',')[0]
            val elfOneMin = elfOneTotal.split('-')[0].toInt()
            val elfOneMax = elfOneTotal.split('-')[1].toInt()

            // Elf 2
            val elfTwoTotal = line.split(',')[1]
            val elfTwoMin = elfTwoTotal.split('-')[0].toInt()
            val elfTwoMax = elfTwoTotal.split('-')[1].toInt()

            // Compare for total overlap
            val elfOneRange = getNumbersInBetween(elfOneMin, elfOneMax)
            val elfTwoRange = getNumbersInBetween(elfTwoMin, elfTwoMax)

            var elfOneMatch = true;
            var elfTwoMatch = true;

            for (item in elfOneRange) {
                if (!elfTwoRange.contains(item))
                    elfOneMatch = false;
            }

            for (item in elfTwoRange) {
                if (!elfOneRange.contains(item))
                    elfTwoMatch = false;
            }

            println("Elf one: $elfOneMin to $elfOneMax, elf two: $elfTwoMin to $elfTwoMax")
            if (elfOneMatch || elfTwoMatch) {
                println("Overlap.")
                amountOfOverlaps++
            }
        }

        println("Total overlap is $amountOfOverlaps")
    }

    override fun part2() {
        var amountOfOverlaps = 0;
        for (line in getInput()) {
            // Elf 1
            val elfOneTotal = line.split(',')[0]
            val elfOneMin = elfOneTotal.split('-')[0].toInt()
            val elfOneMax = elfOneTotal.split('-')[1].toInt()

            // Elf 2
            val elfTwoTotal = line.split(',')[1]
            val elfTwoMin = elfTwoTotal.split('-')[0].toInt()
            val elfTwoMax = elfTwoTotal.split('-')[1].toInt()

            // Compare for any overlap
            val elfOneRange = getNumbersInBetween(elfOneMin, elfOneMax)
            val elfTwoRange = getNumbersInBetween(elfTwoMin, elfTwoMax)

            var elfOneMatch = false;
            var elfTwoMatch = false;

            for (item in elfOneRange) {
                if (elfTwoRange.contains(item))
                    elfOneMatch = true;
            }

            for (item in elfTwoRange) {
                if (elfOneRange.contains(item))
                    elfTwoMatch = true;
            }

            println("Elf one: $elfOneMin to $elfOneMax, elf two: $elfTwoMin to $elfTwoMax")
            if (elfOneMatch || elfTwoMatch) {
                println("Overlap.")
                amountOfOverlaps++
            }
        }

        println("Total overlap is $amountOfOverlaps")
    }

    private fun getNumbersInBetween(min: Int, max: Int): List<Int> {
        val list = mutableListOf<Int>()

        for (current in min..max) {
            list.add(current)
        }

        return list;
    }

}