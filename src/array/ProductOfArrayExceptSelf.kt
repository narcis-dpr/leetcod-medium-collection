package array

fun main() {
    val inputOne = intArrayOf(1,2,3,4)
    val inputTwo = intArrayOf(-1,1,0,-3,3)
    println(productExceptSelf(inputTwo).joinToString())
}
fun productExceptSelf(nums: IntArray): IntArray {
    val size = nums.size
    val prefix = IntArray(size)
    val postfix = IntArray(size)
    val result = IntArray(size)
    prefix[0] = nums[0]
    for (i in 1 until size) {
        prefix[i] = prefix[i-1] * nums [i-1]
    }

    postfix[size-1] = 1
    for (i in size-2 downTo 0) {
        postfix[i] = postfix[i+1] * nums[i+1]
    }
    for (i in nums.indices) {
        result[i] = prefix[i]*postfix[i]
    }
    return result
}

fun productExceptSelfLeetCode(nums: IntArray): IntArray {
    val result = IntArray(nums.size) { 1 }

    var prod = 1
    for (i in 0 until nums.size) {
        result[i] = prod
        prod *= nums[i]
    }

    prod = 1
    for (i in nums.size-1 downTo 0) {
        result[i] *= prod
        prod *= nums[i]
    }
    return result
}