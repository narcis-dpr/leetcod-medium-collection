package array

fun main() {
    val inputOne = intArrayOf(1,2,3,4)
    println(productExceptSelf(inputOne))
}
fun productExceptSelf(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    for (i in nums.indices) {
        val list = nums.toMutableList()
        list.removeAt(i)
        var localProduct = 1
        list.forEach { localProduct *= it }
        result[i] = localProduct
    }
    return result
}