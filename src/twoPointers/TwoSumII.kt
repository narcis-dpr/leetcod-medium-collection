package twoPointers

fun main() {
    val inputOne = intArrayOf(2,7,11,15)
    val targetOne = 9

    val inputTwo = intArrayOf(2,3,4)
    val targetTwo = 6

    val inputThree = intArrayOf(-1,0)
    val targetThree = -1

    println(twoSum(inputThree, targetThree).joinToString())
}
fun twoSum(numbers: IntArray, target: Int): IntArray {
    val result = IntArray(2)
    var left = 0
    var right = numbers.size - 1
    while (left < right) {
        val sum = numbers[left] + numbers[right]
        if (sum == target) {
            result[0] = left+1
            result[1] = right+1
            break
        } else if (sum < target) {
            left++
        } else {
            right--
        }
    }
    return result
}