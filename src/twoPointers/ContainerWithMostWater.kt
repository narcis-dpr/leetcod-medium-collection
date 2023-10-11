package twoPointers

import array.hIndex
import kotlin.math.min

fun main() {
    val inputOne = intArrayOf(1,8,6,2,5,4,8,3,7)
    println(maxArea(inputOne))
}
fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var area = 0
    while (left < right) {
        val localArea = (right-left)* min(height[right], height[left])
        if (localArea > area)
            area = localArea

        if (height[left] < height[right])
            left++
        else
            right--
    }
return area
}