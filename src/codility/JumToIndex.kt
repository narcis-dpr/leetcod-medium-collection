package codility

fun main() {
val inputOne = intArrayOf(2,3,4,5,12,5,67,-1,2,4,5,-1,6)
val firstIndex = inputOne.indexOf(-1)
    println(jumpToIndex(inputOne))
}

fun jumpToIndex(nums: IntArray): Int {
    if (nums.size == 1) return 0
    val firstIndex = nums.indexOf(-1)
    val newNums = nums.sliceArray(0..firstIndex)
    var jump = 1
    var cur = newNums[0]
    var next = newNums[0]
    for (i in 1 until newNums.size - 1) {
        next = next.coerceAtLeast(newNums[i] + i)
        if (i == cur){
            ++jump
            cur = next
        }
    }
    return jump
}