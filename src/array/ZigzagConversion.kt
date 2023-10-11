package array

fun main() {
    val inputOne = "PAYPALISHIRING"
    println(convert(inputOne, 3))
}

fun convert(s: String, numRows: Int): String {
    if (numRows == 1) return s
    val rows = arrayOfNulls<StringBuilder>(numRows)
    for (i in 0 until numRows) {
        rows[i] = StringBuilder()
    }
    var currRow = 0
    var goingDown = false
    for (c in s.toCharArray()) {
        rows[currRow]!!.append(c)
        if (currRow == 0 || currRow == numRows - 1) {
            goingDown = !goingDown
        }
        currRow += if (goingDown) 1 else -1
    }
    val result = StringBuilder()
    for (row in rows) {
        result.append(row)
    }
    return result.toString()
}