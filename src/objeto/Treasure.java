package src.objeto;

import src.jugador.Player;

public class Treasure implements GameObject {
    private String name;
    private String description;

    public Treasure(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void interact(Player player) {
        System.out.println("¡Encontraste " + name + "! " + description);
        player.addToInventory(this);
    }

    @Override
    public String getName() {
        return name;
    }
}
