package codility

fun main() {
    val nums1 = intArrayOf(1,2,2,1)
    val nums2 = intArrayOf(2,2)

    val nums12 = intArrayOf(4,9,5)
    val nums22 = intArrayOf(9,4,9,8,4)

    println(intersection(nums12, nums22).joinToString())
}
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val numsOneSet = nums1.toSet()
    val numsTwoSet = nums2.toSet()
    val result = mutableListOf<Int>()
    numsOneSet.forEach {
        if (numsTwoSet.contains(it))
            result.add(it)
    }

    return result.toIntArray()
}