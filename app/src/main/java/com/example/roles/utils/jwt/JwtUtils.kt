package com.example.roles.utils.jwt

import android.util.Base64
import com.example.roles.domain.model.Role
import org.json.JSONObject

object JwtUtils {
    fun getRole(
        token: String
    ): Role {

        return try {
            val parts = token.split(".")
            if (parts.size != 3)
                return Role.OPERATOR

            val payload = parts[1]
            val decodedBytes =
                Base64.decode(
                    payload,
                    Base64.URL_SAFE or Base64.NO_WRAP
                )

            val json =
                String(decodedBytes)

            when (
                JSONObject(json)
                    .getString("role")
            ) {
                "Supervisor" -> Role.SUPERVISOR
                "Operador" -> Role.OPERATOR
                else -> Role.OPERATOR
            }

        } catch (e: Exception) {
            Role.OPERATOR
        }
    }
}