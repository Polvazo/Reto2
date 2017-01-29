import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ventureapp.registro.R;

public class register extends AppCompatActivity {
    TextView usuario;
    EditText tdni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usuario=(TextView) findViewById(R.id.idusario);
        tdni=(EditText)findViewById(R.id.iddni2);
    }

    //Consulta del registrar
    public void consulta(View v) {
        DataBaseRegister admin = new DataBaseRegister(this,
                "Registro", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String dni = tdni.getText().toString();
        Cursor fila = bd.rawQuery(
                "select nombre,apellido,edad  from register where dni=" + dni, null);
        if (fila.moveToFirst()) {
            usuario.setText("\n"+"Nombre:" +fila.getString(0)+"\n\n"+"Apellido: "+fila.getString(1)+"\n\n"+"Edad: "+fila.getString(2)+" años");
        } else
            Toast.makeText(this, "No existe una persona con dicho dni",
                    Toast.LENGTH_SHORT).show();
        bd.close();

    }
}
