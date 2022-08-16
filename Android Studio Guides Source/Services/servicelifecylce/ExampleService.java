import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ExampleService extends Service {
    public ExampleService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "onStartCommand was Called", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this, "onCreate was Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "onDestroy was Called", Toast.LENGTH_SHORT).show();

    }
}