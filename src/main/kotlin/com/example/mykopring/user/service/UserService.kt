package com.example.mykopring.user.service

import com.example.mykopring.user.domain.User
import com.example.mykopring.user.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    @Transactional
    fun registUser(name: String): User {
        val user = User(name = name)
        return userRepository.save(user)
    }

    fun get(userId: Long) = userRepository.findById(userId).get()
}