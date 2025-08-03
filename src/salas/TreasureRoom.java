package src.salas;

import src.jugador.Player;
import src.objeto.GameObject;

public class TreasureRoom implements Room {
    private final GameObject treasure;

    public TreasureRoom(GameObject treasure) {
        this.treasure = treasure;
    }

    @Override
    public void enter(Player player) {
        System.out.println("\n¡Encontraste una sala con tesoro! Contiene: " + treasure.getName());
        treasure.interact(player);
        player.incrementRoomsExplored();
    }

    @Override
    public String getDescription() {
        return "Sala con tesoro (" + treasure.getName() + ")";
    }
}
