package ru.skillbranch.devintensive.extensions


private val defaultLength = 16

fun String.truncate(targetLength: Int = defaultLength) : String {
    val trimStr = this.trimEnd()
    if (trimStr.length <= targetLength) {
        return this.trimEnd()
    }

    val subStr = trimStr.substring(0, targetLength)
    val result = "${subStr.trimEnd()}..."
    return result
}

