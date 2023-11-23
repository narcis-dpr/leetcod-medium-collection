package task

import kotlin.math.abs

fun main() {
    val A1 = intArrayOf(10, 200, 100, 80)
    val B1 = intArrayOf(50, 100, 100, 90)
    println(solution(A1, B1, 100, 70))
}

fun solution(A: IntArray, B: IntArray, X: Int, Y: Int): Int {
    for (i in A.indices) {
        val diffX = abs(A[i] - X)
        val diffY = abs(B[i] - Y)

        println(" the dif is $diffX  $diffY")
        if (diffX <= 20 && diffY <= 20) {
            return i
        }
    }
    return -1 // Return -1 if no pair is found
}