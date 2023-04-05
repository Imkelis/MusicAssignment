public class Main {

    public static void reactiveMusic() {
        String[] a = { "MAIN" };
        processing.core.PApplet.runSketch(a, new ReactiveMusic());
    }

    public static void main(String[] args) throws Exception {
        reactiveMusic();
    }
}
