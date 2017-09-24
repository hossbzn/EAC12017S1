package joseprieto.eac12017s1;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;

import org.w3c.dom.Text;


public class MainActivity extends Activity {
    //Es declara la variable per identificar l'activitat d'edició
    static final int ACTIVITAT_EDITA = 0;
    //Es declaren les variables que s'enllaçaren amb el Layout
    ImageButton btnCrea, btnCancela, btnEdit, btnEsborra, btnTruca, btnNavega;
    Button btnEnvia;
    TextView vwAdreca, vwDadesPersonals, vwCodiPostal, vwCarrer, vwPoblacio, vwTelefon, vwWeb
            ,iWeb, iCP, iTel, iCarrer, iPoblacio, iNom;
    EditText editNom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //S'enllacen les variables amb els components del layout de l'activitat
        btnCrea = (ImageButton) findViewById(R.id.crea);
        btnCancela = (ImageButton) findViewById(R.id.cancela);
        btnEdit = (ImageButton) findViewById(R.id.Edit);
        btnEsborra = (ImageButton) findViewById(R.id.cancelDades);
        btnTruca = (ImageButton) findViewById(R.id.truca);
        btnNavega = (ImageButton) findViewById(R.id.navega);

        vwAdreca = (TextView) findViewById(R.id.adreça);
        vwDadesPersonals = (TextView) findViewById(R.id.dadespersonals);
        vwCodiPostal = (TextView) findViewById(R.id.codipostal);
        vwCarrer = (TextView) findViewById(R.id.carrer);
        vwPoblacio = (TextView) findViewById(R.id.poblacio);
        vwTelefon = (TextView) findViewById(R.id.telefon);
        vwWeb = (TextView) findViewById(R.id.editWeb);
        btnEnvia = (Button) findViewById(R.id.Envia);

        iWeb = (TextView) findViewById(R.id.viewWeb);
        iCP = (TextView) findViewById(R.id.viewCP);
        iTel = (TextView) findViewById(R.id.viewTelefon);
        iCarrer = (TextView) findViewById(R.id.viewCarrer);
        iPoblacio = (TextView) findViewById(R.id.viewPoblacio);
        iNom = (TextView) findViewById(R.id.nom);

        editNom = (EditText) findViewById(R.id.editnom);
        //Al puslar el botó crea
        btnCrea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //En cas que no s'hagi omplert cap dada
                if (editNom.getText().toString().matches("")) {
                    mostraMissatge("Heu d'escriure un nom!");
                } else { //Si hi ha dades es mostren els components ocults i s'amaguen els
                    //principals
                    iNom.setText(editNom.getText());
                    editNom.setVisibility(View.INVISIBLE);
                    btnCancela.setVisibility(View.INVISIBLE);
                    iWeb.setVisibility(View.VISIBLE);
                    iCP.setVisibility(View.VISIBLE);
                    iTel.setVisibility(View.VISIBLE);
                    iCarrer.setVisibility(View.VISIBLE);
                    iPoblacio.setVisibility(View.VISIBLE);
                    btnCrea.setVisibility(View.INVISIBLE);
                    vwAdreca.setVisibility(View.VISIBLE);
                    vwDadesPersonals.setVisibility(View.VISIBLE);
                    vwCodiPostal.setVisibility(View.VISIBLE);
                    vwCarrer.setVisibility(View.VISIBLE);
                    vwPoblacio.setVisibility(View.VISIBLE);
                    vwTelefon.setVisibility(View.VISIBLE);
                    vwWeb.setVisibility(View.VISIBLE);
                    btnEnvia.setVisibility(View.VISIBLE);
                    btnEdit.setVisibility(View.VISIBLE);
                    btnEsborra.setVisibility(View.VISIBLE);
                    btnTruca.setVisibility(View.VISIBLE);
                    btnNavega.setVisibility(View.VISIBLE);
                }

            }
        });
        //Al pulsar en cancel·lar s'esborra l'escrit a l'edició del nom
        btnCancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editnom = (EditText)findViewById(R.id.editnom);
                editnom.setText("");
            }
        });
        //Al puslar el butó esborrar posa en l'estat inicial l'activitat
        btnEsborra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                editNom.setText("");
                editNom.setVisibility(View.VISIBLE);
                btnCancela.setVisibility(View.VISIBLE);
                iWeb.setVisibility(View.INVISIBLE);
                iCP.setVisibility(View.INVISIBLE);
                iTel.setVisibility(View.INVISIBLE);
                iCarrer.setVisibility(View.INVISIBLE);
                iPoblacio.setVisibility(View.INVISIBLE);
                btnCrea.setVisibility(View.VISIBLE);
                vwAdreca.setVisibility(View.INVISIBLE);
                vwDadesPersonals.setVisibility(View.INVISIBLE);
                vwCodiPostal.setVisibility(View.INVISIBLE);
                vwCarrer.setVisibility(View.INVISIBLE);
                vwPoblacio.setVisibility(View.INVISIBLE);
                vwTelefon.setVisibility(View.INVISIBLE);
                vwWeb.setVisibility(View.INVISIBLE);
                btnEnvia.setVisibility(View.INVISIBLE);
                btnEdit.setVisibility(View.INVISIBLE);
                btnEsborra.setVisibility(View.INVISIBLE);
                btnTruca.setVisibility(View.INVISIBLE);
                btnNavega.setVisibility(View.INVISIBLE);
                //Es defineixen els valors per defecte per la vista
                vwCodiPostal.setText(R.string.nodefinit);
                vwCarrer.setText(R.string.nodefinit);
                vwPoblacio.setText(R.string.nodefinit);
                vwTelefon.setText(R.string.nodefinit);
                vwWeb.setText(R.string.nodefinit);
                iNom.setText(R.string.nom_i_cognom);
            }
        });
        /**
         * Al pulsar al butó envia es comproba que cada camp no tingui el valor per defecte.
         * Si algun està "no definit" mostra per pantalla missatge indicant que les dades són
         * incompletes. En cas contrari "fa l'enviament de dades".
         */
        btnEnvia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean correcte = true;
                if (vwCarrer.getText().toString().equals(getString(R.string.nodefinit))){
                    correcte = false;
                }
                if (vwCodiPostal.getText().toString().equals(getString(R.string.nodefinit))){
                    correcte = false;
                }
                if (vwPoblacio.getText().toString().equals(getString(R.string.nodefinit))){
                    correcte = false;
                }
                if (vwTelefon.getText().toString().equals(getString(R.string.nodefinit))){
                    correcte = false;
                }
                if (vwWeb.getText().toString().equals(getString(R.string.nodefinit))){
                    correcte = false;
                }
                if (correcte) {
                    mostraMissatge("Dades enviades");
                }else{
                    mostraMissatge("Error! Has d'emplenar totes les dades");
                }
            }
        });
        /**
         * Al pulsar el butó trucar comproba que tingui dades i si les té activa el dialer enviant
         * el telèfon indiccat al camp telefon.
         */
        btnTruca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vwTelefon.getText().toString().equals(getString(R.string.nodefinit))){
                    mostraMissatge("Has d'afegir un telefon a la persona");
                }else{
                    //Crea l'intent amb l'acció de dialer
                    Intent trucada = new Intent(Intent.ACTION_DIAL);
                    //Afegeix el telèfon a fer servir per l'intent com a dada
                    trucada.setData(Uri.parse("tel:"+vwTelefon.getText().toString()));
                    startActivity(trucada);
                }
            }
        });
        /**
         * Al puslar el butó navega comproba que
         */
        btnNavega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = (vwWeb.getText().toString());
                if (url.equals(getString(R.string.nodefinit))){ //En cas que no tingui dada mostra missatge
                    //per pantalla
                    mostraMissatge("Has d'afegir una web");
                }else{
                    //Comproba que comenci per les capçaleres http i si no ho fa les afegeix
                    if (!url.startsWith("http://") && !url.startsWith("https://")) {
                        url = "http://" + url;
                    }
                    //Crea l'intent amb la característica vista, afegeix la url per a obrir amb
                    //el navegador
                    Intent navega = new Intent(Intent.ACTION_VIEW);
                    navega.setData(Uri.parse(url));
                    startActivity(navega);
                }
            }
        });


    }

    /**
     * Edita les dades de la persona
     * @param view
     */
    public void onClickEdita(View view){
        //Crea l'intent que farà la crida a l'activitat d'edició
        Intent i = new Intent(this, EdicioDades.class);
        //Compara per cada camp que no siguin els valors per defecte. Si ho és envia buit i si no
        //envia les dades que conté el camp
        if (vwCarrer.getText().toString().equals(getString(R.string.nodefinit))){
            i.putExtra("carrer","");
        }else{
            i.putExtra("carrer",vwCarrer.getText().toString());
        }
        if (vwCodiPostal.getText().toString().equals(getString(R.string.nodefinit))){
            i.putExtra("cp","");
        }else{
            i.putExtra("cp",vwCodiPostal.getText().toString());
        }
        if (vwPoblacio.getText().toString().equals(getString(R.string.nodefinit))){
            i.putExtra("poblacio","");
        }else{
            i.putExtra("poblacio",vwPoblacio.getText().toString());
        }
        if (vwTelefon.getText().toString().equals(getString(R.string.nodefinit))){
            i.putExtra("telefon","");
        }else{
            i.putExtra("telefon",vwTelefon.getText().toString());
        }
        if (vwWeb.getText().toString().equals(getString(R.string.nodefinit))){
            i.putExtra("web","");
        }else{
            i.putExtra("web",vwWeb.getText().toString());
        }
        //Fa la crida de l'activitat esperant una resposta
        startActivityForResult(i,ACTIVITAT_EDITA);
    }

    /**
     * Mostra un missatge toast per pantalla
     * @param missatge El missatge que és vol mostrar.
     */
    private void mostraMissatge(String missatge){
        Toast.makeText(getApplicationContext(), missatge, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultcode, Intent data){
        //Es creen i s'enllacen variables amb els components.
        TextView vwWeb = (TextView)findViewById(R.id.editWeb);
        TextView vwCarrer = (TextView)findViewById(R.id.carrer);
        TextView vwCP = (TextView)findViewById(R.id.codipostal);
        TextView vwPoblacio = (TextView)findViewById(R.id.poblacio);
        TextView vwTelefon = (TextView)findViewById(R.id.telefon);
        //Comprova que l'activitat que respon és l'adient i que és correcte
        if (requestCode == ACTIVITAT_EDITA){
           if (resultcode == RESULT_OK){
               //Si no retorna res seteja amb el valor per defecte, en cas contrari omple amb
               //la dada adient per cadascun dels camps
               if (data.getStringExtra("web").length()==0){
                    vwWeb.setText(R.string.nodefinit);
               }else{
                   vwWeb.setText(data.getStringExtra("web"));
               }
               if (data.getStringExtra("carrer").length()==0){
                   vwCarrer.setText(R.string.nodefinit);
               }else{
                   vwCarrer.setText(data.getStringExtra("carrer"));
               }
               if (data.getStringExtra("cp").length()==0){
                   vwCP.setText(R.string.nodefinit);
               }else{
                   vwCP.setText(data.getStringExtra("cp"));
               }
               if (data.getStringExtra("poblacio").length()==0){
                   vwPoblacio.setText(R.string.nodefinit);
               }else{
                   vwPoblacio.setText(data.getStringExtra("poblacio"));
               }
               if (data.getStringExtra("telefon").length()==0){
                   vwTelefon.setText(R.string.nodefinit);
               }else{
                   vwTelefon.setText(data.getStringExtra("telefon"));
               }
           }else if(requestCode==RESULT_CANCELED){ //Si retorna cancel·lat mostra per pantalla que
               //ha sigut cancel·lada la operació.
               mostraMissatge("CANCELAT");
           }
        }
    }
}
