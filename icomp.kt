fun toBinary(decimal: Int): String {
    if (decimal == 0) return "0"
    val sb = StringBuilder()
    var n = decimal
    while (n > 0) {
        sb.insert(0, (n and 1).toString()) // take last bit
        n = n shr 1                        // shift right
    }
    return sb.toString()
}

fun toOctal(decimal: Int): String {
    if (decimal == 0) return "0"
    val sb = StringBuilder()
    var n = decimal
    while (n > 0) {
        sb.insert(0, (n and 7).toString()) // last 3 bits → 0–7
        n = n shr 3
    }
    return sb.toString()
}

fun toHexa(decimal: Int): String {
    if (decimal == 0) return "0"
    val hexChars = "0123456789ABCDEF"
    val sb = StringBuilder()
    var n = decimal
    while (n > 0) {
        val digit = n and 15               // last 4 bits (0–15)
        sb.insert(0, hexChars[digit])
        n = n shr 4
    }
    return sb.toString()
}

fun onesComp(binary: String): String {
    val sb = StringBuilder()
    for (c in binary) {
        sb.append(if (c == '0') '1' else '0')
    }
    return sb.toString()
}

fun twosComp(binary: String): String {
    val sb = StringBuilder(binary)
    var carry = true
    for (i in sb.length - 1 downTo 0) {
        if (carry) {
            if (sb[i] == '0') {
                sb.setCharAt(i, '1')
                carry = false
            } else {
                sb.setCharAt(i, '0')
            }
        }
    }
    return sb.toString()
}

fun main() {
    while (true) {
        print("Please enter the number in base 10: ")
        val decimal = readlnOrNull()?.toIntOrNull() ?: 0

        print("\nEnter the base you wish to convert $decimal to (2, 8, 16): ")
        val toBase = readlnOrNull()?.toIntOrNull() ?: 2

        println()
        when (toBase) {
            2 -> println("Binary: " + toBinary(decimal))
            8 -> println("Octal: " + toOctal(decimal))
            16 -> println("Hex: " + toHexa(decimal))
            else -> println("Unsupported base")
        }

        // show complements in binary
        val bin = toBinary(decimal)
        println("1's complement: ${onesComp(bin)}")
        println("2's complement: ${twosComp(bin)}")
        println()
    }
}

