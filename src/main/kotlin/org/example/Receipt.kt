package org.example

class Receipt(
    val customerName: String,
    val monthyFee: Double,
    val localCallsCost: Double,
    val nationalAndInternationalCallsCost: Double,
    val totalCost: Double
) {
    override fun toString(): String {
        return """
            |Customer: $customerName
            |Monthly fee: $monthyFee
            |Local calls: $localCallsCost
            |National and International calls: $nationalAndInternationalCallsCost
            |Total amount: $totalCost
        """.trimMargin()
    }
}