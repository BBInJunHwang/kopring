package com.example.mykopring.user.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(private val userService: UserService){

    @Test
    fun `사용자를 생성할 수 있다`() {
        // given
        val name = "test"

        // when
        val user = userService.registUser(name)

        // then
        assertNotNull(user.id)
        assertEquals(user.name, name)
    }

    @Test
    fun `사용자를 조회할 수 있다`() {
        // given
        val name = "test"
        val user = userService.registUser(name)

        // when
        val users = userService.get(user.id!!)

        // then
        assertEquals(users.id, user.id)
    }
}