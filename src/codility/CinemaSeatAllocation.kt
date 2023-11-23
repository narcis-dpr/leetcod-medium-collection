package codility


fun main() {
        val inputOne = arrayOf(
                intArrayOf(1,2),
                intArrayOf(1,3),
                intArrayOf(1,8),
                intArrayOf(2,6),
                intArrayOf(3,1),
                intArrayOf(3,10)
        )
        println(maxNumberOfFamilies(3,inputOne))
}

fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
        var ans = 0
        val rowToSeats: MutableMap<Int, Int> = HashMap()

        for (reservedSeat in reservedSeats) {
                val row = reservedSeat[0]
                val seat = reservedSeat[1]
                rowToSeats[row] = rowToSeats.getOrDefault(row, 0) or (1 shl seat - 1)
        }

        for (seats in rowToSeats.values) {
                if (seats and 510 == 0) // Can fit 2 four-person groups.
                        ans += 2 else if (// Left not occupied.
                // Mid not occupied.
                        seats and 480 == 0 || seats and 120 == 0 || seats and 30 == 0) // Right not occupied.
                // Can fit 1 four-person group.
                        ans += 1
        }
        // Any empty rows can fit 2 four-person groups.

        // Any empty rows can fit 2 four-person groups.
        return ans + (n - rowToSeats.size) * 2
}