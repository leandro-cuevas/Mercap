package org.example

class NationalCall (
    duration: Int,
    time: Int,
    dayOfWeek: DayType,
    localIdOrigin: Int,
    nationalOrigin: Int,
    destination: Customer
    ) : Call(duration, time, dayOfWeek, localIdOrigin, nationalOrigin, destination)  {

    override fun calculateCost(): Double {
        return calculateNationalCostTo(destination.localId) * duration
    }

    fun calculateNationalCostTo(nationalDestination : Int) : Double {
        // The cost of a national phone call to some national destination is hard-coded to 0.70 per minute to simplify.
        return 0.70
    }

}