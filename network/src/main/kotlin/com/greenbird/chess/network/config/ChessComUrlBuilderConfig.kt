package com.greenbird.chess.network.config

import org.springframework.stereotype.Component

@Component
class ChessComUrlBuilderConfig {

    companion object {
        const val BASE_URL = "https://api.chess.com/pub"
    }

    fun archiveUrl(nickname: String): String {
        return "$BASE_URL/player/$nickname/games/archives"
    }
}