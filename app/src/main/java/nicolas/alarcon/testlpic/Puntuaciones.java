package nicolas.alarcon.testlpic;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.ads.*;

import java.security.Principal;

public class Puntuaciones extends ListActivity {

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puntuaciones);
        SharedPreferences gPuntos = getSharedPreferences("nicolas.alarcon.testlpic_preferences", Context.MODE_PRIVATE);
        int tematica = Integer.parseInt(gPuntos.getString("tematica","1"));
        setListAdapter(new Apariencia(this, Boot.bbdd.listaPuntuaciones(tematica)));

        // Buscar AdView como recurso y cargar una solicitud.
        AdView adView = (AdView)this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }
}