package nicolas.alarcon.testlpic;

import java.util.Vector;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.*;

public class Apariencia extends BaseAdapter{

	private final Activity actividad;
	private final Vector<String> lista;
	
	public Apariencia(Activity actividad, Vector<String> lista){
		super();
		this.actividad=actividad;
		this.lista=lista;
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return lista.elementAt(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = actividad.getLayoutInflater();
          View view = inflater.inflate(R.layout.posiciones_lista, null, true);
          TextView textView =(TextView)view.findViewById(R.id.nombre);
          textView.setText(lista.elementAt(arg0));
          ImageView imageView=(ImageView)view.findViewById(R.id.icono);
          switch (arg0){
          	case 0: imageView.setImageResource(R.drawable.uno); break;
          	case 1: imageView.setImageResource(R.drawable.dos); break;
          	case 2: imageView.setImageResource(R.drawable.tres); break;
          	case 3: imageView.setImageResource(R.drawable.cuatro); break;
          	case 4: imageView.setImageResource(R.drawable.cinco); break;
          	case 5: imageView.setImageResource(R.drawable.seis); break;
          	case 6: imageView.setImageResource(R.drawable.siete); break;
          	case 7: imageView.setImageResource(R.drawable.ocho); break;
          	case 8: imageView.setImageResource(R.drawable.nueve); break;
          	case 9: imageView.setImageResource(R.drawable.diez); break;
          }
          return view;
	}
}