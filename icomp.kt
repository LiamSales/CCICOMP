fun toBinary(decimal: Int): String{
    
    val binary = StringBuilder()

    while (decimal > 0){
        binary.append(decimal%2)
        decimal/=2
    }

    return binary.toString().reversed()

}

fun toOctal(binary: String): String{
    
    val octal = StringBuilder()
    
    if (binary.length%3 == 1) binary = "00" + binary
    else if (binary.length%3 == 2) binary = "0" + binary
    
    var i = 3;
    
    val octate = binary.substring(binary.length - i, binary.length)
    
    

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
