package src;

import src.jugador.Player;
import src.objeto.Enemy;
import src.objeto.GameObject;
import src.objeto.Treasure;
import src.salas.EmptyRoom;
import src.salas.EnemyRoom;
import src.salas.Room;
import src.salas.TreasureRoom;

import java.util.Scanner;

public class DungeonExplorer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear jugador
        System.out.print("Ingresa tu nombre, valiente aventurero: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName, 100);

        // Crear objetos del juego (polimorfismo con GameObject)
        GameObject goldChest = new Treasure("Cofre de oro", "Brilla intensamente bajo la luz de las antorchas.");
        GameObject healthPotion = new Treasure("Poción de salud", "Restaura 20 puntos de salud cuando se usa.");
        GameObject magicSword = new Treasure("Espada mágica", "Causa daño adicional a los enemigos.");

        GameObject goblin = new Enemy("Goblin", 15);
        GameObject orc = new Enemy("Orco", 25);
        GameObject dragon = new Enemy("Dragón", 40);

        // Crear mazmorra con diferentes salas (polimorfismo con Room)
        Room[] dungeon = {
                new EmptyRoom(),
                new TreasureRoom(goldChest),
                new EnemyRoom(goblin),
                new EmptyRoom(),
                new TreasureRoom(healthPotion),
                new EnemyRoom(orc),
                new TreasureRoom(magicSword),
                new EnemyRoom(dragon),
                new EmptyRoom()
        };

        System.out.println("\n¡Bienvenido a la Mazmorra de Aventura, " + player.getName() + "!");
        System.out.println("Tu objetivo es explorar todas las salas y sobrevivir.\n");

        // Bucle principal del juego
        for (int i = 0; i < dungeon.length && player.isAlive(); i++) {
            System.out.println("\nEstás frente a la sala " + (i+1) + " de " + dungeon.length);
            System.out.println("Descripción: " + dungeon[i].getDescription());
            System.out.print("¿Quieres entrar? (s/n): ");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("s")) {
                dungeon[i].enter(player);
                player.showStatus();

                if (!player.isAlive()) {
                    System.out.println("\n¡Has sido derrotado! Fin del juego.");
                    break;
                }

                if (i < dungeon.length - 1) {
                    System.out.print("\nPresiona Enter para continuar a la siguiente sala...");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Decidiste no entrar. El juego ha terminado.");
                break;
            }
        }

        if (player.isAlive()) {
            System.out.println("\n¡Felicidades! Has explorado todas las salas y sobrevivido a la mazmorra.");
            System.out.println("Resultados finales:");
            player.showStatus();
        }

        scanner.close();
    }
}