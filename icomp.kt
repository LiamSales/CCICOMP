fun toBinary(decimal: Int): String{
    
    val binary = StringBuilder()
    var answer = decimal

    while (answer > 0){
        binary.insert(0,answer%2)
        answer/=2
    }

    return binary.toString()

}

fun toOctal(decimal: Int): String{
    
    var binary = toBinary(decimal)

    val octal = StringBuilder()
    
    if      (binary.length%3 == 1) binary = "00" + binary
    else if (binary.length%3 == 2) binary = "0" + binary
  
    var i = 3;
    var j = 0;

    while (j<binary.length){
  
        val octate = binary.substring(binary.length - i, binary.length - j).toInt()

        val digits = Triple(octate/100, octate%100/10, octate%10)

        octal.insert(0, digits.first * 4 + digits.second * 2 + digits.third)

        i+=3
        j+=3

     }

     return octal.toString()

}

fun toHexa(decimal: Int): String{
    
    var binary = toBinary(decimal)

    val hexa = StringBuilder()
    
    if      (binary.length%3 == 1) binary = "000" + binary
    else if (binary.length%3 == 2) binary = "00" + binary
    else if (binary.length%3 == 3) binary = "0" + binary
  
    var i = 4;
    var j = 0;

    while (j<binary.length){

            // so 1000 is 8, 1001 is 9, 1010 is A

        var hexate = binary.substring(binary.length - i, binary.length - j).toInt()

            if (hexate/1000 == 1 && hexate%100 < 0){
                hexate%=1000
                var letter = 'A'
                // assume the base case is 010
                // subtract the last three original digits to the base case in binary
                // add the difference to the base case
                hexa.insert(0,letter)
                }
            else {
                // ez same as octal except we gotta worry about 8 and 9
            }
        }
        i+=4
        j+=4
     }
     return hexa.toString()
}

//  fun onesComp(binary: String): String{
  
//  }

//  fun twosComp(binary: String): String{
  
//  }

fun main(){

    while(true){

        print("Please enter the number in base 10: ")

        val decimal = readlnOrNull()?.toIntOrNull() ?: 0

        print("\nEnter the base you wish to convert $decimal to: ")

        val toBase = readlnOrNull()?.toIntOrNull() ?: 2

        println()
        
        when(toBase){
            2 -> println(toBinary(decimal))
            8 -> println(toOctal(decimal))
            // 16 -> println(toHexa(decimal)) 
        }

    }

}
