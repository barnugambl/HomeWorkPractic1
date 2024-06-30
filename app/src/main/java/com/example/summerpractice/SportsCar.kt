package com.example.summerpractice

class SportsCar(
    carBrand: String?,
    hoursPower: Int?,
    weight: Double,
    year: Int,
    engineType: String?,
    private val maxSpeed: Int,
) : Car(carBrand, hoursPower, weight, year, engineType) {

    override fun toString(): String {
        return "SportsCar(carBrand=$carBrand, hoursPower=$hoursPower, weight=$weight, year=$year, engineType=$engineType, maxSpeed=$maxSpeed)"
    }
}