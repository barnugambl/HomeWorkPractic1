package com.example.summerpractice

open class Car (
    open val carBrand: String?,
    open val hoursPower: Int?,
    open val weight: Double,
    open val year: Int,
    open val engineType: String?,
) {
    override fun toString(): String {
        return "Car(carBrand=$carBrand, hoursPower=$hoursPower, weight=$weight, year=$year, engineType=$engineType)"
    }
}