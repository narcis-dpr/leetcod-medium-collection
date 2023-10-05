package hard


private fun findCombinations(ind: Int,
                             arr: IntArray,
                             target: Int,
                             ans: MutableList<List<Int>>,
                             ds: MutableList<Int>) {
    if (ind == arr.size) {
        if (target == 0) {
            ans.add(ArrayList(ds))
        }
        return
    }
    if (arr[ind] <= target) {
        ds.add(arr[ind])
        findCombinations(ind, arr, target - arr[ind], ans, ds)
        ds.removeAt(ds.size - 1)
    }
    findCombinations(ind + 1, arr, target, ans, ds)
}

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val ans: MutableList<List<Int>> = ArrayList()
    findCombinations(0, candidates, target, ans, ArrayList())
    return ans
}

fun main() {
    val arr = intArrayOf(2, 3, 6, 7)
    val target = 7
    val ls: List<List<Int>> = combinationSum(arr, target)
    println("Combinations are: ")
    for (i in ls.indices) {
        for (j in ls[i].indices) {
            print(ls[i][j].toString() + " ")
        }
        println()
    }
}