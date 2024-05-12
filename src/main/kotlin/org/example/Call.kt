package org.example

abstract class Call(
    // Duration is an Int representing the duration of the call in minutes.
    val duration: Int,
    // Time is an Int representing the time of the call in 24-hour format.
    val time: Int,
    val dayOfWeek: DayType,
    val localIdOrigin: Int,
    val nationalOrigin: Int,
    val destination: Customer
) {

    abstract fun calculateCost(): Double

}