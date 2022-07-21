import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

public class MyService extends Service {

    MediaPlayer mediaPlayer;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();


        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        // You can add Your Audio file instead of  RINGTONE
        // To add your audio file create "raw" recourse directory in res
        // Then add your audio file inside it [res/raw/Example.mp3]
        // Now add this code line instead of above line
        // mediaPlayer = MediaPlayer.create(this, R.raw.Example.mp3);

        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(1.0f, 1.0f);
        // Volume for leftVolume and rightVolume

        // Volume , Right side only --> mediaPlayer.setVolume(0.0f , 1.0f); 
        // Volume , Left side only --> mediaPlayer.setVolume(1.0f , 0.0f); 

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }