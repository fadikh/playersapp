package org.players.players.controllers;

import org.players.players.common.PlayerModelAssembler;
import org.players.players.entities.Player;
import org.players.players.exceptions.PlayerNotFoundException;
import org.players.players.repositories.PlayerRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final PlayerModelAssembler playerModelAssembler;

    public PlayerController(PlayerRepository playerRepository, PlayerModelAssembler playerModelAssembler) {
        this.playerRepository = playerRepository;
        this.playerModelAssembler = playerModelAssembler;
    }

    @GetMapping("/players")
    public CollectionModel<EntityModel<Player>> all() {
        List<EntityModel<Player>> players = playerRepository.findAll().stream().parallel()
                .map(this.playerModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(players, linkTo(methodOn(PlayerController.class).all()).withSelfRel());

    }

    @GetMapping("/players/{id}")
    public EntityModel<Player> one(@PathVariable String id) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
        return this.playerModelAssembler.toModel(player);
    }
}
