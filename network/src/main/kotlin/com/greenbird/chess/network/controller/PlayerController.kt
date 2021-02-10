package com.greenbird.chess.network.controller

import com.greenbird.chess.network.entity.chess.Player
import com.greenbird.chess.network.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/player")
class PlayerController @Autowired constructor(
    private val playerService: PlayerService
) {

    @PostMapping("/opponents/{nickname}")
    fun saveOpponents(@PathVariable nickname: String, @RequestParam("level") level: Int = 0): Set<Player> {
        val player = playerService.retrieveOpponents(nickname, level)
        return player.opponents
    }


    @GetMapping("/opponents/{nickname}")
    fun retrieveOpponents(@PathVariable nickname: String): Player? {
        //return playerRepository.findByNickname(nickname)
        return null
    }

}