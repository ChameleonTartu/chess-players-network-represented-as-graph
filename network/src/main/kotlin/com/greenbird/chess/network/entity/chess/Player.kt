package com.greenbird.chess.network.entity.chess

import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Property
import org.springframework.data.neo4j.core.schema.Relationship
import java.util.HashSet

@Node("Player")
data class Player(
    @field:Id var nickname: String
) {
    @Relationship(type = "OPPONENT", direction = Relationship.Direction.OUTGOING)
    var opponents: MutableSet<Player> = mutableSetOf()
}
