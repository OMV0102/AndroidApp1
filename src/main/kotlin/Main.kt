/*
* author Orlov Mikhail
*/

fun main() {
    println("Добрый день!")
    println("Укажите город...")
    try
    {
        val city_name: String? = readLine()
        if (city_name.isNullOrBlank()) // не null, не пустое, не пробелы
            throw error("Вы пропустили ввод города!")

        println("Введите текущую температуру для города \"$city_name\":")
        val city_temp:Double = readLine()?.toDoubleOrNull() ?: throw error("Вы ввели неверное числовое значение температуры")

        val city = City(city_name, city_temp) // Инициализация объекта класса City

        println("Сейчас в городе \"${city.name}\" температура: ${city.temp}°C")
        println(explanation(city.temp))
    }
    catch (error: Exception)
    {
        println("Ошибка: " + error.message)
    }
}

// Пояснение погоды
fun explanation(t: Double): String
{
    return when (t)
    {
        in -50.0..15.0 -> "На улице сейчас холодно."
        in 15.0..25.0 -> "На улице благоприятная погода для прогулки."
        in 20.0..50.0 -> "На улице очень жарко."
        else -> "Наши синоптики не смогли определить погоду в вашем городе!\n" +
                "На всякий случай оставайтесь дома!"
    }
}