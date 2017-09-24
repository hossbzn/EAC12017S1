package joseprieto.eac12017s1;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;


public class EdicioDades extends Activity {
    //Crea les variables que s'enllaçarà amb el Layout
    Button btnAccepta, btnCancela;
    EditText editWeb, editCarrer, editCP, editPoblacio, editTelefon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicio_dades);
        //Enllaça variables amb els components del layout
        btnAccepta = (Button)findViewById(R.id.btnAccepta);
        btnCancela = (Button)findViewById(R.id.btnCancela);
        editWeb = (EditText)findViewById(R.id.editWeb);
        editCarrer = (EditText)findViewById(R.id.carrer);
        editCP = (EditText)findViewById(R.id.cp);
        editPoblacio = (EditText)findViewById(R.id.poblacio);
        editTelefon = (EditText)findViewById(R.id.telefon);
        //Rep l'intent de l'activitat principal i omple les dades del layout
        final Intent data = getIntent();
        editWeb.setText(data.getStringExtra("web"));
        editCarrer.setText(data.getStringExtra("carrer"));
        editCP.setText(data.getStringExtra("cp"));
        editPoblacio.setText(data.getStringExtra("poblacio"));
        editTelefon.setText(data.getStringExtra("telefon"));

        //Al pulsar al butó accepta
        btnAccepta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Retorna les dades a l'activitat principal les dades emplenades als edittext
                data.putExtra("carrer",editCarrer.getText().toString());
                data.putExtra("cp",editCP.getText().toString());
                data.putExtra("poblacio",editPoblacio.getText().toString());
                data.putExtra("telefon",editTelefon.getText().toString());
                data.putExtra("web",editWeb.getText().toString());
                setResult(RESULT_OK, data);
                finish();
            }
        });
        //Al pulsar el butó cancel·la
        btnCancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Retorna a l'activitat principal que s'ha cancel·lat
                setResult(RESULT_CANCELED,data);
                finish();
            }
        });
    }
}
