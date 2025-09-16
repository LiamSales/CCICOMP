fun toBinary(decimal: Int): String {
    if (decimal == 0) return "0"
    val sb = StringBuilder()
    var n = decimal
    while (n > 0) {
        sb.insert(0, (n and 1).toString()) // take last bit of the full decimal number n and 1 gets the last bit of N, because we do by the number of digits, completely reliant on n 
        n = n shr 1                        // shifts all bits to the right by one place, so  ex: 1101 becomes 0110, this is actually binary dividing by 2 (floor division)
    }
    return sb.toString() // already in binary, prev code had the operations done manually, but bitwise operators automate the process directly
}

fun toOctal(decimal: Int): String {
    if (decimal == 0) return "0" 
    val sb = StringBuilder()
    var n = decimal
    while (n > 0) {
        sb.insert(0, (n and 7).toString()) // gets n and 111, last 3 digits then copies, we can extract this by using and then the binary number (2^x - 1)
        n = n shr 3 //same as above, move the 3 digits, this is dividing by 8
    }
    return sb.toString() // yea and already does the thing in decimal so its dec>bin internally> dec
}

fun toHexa(decimal: Int): String {
    if (decimal == 0) return "0"
    val hexChars = "0123456789ABCDEF" // reference, basically a macro?
    val sb = StringBuilder()
    var n = decimal
    while (n > 0) {
        val digit = n and 15               // last 4 bits (0–15)
        sb.insert(0, hexChars[digit]) //basically maps from our macro, ez
        n = n shr 4
    }
    return sb.toString()
}

fun onesComp(binary: String): String {
    val sb = StringBuilder()
    for (c in binary) { // goes through every character in the binary
        sb.append(if (c == '0') '1' else '0') //bit flip so if c0, then 1, if c1 then 0, then hyst rebuilds the string
    }
    return sb.toString()
}

fun twosComp(binary: String): String { //ones comp +1
    val sb = StringBuilder(binary) //take note the sb has an argument now, it contains the binary
    var carry = true // do i still need to add 1 to the next higher bit?
    for (i in sb.length - 1 downTo 0) { // will continue study tomorrow but this is the last one
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

