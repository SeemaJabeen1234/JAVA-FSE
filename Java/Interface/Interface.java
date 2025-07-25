package Interface;

interface Playable {
    void play();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("Strumming the guitar...");
    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("Playing the piano...");
    }
}

public class Interface {
    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        guitar.play(); // Output: Strumming the guitar...
        piano.play(); // Output: Playing the piano...
    }
}
