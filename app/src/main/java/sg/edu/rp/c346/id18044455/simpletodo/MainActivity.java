package sg.edu.rp.c346.id18044455.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spn;
    EditText aT;
    Button btnAdd;
    Button btnDelete;
    Button btnClear;
    ListView tasksView;
    ArrayList<String> tasks;
    ArrayAdapter<String> tV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    spn = findViewById(R.id.spinner);
    aT = findViewById(R.id.addTask);
    btnAdd = findViewById(R.id.btnA);
    btnDelete = findViewById(R.id.btnD);
    btnClear = findViewById(R.id.btnC);
    tasksView = findViewById(R.id.ListView);
    tasks = new ArrayList<String>();
    tV = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tasks);
    tasksView.setAdapter(tV);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        aT.setHint(R.string.aH);
                        btnAdd.setEnabled(true);
                        btnDelete.setEnabled(false);
                        break;
                    case 1:
                        aT.setHint(R.string.rH);
                        btnDelete.setEnabled(true);
                        btnAdd.setEnabled(false);
                        break;
                }//end of switch
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = aT.getText().toString();
                tasks.add(taskName);
                aT.setText(null);
                tV.notifyDataSetChanged();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(aT.getText().toString());
                 if(tasks.size() != 0){
                        if(tasks.size() <= pos || pos < 0){
                            Toast.makeText(MainActivity.this, "Wrong index number", Toast.LENGTH_SHORT).show();
                        }
                    else{
                        tasks.remove(pos);
                        tV.notifyDataSetChanged();
                        aT.setText(null);
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "You don't have any task to remove", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tasks.clear();
                tV.notifyDataSetChanged();
            }
        });




    }//end of method
}//end of class