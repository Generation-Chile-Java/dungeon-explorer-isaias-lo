package src.jugador;

import src.objeto.GameObject;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private List<GameObject> inventory;
    private int roomsExplored;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
        this.inventory = new ArrayList<>();
        this.roomsExplored = 0;
    }

    // Encapsulación: métodos públicos para acceder/modificar atributos privados
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println(name + " recibió " + damage + " puntos de daño. Salud restante: " + health);
    }

    public void addToInventory(GameObject item) {
        inventory.add(item);
        System.out.println("¡" + item.getName() + " añadido al inventario!");
    }

    public void showStatus() {
        System.out.println("\n=== Estado de " + name + " ===");
        System.out.println("Salud: " + health);
        System.out.println("Salas exploradas: " + roomsExplored);
        System.out.println("Inventario (" + inventory.size() + " items):");
        for (GameObject item : inventory) {
            System.out.println("- " + item.getName());
        }
    }

    public void incrementRoomsExplored() {
        roomsExplored++;
    }

    // Getters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public boolean isAlive() { return health > 0; }
}
