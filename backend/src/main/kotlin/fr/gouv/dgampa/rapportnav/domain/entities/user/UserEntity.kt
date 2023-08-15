package fr.gouv.dgampa.rapportnav.domain.entities.user

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

data class UserEntity(
    val id: Int?,
    val name: String,
    val email: String,
    val password: String
//    private var _password: String // Private field to store the actual password

) {
//    val password: String // Public getter for password
//        get() = _password
//
//    fun setPassword(password: String) {
//        _password = password
//    }
//
//    fun comparePassword(password: String): Boolean {
//        return BCryptPasswordEncoder().matches(password, this._password)
//    }
}
