import kotlin.system.exitProcess

fun main() {
    println("Enter names using comma (,) as separator")

    val names = readln().orEmpty()

    val namesArray = names.split(",")

    println("Enter salary using comma (,) as separator")

    val salary = readln().orEmpty()

    val salaryArray = salary.split(",")

    if (namesArray.size != salaryArray.size){
        println("Names not the same")
        exitProcess(0)
    }

    validateLength(namesArray, 10, "Name")
    validateLength(salaryArray, 6, "Salary")
    printTable(namesArray,salaryArray)
}

fun validateLength(namesArray: List<String>, maxSize: Int, entity: String) {
    for (name in namesArray) {
        if (name.length > maxSize) println("$entity must be up to $maxSize characters")
        exitProcess(0)
    }
}

fun printTable(namesArray: List<String>, salaryArray: List<String>){
    println("-".repeat(23))

    for (name in namesArray){
        val index = namesArray.indexOf(name)
        val salary = salaryArray[index]
        val f1 = (12 - name.length) / 2
        val f2 = 12 - name.length - f1
        val s1 = (8 - salary.length) / 2
        val s2 = 8 - salary.length - s1
        println("|" + " ".repeat(f1) + name + " ".repeat(f1) + "|" + " ".repeat(s1) + salary + " ".repeat(s2) + "|")
    }
    println("-".repeat(23))
}
