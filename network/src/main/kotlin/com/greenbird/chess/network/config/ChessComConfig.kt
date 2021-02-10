package com.greenbird.chess.network.config

import com.greenbird.chess.network.entity.chess.Player
import org.json.JSONArray
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.function.Predicate


@Component
class ChessComConfig @Autowired constructor(private val chessComUrlBuilderConfig: ChessComUrlBuilderConfig) {

    fun archives(nickname: String): List<String> {
        println("Retrieving archives")

        val array: JSONArray = khttp.get(chessComUrlBuilderConfig.archiveUrl(nickname)).jsonObject["archives"] as JSONArray

        val archives = ArrayList<String>()
        for (i in 0 until array.length()) {
            archives.add(array.get(i) as String)
        }
        return archives
    }

    fun retrieveOpponents(nickname: String, archiveUrls: List<String>, includeOpponent: Predicate<Player>): Player {
        println("Retrieving opponents")
        val player = Player(nickname)
        for (archiveUrl in archiveUrls) {
            println("Getting players from archive url: $archiveUrl")
            val gameList = khttp.get(archiveUrl).jsonObject["games"] as JSONArray

            for (gameIndex in 0 until gameList.length()) {
                val g: JSONObject = gameList.getJSONObject(gameIndex)
                val white = Player(
                    g.getJSONObject("white").getString("username").toLowerCase()
                )

                val black = Player(
                    g.getJSONObject("black").getString("username").toLowerCase()
                )

                val addPlayer: Player = if (player == white) {
                    black
                } else {
                    white
                }

                if (includeOpponent.test(addPlayer)) {
                    player.opponents.add(addPlayer)
                }
            }
            println("Opponents count: ${player.opponents.size}")
        }
        return player
    }
}