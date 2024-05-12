package org.example

import java.time.LocalDate

class Receipt(
    val billDate: LocalDate,
    val customerName: String,
    val monthyFee: Double,
    val localCallsCost: Double,
    val nationalAndInternationalCallsCost: Double,
    val totalCost: Double
) {
    override fun toString(): String {
        return """
            Bill date: $billDate
            Customer: $customerName
            Monthly fee: $$monthyFee
            Local calls: $$localCallsCost
            National and International calls: $$nationalAndInternationalCallsCost
            Total: $$totalCost
        """.trimMargin()
    }
}