package nicolas.alarcon.testlpic;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.google.android.gms.ads.*;


public class Boot extends Activity {

	static DbHelper bbdd;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bbdd=new DbHelper (this);
        setContentView(R.layout.activity_principal);

        // Buscar AdView como recurso y cargar una solicitud.
        AdView adView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.exit:	lanzarSalir(null);break;
        case R.id.config: lanzarConfiguracion(null);break;
        }
        return true;
    }
    
    public void lanzarPuntuaciones(View view){
    	Intent i = new Intent(this, Puntuaciones.class);
    	startActivity(i);
    }
    
    public void lanzarConfiguracion(View view){
    	Intent i = new Intent(this, Configuracion.class);
    	startActivity(i);
    }
    
    public void lanzarSalir(View view){
    	finish();
    }
    
    public void lanzarRapidText(View view){
    	Intent i = new Intent(this, Configuracion.class);
    	startActivity(i);
    }

    public void button2print(View view) {
        //Inform the user the button has been clicked
        finish();
    }

    public void button3print(View view) {
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }

    public void llpic1print(View view) {
        Intent i = new Intent(this, PreguntasLpic.class);
        startActivity(i);
    }

    public void llpic2print(View view) {
        Intent i = new Intent(this, PreguntasLpic.class);
        startActivity(i);
    }

    public void llpic3print(View view) {
        Intent i = new Intent(this, PreguntasLpic.class);
        startActivity(i);
    }
}
