package com.example.summerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numCarsEditText = findViewById<EditText>(R.id.numCarsEditText)
        val startRaceButton = findViewById<Button>(R.id.startRaceButton)

        startRaceButton.setOnClickListener {
            val numCars = numCarsEditText.text.toString().toInt()
            startRace(numCars)
        }
    }
}

private fun startRace(numCars: Int) {
    val cars = MutableList(numCars) { createRandomCar() }
    var round = 1

    while (cars.size > 1) {
        Log.d("Race", "Этап $round: ${cars.size} автомобилей участвуют в заезде")
        val nextRoundCars = mutableListOf<Car>()
        val carsForRace = cars.toMutableList()

        while (carsForRace.isNotEmpty()) {
            if (carsForRace.size == 1) {
                nextRoundCars.add(carsForRace.removeAt(0))
            } else {
                val car1 = carsForRace.removeAt(Random.nextInt(carsForRace.size))
                val car2 = carsForRace.removeAt(Random.nextInt(carsForRace.size))
                val winner = race(car1, car2)
                Log.d("Race", "Гонка между ${car1.carBrand} и ${car2.carBrand}, Победитель ${winner.carBrand}")
                nextRoundCars.add(winner)
            }
        }
        cars.clear()
        cars.addAll(nextRoundCars)
        round++
    }
    Log.d("Race", "Победитель гонки: ${cars[0].carBrand}")
}

fun createRandomCar(): Car { // создание рандомного автомобиля
    return when (Random.nextInt(4)) {
        0 -> SportsCar(
            createRandomNameCar(),
            Random.nextInt(250, 1000),
            Random.nextDouble(1000.0, 1500.0),
            Random.nextInt(2000, 2024),
            createRandomEngineType(),
            Random.nextInt(200, 500)
        )

        1 -> Suv(
            createRandomNameCar(),
            Random.nextInt(250, 1000),
            Random.nextDouble(1000.0, 1500.0),
            Random.nextInt(2000, 2024),
            createRandomEngineType(),
            Random.nextInt(3000, 6000)
        )

        2 -> ElectricCar(
            createRandomNameCar(),
            Random.nextInt(250, 1000),
            Random.nextDouble(1000.0, 1500.0),
            Random.nextInt(2000, 2024),
            createRandomEngineType(),
            Random.nextInt(10, 100)
        )

        else -> Formula1(
            createRandomNameCar(),
            Random.nextInt(250, 1000),
            Random.nextDouble(1000.0, 1500.0),
            Random.nextInt(2000, 2024),
            createRandomEngineType(),
            Random.nextInt(2, 5)
        )
    }
}

private fun createRandomNameCar(): String { // список марок автомобилей
    val carNames = listOf(
        "Tesla",
        "BMW",
        "Audi",
        "Mercedes",
        "Ford",
        "Chevrolet",
        "Honda",
        "Toyota",
        "Porsche",
        "Ferrari"
    )
    return carNames.random()
}

private fun createRandomEngineType(): String { // список типа двигателей
    val engineType = listOf("petrol", "diesel", "gas")
    return engineType.random()
}

fun race(car1: Car, car2: Car): Car {
    val coefCar1 = car1.weight / car1.year.toDouble()
    val coefCar2 = car2.weight / car2.year.toDouble()

    return if (coefCar1 < coefCar2) car1 else car2
}

