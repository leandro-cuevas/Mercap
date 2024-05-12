package org.example

class LocalCall(
    duration: Int,
    time: Int,
    dayOfWeek: DayType,
    localIdOrigin: Int,
    nationalOrigin: Int,
    destination: Customer
) : Call(duration, time, dayOfWeek, localIdOrigin, nationalOrigin, destination) {

    override fun calculateCost(): Double {

        val isWeekend = dayOfWeek in listOf(DayType.SATURDAY, DayType.SUNDAY)
        val isDaytime = time in 8..20
        return if (isWeekend || !isDaytime) {
            0.10 * duration
        } else {
            0.20 * duration
        }
    }
}