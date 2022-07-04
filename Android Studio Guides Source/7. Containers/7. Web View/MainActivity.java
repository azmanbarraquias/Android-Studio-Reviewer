import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.web_view);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // Check internet Connection 
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {


            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://google.com");

            /*
             * LOADING .html FILE WITH ANDROID WebView :-
             *
             * webView.loadUrl("file:///android_asset/index.html");
             * */

            WebSettings webSetting = webView.getSettings();
            webSetting.setJavaScriptEnabled(true);

            /*
             *  Solve this
             *
             *  net::ERR_CLEARTEXT_NOT_PERMITTED
             *
             * Add this Code to Manifest File
             *
             * <application
             * ....
             * android:usesCleartextTraffic="true"
             * ....>
             *
             * */

        } else {

            // if no internet
             Snackbar.make(findViewById(R.id.webView), "NO INTERNET", Snackbar.LENGTH_SHORT).show();

        }
    }
}