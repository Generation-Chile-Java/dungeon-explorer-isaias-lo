package src.objeto;

import src.jugador.Player;

public class Enemy implements GameObject {
    private String name;
    private int damage;

    public Enemy(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    @Override
    public void interact(Player player) {
        System.out.println(name + " te ataca y causa " + damage + " puntos de daño!");
        player.takeDamage(damage);
    }

    @Override
    public String getName() {
        return name + " (daño: " + damage + ")";
    }
}
