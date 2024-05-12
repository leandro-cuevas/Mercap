package org.example

import java.time.LocalDate

object Billing {

    private fun calculateTotalCosts(customer: Customer): Double {
        return customer.monthlyFee + calculateLocalCosts(customer) + calculateNationalAndInternationalCosts(customer)
    }

    private fun calculateLocalCosts(customer : Customer): Double {
        return customer.localCalls.sumOf { it.calculateCost() }
    }

    private fun calculateNationalAndInternationalCosts(customer : Customer): Double {
        return customer.nationalAndInternationalCalls.sumOf { it.calculateCost() }
    }

    fun createReceipt(customer: Customer): Receipt {
        val receipt = Receipt(
            LocalDate.now(),
            customer.name,
            customer.monthlyFee,
            calculateLocalCosts(customer),
            calculateNationalAndInternationalCosts(customer),
            calculateTotalCosts(customer)
        )

        return receipt
    }
}