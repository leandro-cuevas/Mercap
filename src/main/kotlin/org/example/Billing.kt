package org.example

object Billing {

    private fun calculateTotalCosts(customer: Customer): Double {
        return customer.monthlyFee + calculateLocalCosts(customer) + calulateNationalAndInternationalCosts(customer)
    }

    private fun calculateLocalCosts(customer : Customer): Double {
        return customer.localCalls.sumOf { it.calculateCost() }
    }

    private fun calulateNationalAndInternationalCosts(customer : Customer): Double {
        return customer.nationalAndInternationalCalls.sumOf { it.calculateCost() }
    }

    fun createReceipt(customer: Customer): Receipt {
        val receipt = Receipt(
            customer.name,
            customer.monthlyFee,
            calculateLocalCosts(customer),
            calulateNationalAndInternationalCosts(customer),
            calculateTotalCosts(customer)
        )

        return receipt
    }
}