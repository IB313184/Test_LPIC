package nicolas.alarcon.testlpic;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.*;


import java.security.Principal;

public class PideNombre extends Activity {

      TextView ok, error, tema;


    /** Called when the activity is first created. */
   @Override public void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);
       setContentView(R.layout.pidenombre);
        Button bAcept = (Button) findViewById(R.id.aceptar);
		bAcept.setOnClickListener(new OnClickListener() {
     	  		public void onClick(View view) {
     	  			EditText et = (EditText)findViewById(R.id.nombreJug);
     	  			Boot.bbdd.guardarPuntuacion(PreguntasLpic.puntos, et.getText().toString(), PreguntasLpic.tiempo, PreguntasLpic.tematica);
     	  			finish();
     	  		}
       });
    }
}