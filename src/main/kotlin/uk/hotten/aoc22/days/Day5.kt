package uk.hotten.aoc22.days

import uk.hotten.aoc22.AOCDay

class Day5: AOCDay("day5.txt") {

    val numberOfStacks = 9;

    override fun part1() {
        val stacks = mutableMapOf<Int, MutableList<Char>>()

        // Assign empty crates to each stack
        for (current in 1..numberOfStacks) {
            stacks[current] = mutableListOf()
        }

        // Assign crates to stacks
        for (line in getInput()) {
            if (line == "") {
                break
            }

            var currentPosition = 1;
            for (current in 1..numberOfStacks) {
                if (line.length < currentPosition || line[currentPosition] == ' ' || line[currentPosition].isDigit()) {
                    currentPosition += 4
                    continue
                }

                val crate = line[currentPosition]
                stacks[current]?.add(crate)
                currentPosition += 4
            }
        }

        // Process instructions
        var blockContinue = true;
        for (line in getInput()) {
            if (blockContinue && line == "") {
                blockContinue = false
                continue
            } else if (blockContinue) {
                continue
            }

            val lineSplit = line.split(' ')
            val amountToMove: Int = lineSplit[1].toInt()
            val fromStack: Int = lineSplit[3].toInt()
            val toStack: Int = lineSplit[5].toInt()

            for (currentMove in 1..amountToMove) {
                val movingCrate = stacks[fromStack]?.get(0)!!
                stacks[fromStack]?.removeAt(0)
                stacks[toStack]?.add(0, movingCrate)
            }
        }

        println(stacks)
        print("Top stacks: ")
        for (crate in stacks.entries) {
            print("${crate.value[0]}")
        }
    }

    override fun part2() {
        val stacks = mutableMapOf<Int, MutableList<Char>>()

        // Assign empty crates to each stack
        for (current in 1..numberOfStacks) {
            stacks[current] = mutableListOf()
        }

        // Assign crates to stacks
        for (line in getInput()) {
            if (line == "") {
                break
            }

            var currentPosition = 1;
            for (current in 1..numberOfStacks) {
                if (line.length < currentPosition || line[currentPosition] == ' ' || line[currentPosition].isDigit()) {
                    currentPosition += 4
                    continue
                }

                val crate = line[currentPosition]
                stacks[current]?.add(crate)
                currentPosition += 4
            }
        }

        // Process instructions
        var blockContinue = true;
        for (line in getInput()) {
            if (blockContinue && line == "") {
                blockContinue = false
                continue
            } else if (blockContinue) {
                continue
            }

            val lineSplit = line.split(' ')
            val amountToMove: Int = lineSplit[1].toInt()
            val fromStack: Int = lineSplit[3].toInt()
            val toStack: Int = lineSplit[5].toInt()

            for (currentMove in amountToMove downTo 1) {
                val movingCrate = stacks[fromStack]?.get(currentMove-1)!!
                println("$currentMove getting $movingCrate")
                stacks[fromStack]?.removeAt(currentMove-1)
                stacks[toStack]?.add(0, movingCrate)
            }
        }

        println(stacks)
        print("Top stacks: ")
        for (crate in stacks.entries) {
            print("${crate.value[0]}")
        }
    }

}