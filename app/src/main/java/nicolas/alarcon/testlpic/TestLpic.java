package nicolas.alarcon.testlpic;

import java.util.Vector;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.CompoundButton;
import android.widget.ZoomControls;

import com.google.android.gms.ads.*;






  public class TestLpic extends View {
        private int tematica;



        public TestLpic(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.tematica = 0;
            //jugarInicio();

        }


        @Override
        protected void onSizeChanged(int ancho, int alto, int ancho_anter, int alto_anter) {
            super.onSizeChanged(ancho, alto, ancho_anter, alto_anter);


        }


        @Override
        protected void onDraw(Canvas canvas) {


        }

        //Manejo sensores
        public void vistaJuegoResume() {
        }

        public void vistaJuegoPause() {
        }
        //Fin manejo sensores

        public void setTematica(int tematica) {
            this.tematica = tematica;
        }

        public int getTematica() {
            return this.tematica;
        }

    }

