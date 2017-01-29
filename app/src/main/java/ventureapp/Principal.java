import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ventureapp.registro.R;

public class Principal extends AppCompatActivity {

    Button register;
    Button newregister;

    //Menu principas
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        register = (Button)findViewById(R.id.registro);
        newregister=(Button)findViewById(R.id.registrar);

       register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Principal.this, register.class);
                startActivity(intent1);


            }
        });
        newregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Principal.this, newregister.class);
                startActivity(intent2);
            }
        });
    }
}
