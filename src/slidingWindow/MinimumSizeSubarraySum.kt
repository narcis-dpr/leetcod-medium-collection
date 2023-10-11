package slidingWindow



fun main() {
    val inputOne = intArrayOf(2,3,1,2,4,3)
    val targetOne = 7
    println(minSubArrayLen(targetOne, inputOne))
}
fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var i = 0 // left pointer
    var j = 0 // right pointer
    var minLength = Int.MAX_VALUE
    var sum = 0
    while (j < nums.size) {
        sum += nums[j]
        while (sum >= target) {
            minLength = Math.min(minLength, j - i + 1)
            sum -= nums[i]
            i++
        }
        j++
    }

    return if (minLength == Int.MAX_VALUE) 0 else minLength
}