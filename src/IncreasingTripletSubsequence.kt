fun main() {
    val inputOne = intArrayOf(1, 2, 3, 4, 5)
    val inputTwo = intArrayOf(5, 4, 3, 2, 1)
    val inputThree = intArrayOf(2, 4, -2, -3)
    val inputFour = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
    val inputFive = intArrayOf(2, 1, 5, 0, 4, 6)
    println(tripletSubsequence(inputOne))
}

private fun tripletSubsequenceBruteForce(sequence: IntArray): Boolean {
    val sequenceSize = sequence.size
    val result = mutableListOf<Int>()
    mainLoop@ for (i in 0 until sequenceSize) {
        for (j in i + 1 until sequenceSize) {
            for (k in j + 1 until sequenceSize) {
                if ((sequence[i] < sequence[j]) && (sequence[j] < sequence[k])) {
                    result.add(sequence[i])
                    result.add(sequence[j])
                    result.add(sequence[k])
                    break@mainLoop

                }
            }
        }
    }
    println(" the list is ${result.toString()}")
    return (result.size == 3)
}
private fun tripletSubsequence(nums: IntArray): Boolean {
    val seqSize = nums.size
    var left = Integer.MAX_VALUE
    var middle = Integer.MAX_VALUE
    for (i in 0 until seqSize) {
        val right = nums[i]
        if (right < left) {
            left = right
        } else if (right < middle && right > left) {
            middle = right
        } else if (right > middle && middle > left) return true
    }
    return false
}

/*
if (orientedList.size >= 3) {
    if (orientedList[2] > orientedList[1]) {
        if (orientedList[1] > orientedList[0]) {
            result.add(orientedList[0])
            result.add(orientedList[1])
            result.add(orientedList[2])
            break@mainLoop
        }
        if (orientedList[1] < orientedList[0])
            orientedList.removeAt(0)
    } else if (orientedList[2] < orientedList[1]) {
        if (orientedList[2] > orientedList[0]){
            orientedList.removeAt(1)
        }else{
            orientedList.removeAt(2)
        }

    }
} else {
    orientedList.add(sequence[i])
} */