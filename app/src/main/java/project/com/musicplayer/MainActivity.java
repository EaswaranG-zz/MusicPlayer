package project.com.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    MediaPlayer player;
    boolean playLock = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button3);

        //Start playing song
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check wheather song is already playing (or) not
                //If already playing do not start the player again
                if(!playLock){
                    player = MediaPlayer.create(MainActivity.this,R.raw.suzhali);
                    player.start();
                    //Assign a lock to prevent from playing again
                    playLock = true;
                }
            }
        });
        //Stop playing song
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player.isPlaying()){
                    //stop the player
                    player.stop();
                    //Release the object
                    player.release();
                    //Release the Lock
                    playLock = false;
                }
            }
        });
    }
}
