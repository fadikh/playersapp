package org.players.players.exceptions;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(String id) {
        super(String.format("Player with id %s does not exists", id));
    }
}
