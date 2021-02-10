package com.greenbird.chess.network.repository

import com.greenbird.chess.network.entity.chess.Game
import org.springframework.data.neo4j.repository.Neo4jRepository

interface GameRepository : Neo4jRepository<Game, String> {

}