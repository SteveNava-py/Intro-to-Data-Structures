package stevenNavarretteIII;

import java.util.Scanner;

public class Maze {
    NodeII currentNode;

    public Maze() {
        //nodes
        NodeII A = new NodeII("A");
        NodeII B = new NodeII("B");
        NodeII C = new NodeII("C");
        NodeII D = new NodeII("D");
        NodeII E = new NodeII("E");
        NodeII F = new NodeII("F");
        NodeII G = new NodeII("G");
        NodeII H = new NodeII("H");
        NodeII I = new NodeII("I");
        NodeII J = new NodeII("J");
        NodeII K = new NodeII("K");
        NodeII L = new NodeII("L");

        //edges
        A.east = B;
        A.south = E;
        B.west = A;
        B.south = F;
        C.east = D;
        C.west = B;
        D.west = C;
        E.north = A;
        E.south = I;
        E.east = F;
        F.north = B;
        F.east = G;
        F.west = E;
        G.north = C;
        G.east = H;
        G.south = K;
        G.west = F;
        H.west = G;
        H.south = L;
        I.north = E;
        I.east = J;
        J.west = I;
        J.east = K;
        K.west = J;
        K.north = G;
        L.north = H;

        //start user at "A"
        currentNode = A;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the maze!");
        while (true) {
            //current room and directions
            System.out.println("You are in room " + currentNode.name + " of a maze of twisty little passages, all alike.");
            System.out.print("You can go ");
            if (currentNode.north != null) System.out.print("north ");
            if (currentNode.south != null) System.out.print("south ");
            if (currentNode.east != null) System.out.print("east ");
            if (currentNode.west != null) System.out.print("west ");
            System.out.println();

            //user input
            String direction = scanner.nextLine().trim().toLowerCase();

            //conditions for user to move
            if (direction.equals("north") && currentNode.north != null) {
                currentNode = currentNode.north;
            } else if (direction.equals("south") && currentNode.south != null) {
                currentNode = currentNode.south;
            } else if (direction.equals("east") && currentNode.east != null) {
                currentNode = currentNode.east;
            } else if (direction.equals("west") && currentNode.west != null) {
                currentNode = currentNode.west;
            } else {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            //checks if they made it out
            if (currentNode.name.equals("L")) {
                System.out.println("You successfully came out of the maze – well done!");
                break;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.play();
    }
}
