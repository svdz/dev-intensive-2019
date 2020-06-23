package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String="HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    this.time += when(units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
    return "только что"
}




enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural(value: Int): String  {
        val units = when(this) {
            SECOND -> when(value) {
                1, 21, 31, 41, 51 -> "секунду"
                in 2..4,
                in 22..24,
                in 32..34,
                in 42..44,
                in 52..54 -> "секунды"
                else -> "секунд"
            }

            MINUTE ->  when(value) {
                1, 21, 31, 41, 51 -> "минуту"
                in 2..4,
                in 22..24,
                in 32..34,
                in 42..44,
                in 52..54 -> "минуты"
                else -> "минут"
            }

            HOUR ->  when(value) {
                1, 21 -> "час"
                in 2..4,
                in 22..24 -> "часа"
                else -> "часов"
            }

            DAY ->  when(value) {
                1, 21, 31, 41, 51, 61, 71, 81, 91, 101, 121, 131,
                141, 151, 161, 171, 181, 191, 201, 221, 231, 241,
                251, 261, 271, 281, 291, 301, 321, 331, 341, 351, 361 -> "день"
                in 2..4, in 22..24, in 32..34, in 42..44,
                in 52..54, in 62..64, in 72..74, in 82..84,
                in 92..94, in 102..104, in 122..124, in 132..134,
                in 142..144, in 152..154, in 162..164, in 172..174,
                in 182..184, in 192..194, in 202..204, in 222..224,
                in 232..234, in 242..244, in 252..254, in 252..254,
                in 262..264, in 272..274, in 282..284, in 292..294,
                in 302..304, in 322..324, in 332..334, in 342..344,
                in 352..354, in 362..364, in 372..374, in 382..384 -> "дня"
                else -> "дней"
            }
        }

        return "$value $units"
    }
}
