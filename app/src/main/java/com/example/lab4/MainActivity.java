package com.example.lab4;
import androidx.appcompat.app.AppCompatActivity;
import android.app. WallpaperManager;
import android.graphics.BitmapFactory;
import android.os. Bundle;
import android.view.View;
import android.widget.Button;
import java.util. Timer;
import java.util. TimerTask;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    Button btnChangeWallpaper;
    boolean running;
    int[] imagesArray = new int[]{R.drawable.wall1, R.drawable.wall2, R.drawable.wall3,
            R.drawable.wall4};
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChangeWallpaper = (Button) findViewById(R.id.changewall);
        btnChangeWallpaper.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (!running) {
            new Timer().schedule(new MyTimer(), 0,30000);
            running = true;
        }
    }

    class MyTimer extends TimerTask {
        public void run() {
            try {
                WallpaperManager wallpaperManager=
                WallpaperManager.getInstance(getBaseContext());
                if (i == 4)
                    i = 0;
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources()
                        , imagesArray[i]));
                i++;
            } catch (Exception e) {
            }
        }
    }
}
