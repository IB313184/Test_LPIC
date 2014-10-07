package nicolas.alarcon.testlpic;

import java.util.Vector;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.google.android.gms.ads.*;


public class PreguntasLpic extends Activity {

    private Vector<String> preguntasYrespuestas;
    private int resultado = 0;
    private int posicion = 0;
    static int puntos = 0;
    static int perror = 0;
    static long tiempo = 0;
    static int tematica = 0;
    static int pregunta = 0;
    private Button bNext;
    private TextView tx3, tx4, tx5;
    private long valor1, valor2;

    TextView ok, error, tema;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        SharedPreferences gPuntos = getSharedPreferences("nicolas.alarcon.testlpic_preferences", Context.MODE_PRIVATE);
        int tematica = Integer.parseInt(gPuntos.getString("tematica", "1"));
        this.preguntasYrespuestas = Boot.bbdd.listaPreguntas(tematica);
        this.valor1 = System.currentTimeMillis();
        listarPregunta(0);
        bNext = (Button) findViewById(R.id.siguiente);
        bNext.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                siguientePregunta();

            }
        });

        // Buscar AdView como recurso y cargar una solicitud.
        AdView adView = (AdView)this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);



    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void siguientePregunta() {

        CheckBox rb1 = (CheckBox) findViewById(R.id.opcion1);
        CheckBox rb2 = (CheckBox) findViewById(R.id.opcion2);
        CheckBox rb3 = (CheckBox) findViewById(R.id.opcion3);
        CheckBox rb4 = (CheckBox) findViewById(R.id.opcion4);
        int respuesta = 0;
        this.posicion++;

        if (rb1.isChecked()) {
            respuesta = 1;
        } else if (rb2.isChecked()) {
            respuesta = 2;
        } else if (rb3.isChecked()) {
            respuesta = 3;
        } else if (rb4.isChecked()) {
            respuesta = 4;
        }
        rb1.setChecked(false);
        rb2.setChecked(false);
        rb3.setChecked(false);
        rb4.setChecked(false);

        if (this.resultado == respuesta) PreguntasLpic.puntos++;
            PreguntasLpic.pregunta++;

        if (this.resultado < respuesta) PreguntasLpic.perror++;
        if (this.resultado > respuesta) PreguntasLpic.perror++;

        if (this.posicion < 10)
            listarPregunta(this.posicion);

        else {
            this.valor2 = System.currentTimeMillis();
            PreguntasLpic.puntos = (int) ((PreguntasLpic.puntos + 1) / ((this.valor2 - this.valor1)));
        //    PreguntasLpic.pregunta = (int) ((PreguntasLpic.pregunta + 1));
        //    PreguntasLpic.perror = (int) ((PreguntasLpic.perror + 1) / ((this.valor2 - this.valor1)));
            if (PreguntasLpic.puntos < 0) PreguntasLpic.puntos = PreguntasLpic.puntos + (-1);
        //    if (PreguntasLpic.puntos == 0) PreguntasLpic.perror = PreguntasLpic.perror + (1);
        //    if (PreguntasLpic.pregunta > 0) PreguntasLpic.pregunta = PreguntasLpic.pregunta + (-1);
            SharedPreferences gPuntos = getSharedPreferences("nicolas.alarcon.testlpic_preferences", Context.MODE_PRIVATE);
            PreguntasLpic.tematica = Integer.parseInt(gPuntos.getString("tematica", "1"));
            PreguntasLpic.tiempo = System.currentTimeMillis();
            Intent i = new Intent(this, PideNombre.class);
            startActivity(i);
            finish();
        }



    }




