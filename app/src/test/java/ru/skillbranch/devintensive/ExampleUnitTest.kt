package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
//        val user = User("1")
        val user2 = User("2", "John", "Wick")
//        val user3 = User("3", "John", "Silverhand", null, lastVisit = Date(), isOnline = true)

//        user.printMe()
//        user2.printMe()
//        user3.printMe()

//        println("$user $user2 $user3")
    }

    @Test
    fun test_factory() {
//        val user = User.makeUser("John Cene")
//        val user2 = User.makeUser("John Wick")
        val user = User.makeUser("John Walker")
        var user2  =user.copy(id = "2", lastName = "Cene", lastVisit = Date())
        println("$user \n$user2")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Walker")

        fun getUserInfo() = user
        val (id, firstName, lastName) = getUserInfo()
        println("$id $firstName $lastName")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Walker")
        val user2 = user.copy(lastVisit = Date())
        val user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        val user4 = user.copy(id = "2", lastVisit = Date().add(2, TimeUnits.DAY))

//        if (user == user2) {
//            println("equals: \n${user.hashCode()} $user \n${user2.hashCode()} $user2")
//        } else {
//            println("not equals: \n${user.hashCode()} $user \n${user2.hashCode()} $user2")
//        }
//
//        user2 = user
//
//        if (user === user2) {
//            println("equals address: \n${System.identityHashCode(user)} \n${System.identityHashCode(user2)}")
//        } else {
//            println("not equals address: \n${System.identityHashCode(user)} \n${System.identityHashCode(user2)}")
//        }
//
//        user2.lastName = "NewName"


        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}            
            ${user4.lastVisit?.format()}            
        """.trimIndent())

    }


    @Test
    fun test_data_mapping() {
        val user = User.makeUser("Вадим Павлов")
        val user2 = user.copy(lastVisit = Date().add(-8, TimeUnits.SECOND))
        println(user2)

        val userView = user.toUserView()

        userView.printMe()
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Вадим Павлов")
        val textMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text", type = "text")
        val imageMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type = "image")

//        when(imageMessage) {
//            is TextMessage -> println("this is textMessage")
//            is ImageMessage -> println("this is image message")
//        }

        println(textMessage.formatMessage())
        println(imageMessage.formatMessage())
    }


    @Test
    fun test_toInitials() {
        println("${Utils.toInitials("john" ,"doe")}")
        println("${Utils.toInitials("John", null)}")
        println("${Utils.toInitials(null, null)}")
        println("${Utils.toInitials(" ", "")}")
    }

    @Test
    fun test_transliteration() {
//        Utils.transliteration("Женя Стереотипов") //Zhenya Stereotipov
//        Utils.transliteration("Amazing Петр","_") //Amazing_Petr

        println(Utils.transliteration("Женя Стереотипов"))
        println(Utils.transliteration("Amazing Петр","_"))
    }

    @Test
    fun test_truncate() {
        val testString = "123456789_123456789_123456789"

        println(testString.truncate())
        println(testString.truncate(10))
        println("A       ".truncate(3))
        println("1234  789".truncate(6))
    }

//    @Test
//    fun test_stripHtml() {
//        println("<p class=\"title\">Образовательное IT-сообщество Skill Branch</p>".stripHtml())
//    }

    @Test
    fun test_builder() {
        val user = User.Builder().firstName("Apple")
            .lastName("Seed")
            .lastVisit(Date())
            .build()

        val user2 = User.Builder().firstName("Android")
            .lastName("Can")
            .lastVisit(Date())
            .build()

        println(user)
        println(user2)
    }

    @Test
    fun test_time_plural() {
        println(TimeUnits.HOUR.plural(19))
        println(TimeUnits.SECOND.plural(1))
        println(TimeUnits.MINUTE.plural(4))
        println(TimeUnits.DAY.plural(222))
    }


}