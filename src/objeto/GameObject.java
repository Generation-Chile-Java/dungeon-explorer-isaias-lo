package src.objeto;

import src.jugador.Player;

public interface GameObject {
    void interact(Player player);
    String getName();
}