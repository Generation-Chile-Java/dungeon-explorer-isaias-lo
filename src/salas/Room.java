package src.salas;

import src.jugador.Player;

public interface Room {
    void enter(Player player);
    String getDescription();
}