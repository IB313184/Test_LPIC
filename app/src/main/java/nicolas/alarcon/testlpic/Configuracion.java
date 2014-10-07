package nicolas.alarcon.testlpic;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.google.android.gms.ads.*;

public class Configuracion extends PreferenceActivity {

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.configuracion);
    }
}