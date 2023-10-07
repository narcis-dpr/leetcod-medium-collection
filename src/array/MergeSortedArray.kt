package array

fun main() {
    val nums1 = intArrayOf(1,2,3,0,0,0)
    val nums2 = intArrayOf(2,5,6)
    merge(nums1, 3, nums2, 3)
}
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var numsOneIndex = 0
    var numsTwoIndex = 0
    val result = mutableListOf<Int>()
    for (i in 0 until n+m) {
        if (numsOneIndex < m && numsTwoIndex < n) {
            if (nums1[numsOneIndex] <= nums2[numsTwoIndex]) {
                result.add(nums1[numsOneIndex])
                numsOneIndex++
            } else {
                result.add(nums2[numsTwoIndex])
                numsTwoIndex++
            }
        } else if (numsOneIndex < m) {
                for (j in numsOneIndex until  m)
                    result.add(nums1[j])

            break
        } else if (numsTwoIndex < n) {
            for (j in numsTwoIndex until  n)
                result.add(nums2[j])

            break
        }
    }
    println(nums1.size)
    for (i in 0 until n+m) {
        nums1[i] = result[i]
    }
}

fun mergeFirstAttempt(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var j = 0
    var firstItem = nums2[j]
    val result = mutableListOf<Int>()
    for (i in 0 until n+m) {
        if (i < n) {
            result.add(nums1[i])
            if (i+1 < m)
            if (nums1[i+1] < firstItem) {
                result.add(firstItem)
                if (j+1 < n)
                firstItem = nums2[j+1]
                j++
            }
        } else if (j+1 < n) {
            for (k in j+1 until n)
                result.add(nums2[k])
            break
        }
    }
    result.forEach {i ->
        nums1[i] = result[i]
    }
    println(result)
}