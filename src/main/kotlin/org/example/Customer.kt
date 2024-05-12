package org.example



class Customer(val monthlyFee: Double,
               val name : String,
               val localId : Int,
               val nationalId : Int) {

    val localCalls = mutableListOf<Call>()
    val nationalAndInternationalCalls = mutableListOf<Call>()

    fun makeCall(duration: Int, time: Int, dayOfWeek: DayType, destination: Customer) {

        lateinit var call: Call

        if (isLocal(destination)) {
            call = LocalCall(duration, time, dayOfWeek, localId, nationalId, destination)
            localCalls.add(call)
        } else if (isNational(destination)) {
            call = NationalCall(duration, time, dayOfWeek, localId, nationalId, destination)
            nationalAndInternationalCalls.add(call)
        } else {
            call = InternationalCall(duration, time, dayOfWeek, localId, nationalId, destination)
            nationalAndInternationalCalls.add(call)
        }
    }

    private fun isLocal(destination: Customer): Boolean {
        return (nationalId == destination.nationalId) and
                (localId == destination.localId)
    }

    private fun isNational(destination: Customer): Boolean {
        return (nationalId == destination.nationalId) and
                (localId != destination.localId)
    }
}