import java.util.*

fun main() {
    println("Hello world!")
    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
    val nums1 = intArrayOf(0, 0, 0, 0)
    if (nums.size < 3) {
        println("not possible")
    } else {
        println(threeSumThreePointer(nums))
    }
}

    fun threeSum(nums: IntArray): List<List<Int>>? {
        val numLength = nums.size
        val result: MutableSet<List<Int>> = HashSet()
        for (i in 0 until numLength) {
            for (j in i + 1 until numLength) {
                for (k in j + 1 until numLength) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        val temp: List<Int> = ArrayList(listOf(nums[i], nums[j], nums[k]))
                        temp.sorted()
                        result.add(temp)
                    }
                }
            }
        }
        return ArrayList(result)
    }


fun threeSumHashSet(nums: IntArray): List<List<Int>>? {
    val numLength = nums.size
    val result: MutableSet<List<Int>> = HashSet()
    for (i in 0 until numLength) {
        val potentialCandidates: MutableSet<Int> = HashSet()
        for (j in i + 1 until numLength) {
            val lostValue = -(nums[i] + nums[j])
            if (potentialCandidates.contains(lostValue)) {
                val temp: List<Int> = ArrayList(Arrays.asList(nums[i], nums[j], lostValue))
                Collections.sort(temp)
                result.add(temp)
            }
            potentialCandidates.add(nums[j])
        }
    }
    return ArrayList(result)
}

fun threeSumThreePointer(nums: IntArray): List<List<Int>>? {
    val numLength = nums.size
    val result: MutableList<List<Int>> = ArrayList()
    Arrays.sort(nums)
    for (i in 0 until numLength) {
        if (i > 0 && nums[i] == nums[i - 1]) continue
        var j = i + 1
        var k = numLength - 1
        while (j < k) {
            val sum = nums[i] + nums[j] + nums[k]
            if (sum < 0) {
                j++
            } else if (sum > 0) {
                k--
            } else {
                val newItems: List<Int> = ArrayList(Arrays.asList(nums[i], nums[j], nums[k]))
                result.add(newItems)
                j++
                k--
                while (j < k && nums[j] == nums[j - 1]) j++
                while (j < k && nums[k] == nums[k + 1]) k--
            }
        }
    }
    return ArrayList(result)
}