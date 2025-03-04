package com.example.mykopring.user.service

import com.example.mykopring.user.domain.User
import com.example.mykopring.user.repository.UserRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class UserRepositoryTest @Autowired constructor(private val userRepository: UserRepository) {

    @Test
    fun `사용자를 저장할 수 있다`(){
        // given
        val user = User(name = "test") // 코틀린은 Builder 패턴없이도 생성자 호출 가능, 보조 생성자 필요없음

        // when
        val savedUser = userRepository.save(user)

        // then
        assertEquals(savedUser.id, user.id)
    }

    @Test
    fun `사용자를 조회할 수 있다`(){
        // given
        val user = User(name = "test")
        userRepository.save(user)

        // when
        val users = userRepository.findById(user.id!!)

        // then
        assertEquals(users.get().id, user.id)
    }
}