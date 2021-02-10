package com.greenbird.chess.network.service

import com.greenbird.chess.network.config.ChessComConfig
import com.greenbird.chess.network.entity.chess.Player
import com.greenbird.chess.network.repository.PlayerRepository
import org.neo4j.cypherdsl.core.Functions.collect
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.function.Predicate
import java.util.stream.Collectors
import kotlin.streams.toList

@Service
class PlayerService @Autowired constructor(
    private val chessComConfig: ChessComConfig,
    private val playerRepository: PlayerRepository
) {

    fun retrieveOpponents(nickname: String, level: Int): Player {
        var allPlayers: List<String> = listOf(nickname)

        for (lvl in 0 until level + 1) {
            println("Processing level: $lvl")
            var playersList = mutableListOf<Player>()
            for (index in allPlayers.indices) {
                println("Player: ${allPlayers[index]}")
                val pl = playerRepository.findByNickname(allPlayers[index])

                val opponents: Set<Player>
                if (pl == null || pl.opponents.isEmpty()) {
                    val player = chessComConfig.retrieveOpponents(
                        allPlayers[index],
                        chessComConfig.archives(allPlayers[index])
                    ) { p: Player -> playerRepository.hasOpponent(allPlayers[index], p.nickname) == null }
                    opponents = player.opponents
                    playerRepository.save(player)
                } else {
                    opponents = pl.opponents
                }

                println("Checking for opponents of player: ${allPlayers[index]}")
                playersList.addAll(
                    opponents.toSet().stream()
                        .filter { player -> playerRepository.hasOpponent(allPlayers[index], player.nickname) == null}
                        .toList()
                )
            }
            playersList.addAll(playersList.toSet())
            allPlayers = playersList.stream().map { pl -> pl.nickname }.toList()
        }

        return Player(nickname)
    }

}