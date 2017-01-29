package ventureapp.registro;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class newregister extends AppCompatActivity  {
    EditText etnombre;
    EditText etapellido;
    EditText etedad;
    EditText etdni;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newregister);

        etnombre=(EditText)findViewById(R.id.idnombre);
        etapellido=(EditText)findViewById(R.id.idapellido);
        etedad=(EditText)findViewById(R.id.idedad);
        etdni=(EditText)findViewById(R.id.iddni);
    }

    //subir los dats
    public void alta (View v) {
        DataBaseRegister admin = new DataBaseRegister(this,"Registro",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();

        String nombre = etnombre.getText().toString();
        String apellido= etapellido.getText().toString();
        String edad = etedad.getText().toString();
        String dni=etdni.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("dni",dni);
        registro.put("nombre",nombre);
        registro.put("apellido",apellido);
        registro.put("edad",edad);

        bd.insert("register",null,registro);

        etdni.setText("");
        etnombre.setText("");
        etapellido.setText("");
        etedad.setText("");

        Toast.makeText(this, "Se registro correctamente",
                Toast.LENGTH_SHORT).show();

    }
}
