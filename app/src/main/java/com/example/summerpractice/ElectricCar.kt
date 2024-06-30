package com.example.summerpractice

class ElectricCar(
    carBrand: String?,
    hoursPower: Int?,
    weight: Double,
    year: Int,
    engineType: String?,
    private val batteryCapacity: Int,
) : Car(carBrand, hoursPower, weight, year, engineType) {

    override fun toString(): String {
        return "ElectricCar(carBrand=$carBrand, hoursPower=$hoursPower, weight=$weight, year=$year, engineType=$engineType, batteryCapacity=$batteryCapacity)"
    }
}
