fun toBinary(decimal: Int): String{
    
    val binary: MutableList<Int> = mutableListOf()

    while (decimal > 0){
        binary.add(decimal%2)
        decimal/=2
    }

    return "turn the binary list into a string"

}

fun toOctal(binary: String): String{
    // figure out if better to hard code or convert to int
}

fun toHexa(binary: String): String{
    
}

fun onesComp(binary: String): String{
    
}

fun twosComp(binary: String): String{
    
}

fun main(){
    // user enters number in decimal
}
