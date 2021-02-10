package com.greenbird.chess.network.entity.chess

import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Property
import org.springframework.data.neo4j.core.schema.Relationship
import java.util.HashSet

@Node("Game")
data class Game(
    @field:Id private var url: String
) {
    @Relationship(type = "PLAYED", direction = Relationship.Direction.OUTGOING)
    var players: Set<Player> = HashSet<Player>()

    @Relationship(type = "WINNER", direction = Relationship.Direction.INCOMING)
    var winner: Player? = null
}
