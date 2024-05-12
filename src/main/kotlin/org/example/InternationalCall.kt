package org.example

class InternationalCall(duration: Int,
                        time: Int,
                        dayOfWeek: DayType,
                        localIdOrigin: Int,
                        nationalOrigin: Int,
                        destination: Customer
) : Call(duration, time, dayOfWeek, localIdOrigin, nationalOrigin, destination)  {

    override fun calculateCost(): Double {
        return calculateInternationalCostTo(destination.nationalId) * duration
    }

    private fun calculateInternationalCostTo(internationalDestination : Int) : Double {
        // The cost of an international phone call to some international destination is hard-coded to 1.25 per minute for simplicity.
        return 1.25
    }

}