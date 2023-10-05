package modified


fun printPairs(arr: IntArray, n: Int, sum: Int) {
    // Store counts of all elements in map m
    val hashMap = HashMap<Int, Int>()
    val result : MutableList<List<Int>> = mutableListOf()
    for (i in 0 until n) {

        // Search if a pair can be formed with
        // arr[i].
        val rem = sum - arr[i]
        if (hashMap.containsKey(rem)) {
            val count = hashMap[rem]!!
            val list = mutableListOf<Int>()
            for (j in 0 until count) {
                list.add(rem)
                list.add(arr[i])

            }
            result.add(list)
        }
        if (hashMap.containsKey(arr[i])) {
            hashMap[arr[i]] = hashMap[arr[i]]!! + 1
        } else {
            hashMap[arr[i]] = 1
        }
    }
    println(" the result is ${result.toString()}")
}

// Driver code
fun main() {
    val arr = intArrayOf(1, 5, 7, -1, 5)
    val n = arr.size
    val sum = 6
    printPairs(arr, n, sum)
}