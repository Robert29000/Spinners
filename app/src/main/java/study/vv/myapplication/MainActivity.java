package study.vv.myapplication;

import android.support.annotation.IdRes;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText tor=(EditText)findViewById(R.id.editText);
        final TextView txt=(TextView)findViewById(R.id.textView);
        final  Spinner sd=(Spinner)findViewById(R.id.spinner);
        sd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
                String choice=sd.getItemAtPosition(selectedItemPosition).toString();
                try {
                    switch (choice) {
                        case "Двоичная":
                            txt.setText(Integer.toBinaryString(Integer.parseInt(tor.getText().toString())));
                            break;
                        case "Восьмеричная":
                            txt.setText(Integer.toOctalString((Integer.parseInt(tor.getText().toString()))));
                            break;
                        case "Шестнадцетиричная":
                            txt.setText(Integer.toHexString(Integer.parseInt(tor.getText().toString())));
                            break;
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Ведите число",Toast.LENGTH_LONG).show();
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }
}

