package com.balusoft.balusoftapiconsumer.services;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R;
import android.R.anim;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.balusoft.balusoftapiconsumer.helpers.WebRequestHelper;
import com.balusoft.balusoftapiconsumer.model.Personas;

/**
 * 
 * @author Isaac Ojeda
 *
 */
public class PersonasService {

	public static class SearchPeopleByNameTask extends AsyncTask<String, Void, String>{
	
		private final String ENTITY_NAME="persons/";
		
		private Context context;
		public SearchPeopleByNameTask(Context context){
			this.context=context;
		}
		
		@Override
		protected String doInBackground(String... params) {
			return WebRequestHelper.consumeWebService(this.ENTITY_NAME+params[0]);
		}
		
		@Override
		protected void onPostExecute(String result) {
			try {
				ArrayList<Personas> personas = new ArrayList<Personas>();
				
				JSONObject jsonObject = new JSONObject(result);
				JSONArray jsonArray = jsonObject.getJSONArray("Response");
				
				for(int i=0;i<jsonArray.length(); i++){
					Personas persona = new Personas();
					
					persona.setNombre(jsonArray.getJSONObject(i).getString("Nombre"));
					persona.setApellido(jsonArray.getJSONObject(i).getString("Apellido"));
					persona.setContacto(jsonArray.getJSONObject(i).getString("Contacto"));
					persona.setEdad(jsonArray.getJSONObject(i).getInt("Edad"));
					
					personas.add(persona);
					
					Toast.makeText(context, "Nombre: "+persona.getNombre()+ " Apellido: "+persona.getApellido()+" Edad: "+persona.getEdad(), Toast.LENGTH_LONG).show();
				}
				
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}			
	}
}
