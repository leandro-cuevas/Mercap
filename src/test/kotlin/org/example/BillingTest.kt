package org.example

import org.junit.Test
import kotlin.test.assertEquals


class BillingTest {

    val leandro = Customer(100.0, "Leandro", 10, 1)
    val maria = Customer(150.0, "Maria", 10, 1 )
    val pedro = Customer(200.0, "Pedro", 20, 1)
    val joao = Customer(250.0, "Joao", 10, 2)


    @Test
    fun localCallRealizationOnMonday() {
        leandro.makeCall(10, 10, DayType.MONDAY, maria)
        assertEquals(1, leandro.localCalls.size)
        val receipt = Billing.createReceipt(leandro)
        assertEquals(2.0, receipt.localCallsCost)
        assertEquals(0.0, receipt.nationalAndInternationalCallsCost)
        assertEquals(102.0, receipt.totalCost)
    }
    @Test
    fun localCallRealizationOnSaturday() {
        leandro.makeCall(10, 10, DayType.SATURDAY, maria)
        assertEquals(1, leandro.localCalls.size)
        val receipt = Billing.createReceipt(leandro)
        assertEquals(1.0, receipt.localCallsCost)
        assertEquals(0.0, receipt.nationalAndInternationalCallsCost)
        assertEquals(101.0, receipt.totalCost)
    }

    @Test
    fun localCallRealizationOnMondayEarlyMorning() {
        leandro.makeCall(10, 5, DayType.MONDAY, maria)
        assertEquals(1, leandro.localCalls.size)
        val receipt = Billing.createReceipt(leandro)
        assertEquals(1.0, receipt.localCallsCost)
        assertEquals(0.0, receipt.nationalAndInternationalCallsCost)
        assertEquals(101.0, receipt.totalCost)
    }

    @Test
    fun nationalCallRealization() {
        leandro.makeCall(10, 10, DayType.MONDAY, pedro)
        assertEquals(1, leandro.nationalAndInternationalCalls.size)
        val receipt = Billing.createReceipt(leandro)
        assertEquals(0.0, receipt.localCallsCost)
        assertEquals(7.0, receipt.nationalAndInternationalCallsCost)
        assertEquals(107.0, receipt.totalCost)
    }

    @Test
    fun internationalCallRealization() {
        leandro.makeCall(10, 10, DayType.MONDAY, joao)
        assertEquals(1, leandro.nationalAndInternationalCalls.size)
        val receipt = Billing.createReceipt(leandro)
        assertEquals(0.0, receipt.localCallsCost)
        assertEquals(12.5, receipt.nationalAndInternationalCallsCost)
        assertEquals(112.5, receipt.totalCost)
    }

    @Test
    fun aLotOfCalls() {
        leandro.makeCall(10, 10, DayType.MONDAY, maria)
        leandro.makeCall(10, 10, DayType.SATURDAY, maria)
        leandro.makeCall(10, 10, DayType.MONDAY, pedro)
        leandro.makeCall(10, 10, DayType.MONDAY, joao)
        assertEquals(2, leandro.localCalls.size)
        assertEquals(2, leandro.nationalAndInternationalCalls.size)
        val receipt = Billing.createReceipt(leandro)
        assertEquals(3.0, receipt.localCallsCost)
        assertEquals(19.5, receipt.nationalAndInternationalCallsCost)
        assertEquals(122.5, receipt.totalCost)
        assertEquals("Leandro", receipt.customerName)
    }
}