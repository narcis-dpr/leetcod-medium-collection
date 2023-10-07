package array

fun main() {
    val inputOne = intArrayOf(1,1,2)
    val inputTwo = intArrayOf(0,0,1,1,1,2,2,3,3,4)
    println(removeDuplicatesWithHashSet(inputOne))
}

fun removeDuplicates(nums: IntArray): Int {
    val numSize = nums.size
    var lastUniqueIndex = 0
    var numberOfUniques = 0
    for (i in 0 until numSize) {
        if (i+1 != numSize) {
            if (nums[i+1] != nums[lastUniqueIndex]) {
                nums[numberOfUniques+1] = nums[i+1]
                lastUniqueIndex = i + 1
                numberOfUniques++
            }
        }
    }
    return numberOfUniques+1
}
fun removeDuplicatesWithHashSet(nums: IntArray): Int {
    val numsSize = nums.size
    val result = mutableSetOf<Int>()
    for (i in 0 until numsSize) {
        result.add(nums[i])
    }
    println(result)
    val resultSize = result.size
    for (i in 0 until resultSize) {
        nums[i] = result.elementAt(i)
    }
    return resultSize
}