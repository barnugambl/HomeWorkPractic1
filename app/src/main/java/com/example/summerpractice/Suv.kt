package com.example.summerpractice

class Suv (
    carBrand: String?,
    hoursPower: Int?,
    weight: Double,
    year: Int,
    engineType: String?,
    private val towingCapacity: Int,
) : Car(carBrand, hoursPower, weight, year, engineType) {

    override fun toString(): String {
        return "Suv(carBrand=$carBrand, hoursPower=$hoursPower, weight=$weight, year=$year, engineType=$engineType, towingCapacity=$towingCapacity)"
    }
}