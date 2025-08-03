package src.salas;

import src.jugador.Player;

public class EmptyRoom implements Room {
    @Override
    public void enter(Player player) {
        System.out.println("\nEntraste a una sala vacía... no hay nada interesante aquí.");
        player.incrementRoomsExplored();
    }

    @Override
    public String getDescription() {
        return "Sala vacía";
    }
}