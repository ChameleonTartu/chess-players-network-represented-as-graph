package com.greenbird.chess.network.repository

import com.greenbird.chess.network.entity.chess.Player
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.query.Query
import org.springframework.data.repository.query.Param

interface PlayerRepository : Neo4jRepository<Player, String> {

    @Query("MATCH (p:Player {nickname: '?1'})-[]-(opponent: Player {nickname: '?2'}) RETURN p")
    fun hasOpponent(@Param("nickname") nickname: String, @Param("opponent") opponent: String): Player?
}