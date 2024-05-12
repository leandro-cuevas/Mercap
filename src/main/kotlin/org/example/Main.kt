package org.example

fun main(args: Array<String>) {

    val leandro = Customer(100.0, "Leandro", 10, 1)
    val maria = Customer(150.0, "Maria", 10, 1 )
    val pedro = Customer(200.0, "Pedro", 20, 1)
    val joao = Customer(250.0, "Joao", 10, 2)

    leandro.makeCall(10, 10, DayType.MONDAY, maria)
    leandro.makeCall(10, 10, DayType.SATURDAY, maria)
    leandro.makeCall(10, 10, DayType.MONDAY, pedro)
    leandro.makeCall(10, 10, DayType.MONDAY, joao)

    println("Local calls: ${leandro.localCalls.size}")
    println()
    println("National and international phone calls: ${leandro.nationalAndInternationalCalls.size}")
    println()
    val receipt = Billing.createReceipt(leandro)

    println(receipt.toString())

}

