package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.time.Year;
import java.util.Calendar;
import java.util.MissingFormatArgumentException;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1;
    Button btnDemo2;
    TextView tvDemo2;
    Button btnDemo3;
    TextView tvDemo3;
    Button btnEx4;
    TextView tvEx4;
    Button btnDemo4;
    TextView tvdemo4;
    Button btnDemo5;
    TextView tvdemo5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        btnEx4 = findViewById(R.id.Exercise);
        tvEx4 = findViewById(R.id.textViewExercise);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        tvdemo4 = findViewById(R.id.textViewDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);
        tvdemo5 = findViewById(R.id.textViewDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //myBuilder.setTitle("Demo 1-simple Dialog");
                //myBuilder.setMessage("i can develop android app");
                //myBuilder.setCancelable(false);
                //myBuilder.setPositiveButton("close", null);

                myBuilder.setTitle("Congratulation");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("DISMISS", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }


        });
        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Button Dialog");
                myBuilder.setMessage("Select one of the Button Below");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("you have selected Yes");
                    }
                });
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("you have selected NO");
                    }
                });

                myBuilder.setNeutralButton("cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });
        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View viewDialog = inflater.inflate(R.layout.input, null);

                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String message = etInput.getText().toString();
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNeutralButton("cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();


            }
        });
        btnEx4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View viewDialog = inflater.inflate(R.layout.sum, null);
                final EditText etInput1 = viewDialog.findViewById(R.id.editTextNum1);
                final EditText etInput2 = viewDialog.findViewById(R.id.editTextNum2);


                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int total = Integer.valueOf(etInput1.getText().toString()) + Integer.valueOf(etInput2.getText().toString());
                        String message = "The Sum is " + String.valueOf(total);
                        tvEx4.setText(message);
                    }
                });
                myBuilder.setNeutralButton("cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });
        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        tvdemo4.setText("Date: "+ dayOfMonth + "/" + (monthOfYear+1) + "/" + year);

                    }
                };

                Calendar date= Calendar.getInstance();
                int day = date.get(Calendar.DAY_OF_MONTH);

                int month = date.get(Calendar.MONTH);

                int year = date.get(Calendar.YEAR);

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, day, month, year);
                myDateDialog.show();

            }
        });
        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener myDateListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvdemo4.setText("Time: "+ hourOfDay + ":" + minute);

                    }
                };
                Calendar date= Calendar.getInstance();
                int hour = date.get(Calendar.HOUR);
                int min = date.get(Calendar.MINUTE);

                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myDateListener, hour,min,true);
                myTimeDialog.show();

            }
        });


    }
}
