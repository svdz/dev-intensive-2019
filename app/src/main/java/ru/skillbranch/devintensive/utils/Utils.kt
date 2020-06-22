package ru.skillbranch.devintensive.utils

import java.util.*


object Utils {

    val transliterationTable = mapOf<String, String>(
        "а" to "a",
        "б" to "b",
        "в" to "v",
        "г" to "g",
        "д" to "d",
        "е" to "e",
        "ё" to "e",
        "ж" to "zh",
        "з" to "z",
        "и" to "i",
        "й" to "i",
        "к" to "k",
        "л" to "l",
        "м" to "m",
        "н" to "n",
        "о" to "o",
        "п" to "p",
        "р" to "r",
        "с" to "s",
        "т" to "t",
        "у" to "u",
        "ф" to "f",
        "х" to "h",
        "ц" to "c",
        "ч" to "ch",
        "ш" to "sh",
        "щ" to "sh'",
        "ъ" to "",
        "ы" to "i",
        "ь" to "",
        "э" to "e",
        "ю" to "yu",
        "я" to "ya"
    )


    fun parseFullName(fullName: String?) : Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

//        return Pair(firstName, lastName)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val result = payload.map {
            if (it == ' ') {
                divider
            } else {
                val str = it.toString().toLowerCase(Locale("ru"))
                var tmpSymbol = transliterationTable[str] ?: str
                if (it.isUpperCase()) {
                    tmpSymbol = if (tmpSymbol.length == 1)
                        tmpSymbol.toUpperCase(Locale("ru"))
                    else {
                        val char = tmpSymbol[0]
                        tmpSymbol.replaceFirst(char, char.toTitleCase())
                    }
                }
                tmpSymbol
            }
        }
        println(result)
        return result.joinToString("")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val initials = mutableListOf<String>()
        if (firstName?.isNotBlank() == true) {
            initials.add(firstName[0].toUpperCase().toString())
        }

        if (lastName?.isNotBlank() == true) {
            initials.add(lastName[0].toUpperCase().toString())
        }
        return when(initials.size) {
            0 -> null
            else -> initials.joinToString(separator = "")
        }
    }
}