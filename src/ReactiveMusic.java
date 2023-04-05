import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class ReactiveMusic extends PApplet {
    Minim minim;
    AudioPlayer aplayer;
    AudioInput ainput;
    AudioBuffer abuffer;

    int Mode = 1;

    public void settings() {
        size(1024, 1000, P3D);
    }

    public void setup() {
        colorMode(HSB);
        minim = new Minim(this);
        aplayer = minim.loadFile("heroplanet.mp3", 1024); // Temp Song, to be changed
        aplayer.play();
        abuffer = aplayer.mix;
    }

    public void draw() {
        float halfHeight = height / 2;

        switch (Mode) {
            case 1:

                // Temp visual just to test
                background(0);
                for (int i = 0; i < abuffer.size(); i++) {

                    stroke(255, 255, 255);
                    line(i, halfHeight + (abuffer.get(i) * halfHeight * 2f), i,
                            halfHeight - (abuffer.get(i) * halfHeight * 2f));

                }

                break;

            case 2:

                break;
            case 3:

                break;
        }

    }

    // Might be changed to on screen buttons, not sure thought cause that would
    // block visuals.
    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            Mode = key - '0';
        }
        if (keyCode == ' ') {
            if (aplayer.isPlaying()) {
                aplayer.pause();
            } else {
                aplayer.rewind();
                aplayer.play();
            }
        }
    }
}
