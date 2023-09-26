fun setMatrixZerosBruteForce(matrix: Array<IntArray>): Array<IntArray>? {
    val numRows = matrix.size
    val numColumns = matrix[0].size
    val markedRows: MutableSet<Int> = HashSet()
    val markedColumns: MutableSet<Int> = HashSet()
    for (i in 0 until numRows) {
        for (j in 0 until numColumns) {
            if (matrix[i][j] == 0) {
                markedRows.add(i)
                markedColumns.add(j)
            }
        }
    }
    for (element in markedRows) {
        for (i in 0 until numColumns) {
            matrix[element][i] = 0
        }
    }
    for (element in markedColumns) {
        for (i in 0 until numRows) {
            matrix[i][element] = 0
        }
    }
    return matrix
}

fun setZeroesOptimal(matrix: Array<IntArray>) {
    val r = matrix.size
    val c = matrix[0].size
    val rows = IntArray(r)
    val cols = IntArray(c)
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (matrix[i][j] == 0) {
                rows[i] = 1
                cols[j] = 1
            }
        }
    }
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (rows[i] == 1 || cols[j] == 1) {
                matrix[i][j] = 0
            }
        }
    }
}