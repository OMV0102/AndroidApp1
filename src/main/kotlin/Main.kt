import java.time.LocalDateTime

/*
* author Orlov Mikhail
*/

fun main()
{
    println(welcome()) // Приветствие в зависимсоти от времени
    println("Укажите город:")
    try
    {
        val cityName: String? = readLine()
        if (cityName.isNullOrBlank()) // не null, не пустое, не пробелы
            throw error("Вы пропустили ввод города!")

        println("Введите текущую температуру для города \"$cityName\":")
        val cityTemperature: Double = readLine()?.toDoubleOrNull() ?: throw error("Вы ввели неверное числовое значение температуры")

        val city = City(cityName, cityTemperature) // Инициализация объекта класса City

        println("Сейчас в городе \"${city.name}\" температура: ${city.temp}°C")
        println(explanation(city.temp))
    }
    catch (error: Exception)
    {
        println("Ошибка: " + error.message)
    }
}

// Пояснение погоды
fun explanation(temperature: Double): String
{
    return when (temperature)
    {
        in -50.0..15.0 -> "На улице сейчас холодно."
        in 15.0..25.0 -> "На улице благоприятная погода для прогулки."
        in 20.0..50.0 -> "На улице очень жарко."
        else -> "Наши синоптики не смогли определить погоду в вашем городе!\nНа всякий случай оставайтесь дома!"
    }
}

// Возвращает строку приветствия в зависимости от текущего времени
fun welcome(): String
{
    return when (LocalDateTime.now().hour)
    {
        in 6..10 -> "Доброе утро!"
        in 10..16 -> "Добрый день!"
        in 16..22 -> "Добрый вечер!"
        in 22..23 -> "Доброй ночи!"
        in 0..6 -> "Доброй ночи!"
        else -> "Добро пожаловать!"
    }
}
