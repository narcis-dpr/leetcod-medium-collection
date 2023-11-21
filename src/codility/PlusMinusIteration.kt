package codility

const val PLUS = "+"
const val MINUS = "-"
fun main() {
    println(plusMinusIteration(10))
    println(generateAlternatingString(0))
}
 fun plusMinusIteration(size: Int): String {
     val stringBuilder = StringBuilder()
     for (i in 0 until  size) {
         if (i%2==0)
             stringBuilder.append(PLUS)
         else
             stringBuilder.append(MINUS)
     }
     println(stringBuilder.length)
     return stringBuilder.toString()
}

fun generateAlternatingString(size: Int): String {
    val stringBuilder = StringBuilder()
    stringBuilder.append("+-".repeat(size/2))
    if (size%2==1)
        stringBuilder.append("+")

    return stringBuilder.toString()
}