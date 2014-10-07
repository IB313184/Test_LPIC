package nicolas.alarcon.testlpic;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;


public class Splash extends Activity {

    /** Called when the activity is first created. */

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    private static String TAG = Splash.class.getName();
    private static long SLEEP_TIME = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);



        IntentLauncher launcher = new IntentLauncher();
        launcher.start();

    }

    private class IntentLauncher extends Thread {

        @Override
        public void run() {
            try {

                Thread.sleep(SLEEP_TIME*1000);

            } catch (Exception e) {

                Log.e(TAG, e.getMessage());

            }

            Intent intent = new Intent(Splash.this, Boot.class);
            Splash.this.startActivity(intent);
            Splash.this.finish();
        }
    }

}