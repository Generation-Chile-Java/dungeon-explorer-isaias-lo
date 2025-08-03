package src.salas;

import src.jugador.Player;
import src.objeto.GameObject;

public class EnemyRoom implements Room {
    private GameObject enemy;

    public EnemyRoom(GameObject enemy) {
        this.enemy = enemy;
    }

    @Override
    public void enter(Player player) {
        System.out.println("\n¡Oh no! Hay un enemigo en esta sala: " + enemy.getName());
        enemy.interact(player);
        player.incrementRoomsExplored();
    }

    @Override
    public String getDescription() {
        return "Sala con enemigo (" + enemy.getName() + ")";
    }
}