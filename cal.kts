import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var num1: Double
    var num2: Double
    var operator: String

    println("")
    println("---------------------")
    num1 = scanner.nextDouble()

    print("")
    num2 = scanner.nextDouble()

    print("选择操作符 (+, -, *, /): ")
    operator = scanner.next()

    val result = when (operator) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> num1 / num2
        else -> throw IllegalArgumentException("无效的操作符")
    }

    println("---------------------")
    println("$result")
}
