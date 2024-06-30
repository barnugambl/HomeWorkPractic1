package com.example.summerpractice
class Formula1(
    carBrand: String?,
    hoursPower: Int?,
    weight: Double,
    year: Int,
    engineType: String?,
    private val acceleration: Int,
) : Car(carBrand, hoursPower, weight, year, engineType) {


    override fun toString(): String {
        return "Formula1(carBrand=$carBrand, hoursPower=$hoursPower, weight=$weight, year=$year, engineType=$engineType, acceleration=$acceleration)"
    }
}