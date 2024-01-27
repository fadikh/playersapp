package org.players.players;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.players.players.common.PlayerModelAssembler;
import org.players.players.controllers.PlayerController;
import org.players.players.entities.Player;
import org.players.players.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(PlayerController.class)
class PlayerControllerTest {

    @MockBean
    private PlayerRepository playerRepository;

    @MockBean
    private PlayerModelAssembler playerModelAssembler;

    @InjectMocks
    private PlayerController playerController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllPlayers() throws Exception {
        Player player = new Player("aardsda01", 1981, 12, 27, "USA", "CO", "Denver", 0, 0, 0, "", "", "", "David", "Aardsma", "David Allan", 215, 75, "R", "R", new Date(), new Date(), "aardd001", "aardsda01");
        when(playerRepository.findAll()).thenReturn(Arrays.asList(player));
        when(playerModelAssembler.toModel(player)).thenReturn(new PlayerModelAssembler().toModel(player));

        ResultActions results = mockMvc.perform(MockMvcRequestBuilders.get("/players"));

        mockMvc.perform(MockMvcRequestBuilders.get("/players"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("_embedded.playerList[0].playerID").value(player.getPlayerID()))
                .andExpect(jsonPath("_embedded.playerList[0].nameGiven").value(player.getNameGiven()))
                .andExpect(jsonPath("_links.self.href").exists());
    }

    @Test
    void testGetPlayerById() throws Exception {
        Player player = new Player("aardsda01", 1981, 12, 27, "USA", "CO", "Denver", 0, 0, 0, "", "", "", "David", "Aardsma", "David Allan", 215, 75, "R", "R", new Date(), new Date(), "aardd001", "aardsda01");
        when(playerRepository.findById("aardsda01")).thenReturn(Optional.of(player));
        when(playerModelAssembler.toModel(player)).thenReturn(new PlayerModelAssembler().toModel(player));

        mockMvc.perform(MockMvcRequestBuilders.get("/players/aardsda01"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("playerID").value(player.getPlayerID()))
                .andExpect(jsonPath("nameGiven").value(player.getNameGiven()))
                .andExpect(jsonPath("_links.self.href").exists());
    }

    @Test
    void testGetPlayerById_PlayerNotFound() throws Exception {
        when(playerRepository.findById("1")).thenReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders.get("/players/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