public void listarPregunta(int posicion){
		   String aux[]=this.preguntasYrespuestas.elementAt(posicion).split(";");
           TextView textView =(TextView)findViewById(R.id.preguntaActual);
           devuelveCadena(textView, aux[0]);
           CheckBox opcion1 = (CheckBox)findViewById(R.id.opcion1);
           devuelveCadena(opcion1, aux[1]);
           CheckBox opcion2 = (CheckBox)findViewById(R.id.opcion2);
           devuelveCadena(opcion2, aux[2]);
           CheckBox opcion3 = (CheckBox)findViewById(R.id.opcion3);
           devuelveCadena(opcion3, aux[3]);
           CheckBox opcion4 = (CheckBox)findViewById(R.id.opcion4);
           devuelveCadena(opcion4, aux[4]);
           this.resultado =Integer.parseInt(aux[5]);

	   }


	   
	   public void devuelveCadena(TextView textV, String aux){

           ok = (TextView) findViewById(R.id.textView3);
           ok.setText("Bien: " + puntos);
           error = (TextView) findViewById(R.id.textView4);
           error.setText("Mal: " + perror);
           tema = (TextView) findViewById(R.id.textView5);
           tema.setText("Total: " + pregunta);

		   if(aux.equals("preguntaTematica10")){
			   textV.setText(R.string.preguntaTematica10);
           }else if(aux.equals("preguntaTematica11")){
			   textV.setText(R.string.preguntaTematica11);
           }else if(aux.equals("preguntaTematica12")){
               textV.setText(R.string.preguntaTematica12);
           }else if(aux.equals("preguntaTematica13")){
               textV.setText(R.string.preguntaTematica13);
           }else if(aux.equals("preguntaTematica14")){
               textV.setText(R.string.preguntaTematica14);
           }else if(aux.equals("preguntaTematica15")){
               textV.setText(R.string.preguntaTematica15);
           }else if(aux.equals("preguntaTematica16")){
               textV.setText(R.string.preguntaTematica16);
           }else if(aux.equals("preguntaTematica17")){
               textV.setText(R.string.preguntaTematica17);
           }else if(aux.equals("preguntaTematica18")){
               textV.setText(R.string.preguntaTematica18);
           }else if(aux.equals("preguntaTematica19")){
               textV.setText(R.string.preguntaTematica19);
           }else if(aux.equals("preguntaTematica1Respuesta81")){
               textV.setText(R.string.preguntaTematica1Respuesta81);
           }else if(aux.equals("preguntaTematica1Respuesta82")){
               textV.setText(R.string.preguntaTematica1Respuesta82);
           }else if(aux.equals("preguntaTematica1Respuesta83")){
               textV.setText(R.string.preguntaTematica1Respuesta83);
           }else if(aux.equals("preguntaTematica1Respuesta84")){
               textV.setText(R.string.preguntaTematica1Respuesta84);
           }else if(aux.equals("preguntaTematica20")){
               textV.setText(R.string.preguntaTematica20);
           }else if(aux.equals("preguntaTematica21")){
               textV.setText(R.string.preguntaTematica21);
           }else if(aux.equals("preguntaTematica22")){
               textV.setText(R.string.preguntaTematica22);
           }else if(aux.equals("preguntaTematica23")){
               textV.setText(R.string.preguntaTematica23);
           }else if(aux.equals("preguntaTematica24")){
               textV.setText(R.string.preguntaTematica24);
           }else if(aux.equals("preguntaTematica25")){
               textV.setText(R.string.preguntaTematica25);
           }else if(aux.equals("preguntaTematica26")){
               textV.setText(R.string.preguntaTematica26);
           }else if(aux.equals("preguntaTematica27")){
               textV.setText(R.string.preguntaTematica27);
           }else if(aux.equals("preguntaTematica28")){
               textV.setText(R.string.preguntaTematica28);
           }else if(aux.equals("preguntaTematica29")){
               textV.setText(R.string.preguntaTematica29);
           }else if(aux.equals("preguntaTematica2Respuesta31")){
               textV.setText(R.string.preguntaTematica2Respuesta31);
           }else if(aux.equals("preguntaTematica2Respuesta32")){
               textV.setText(R.string.preguntaTematica2Respuesta32);
           }else if(aux.equals("preguntaTematica2Respuesta51")){
               textV.setText(R.string.preguntaTematica2Respuesta51);
           }else if(aux.equals("preguntaTematica2Respuesta71")){
               textV.setText(R.string.preguntaTematica2Respuesta71);
           }else if(aux.equals("preguntaTematica2Respuesta72")){
               textV.setText(R.string.preguntaTematica2Respuesta72);
           }else if(aux.equals("preguntaTematica2Respuesta73")){
               textV.setText(R.string.preguntaTematica2Respuesta73);
           }else if(aux.equals("preguntaTematica2Respuesta74")){
               textV.setText(R.string.preguntaTematica2Respuesta74);
           }else{
               textV.setText(aux);
		   }

       }


}