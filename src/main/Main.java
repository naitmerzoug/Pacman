import PacmanGame.PacmanGame;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // initialisation avec taille de l'espace physique
        PacmanGame pacmanGame = new PacmanGame(100, 90);

        // démarrage
        pacmanGame.run();
    }
}
