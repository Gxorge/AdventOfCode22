package uk.hotten.aoc22.days

import uk.hotten.aoc22.AOCDay

class DayTwo: AOCDay("day2.txt") {

    /**
     * A - Rock (1)
     * B - Paper (2)
     * C - Scissors (3)
     *
     * X - Rock (1)
     * Y - Paper (2)
     * Z - Scissors (3)
     *
     * Loss is worth 0
     * Draw is worth 3
     * Win is worth 6
     */

    override fun part1() {
        var totalScore: Int = 0;
        for (line in getInput()) {
            val opponent = line[0];
            val response = line[2];

            totalScore += calculate(opponent, response);
        }

        println("Your total score is $totalScore.")
    }

    override fun part2() {
        var totalScore: Int = 0;
        for (line in getInput()) {
            val opponent = line[0];
            val response = line[2];

            var requiredMove: Char = 'F';
            when (response) {
                'X' -> { // Loss
                    when (opponent) {
                        'A' -> requiredMove = 'Z' // Play scissors to lose to rock
                        'B' -> requiredMove = 'X' // Play rock to lose to paper
                        'C' -> requiredMove = 'Y' // Play paper to loose to scissor
                    }
                }
                'Y' -> { // Draw
                    when (opponent) {
                        'A' -> requiredMove = 'X' // Play rock to draw to rock
                        'B' -> requiredMove = 'Y' // Play paper to draw to paper
                        'C' -> requiredMove = 'Z' // Play scissors to draw to scissor
                    }
                }
                'Z' -> { // Win
                    when (opponent) {
                        'A' -> requiredMove = 'Y' // Play paper to win to rock
                        'B' -> requiredMove = 'Z' // Play scissors to win to paper
                        'C' -> requiredMove = 'X' // Play rock to win to scissor
                    }
                }
            }

            totalScore += calculate(opponent, requiredMove)
        }

        println("Your total score is $totalScore.")
    }

    /**
     * opponent: A - rock, B - paper, C - scissors
     * response: X - rock, Y - paper, Z - scissors
     */
    private fun calculate(opponent: Char, response: Char): Int {
        var toReturn: Int = 0;
        when (opponent) {
            'A' -> { // Rock
                when (response) {
                    'X' -> toReturn += (1 + 3) // 1 for rock, 3 for draw
                    'Y' -> toReturn += (2 + 6) // 2 for paper, 6 for win
                    'Z' -> toReturn += (3 + 0) // 3 for scissors, 0 for loss
                }
            }
            'B' -> { // Paper
                when (response) {
                    'X' -> toReturn += (1 + 0) // 1 for rock, 0 for loss
                    'Y' -> toReturn += (2 + 3) // 2 for paper, 3 for draw
                    'Z' -> toReturn += (3 + 6) // 3 for scissors, 6 for win
                }
            }
            'C' -> { // Scissors
                when (response) {
                    'X' -> toReturn += (1 + 6) // 1 for rock, 6 for win
                    'Y' -> toReturn += (2 + 0) // 2 for paper, 0 for loss
                    'Z' -> toReturn += (3 + 3) // 3 for scissors, 3 for draw
                }
            }
        }

        return toReturn;
    }

}