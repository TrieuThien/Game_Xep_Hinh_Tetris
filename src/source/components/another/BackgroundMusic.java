package source.components.another;

import javax.sound.sampled.Clip;

public class BackgroundMusic {
    public static void playMusic() {
        // Tải Clip từ FileLoader
        Clip clip = FileLoader.LoadSound("/SoundHelix-Song-1.wav");
        
        // Kiểm tra xem Clip có tải thành công không
        if (clip == null) {
            return;
        }

        try {
            // Phát nhạc lặp lại vô hạn
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Để kiểm tra
    public static void main(String[] args) {
        playMusic();
    }
}