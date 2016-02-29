package com.example.nidhisakhala.calculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener{

    private EditText edittext;
    private Button addition,subtraction,multiplication,division,equal,clear;
    private TextView result;
    private double num1=0,num2=0,sum=0,difference=0,product=0,quotient=0;
    private int operation=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext = (EditText) findViewById(R.id.number1);
        addition = (Button) findViewById(R.id.add);
        subtraction = (Button) findViewById(R.id.sub);
        multiplication = (Button) findViewById(R.id.mul);
        division = (Button) findViewById(R.id.div);
        equal = (Button) findViewById(R.id.equals);
        clear = (Button) findViewById(R.id.clear);
        result = (TextView) findViewById(R.id.textView);

        addition.setOnClickListener(this);
        subtraction.setOnClickListener(this);
        multiplication.setOnClickListener(this);
        division.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.scientific) {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void operate()
    {
        if(!edittext.getText().toString().equals(""))
        {
            num2 = Double.parseDouble(edittext.getText().toString());
            if(operation == 1)
            {
                sum = num1 + num2;
                result.setText(Double.toString(num1)+" + "+Double.toString(num2)+" = "+Double.toString(sum));
            }
            else if(operation == 2)
            {
                difference = num1 - num2;
                result.setText(Double.toString(num1)+" - "+Double.toString(num2)+" = "+Double.toString(difference));
            }
            else if(operation == 3)
            {
                product = num1 * num2;
                result.setText(Double.toString(num1)+" * "+Double.toString(num2)+" = "+Double.toString(product));
            }
            else if(operation == 4)
            {
                quotient = num1 / num2;
                result.setText(Double.toString(num1)+" / "+Double.toString(num2)+" = "+Double.toString(quotient));
            }
            else if(operation == 0)
            {
                Toast.makeText(getApplicationContext(), "Select Operation First", Toast.LENGTH_SHORT).show();
                num2=0;
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Enter second number",Toast.LENGTH_SHORT).show();
        }
        edittext.setText("");
    }
    @Override
    public void onClick(View v) {
        if(!edittext.getText().toString().equals(""))
        {
            if(v.getId() == R.id.add)
            {
                num1 = Double.parseDouble(edittext.getText().toString());
                operation=1;
                result.setText(Double.toString(num1)+" + ");
            }
            else if(v.getId() == R.id.sub)
            {
                num1 = Double.parseDouble(edittext.getText().toString());
                operation=2;
                result.setText(Double.toString(num1)+" - ");
            }
            else if(v.getId() == R.id.mul)
            {
                num1 = Double.parseDouble(edittext.getText().toString());
                operation=3;
                result.setText(Double.toString(num1)+" * ");
            }
            else if(v.getId() == R.id.div)
            {
                num1 = Double.parseDouble(edittext.getText().toString());
                operation=4;
                result.setText(Double.toString(num1)+" / ");
            }
            if(v.getId() == R.id.equals)
            {
                operate();
            }
        }
        else
        {
            if(v.getId() == R.id.clear)
            {
                edittext.setText("");
                result.setText("");
            }
            else
                Toast.makeText(getApplicationContext(), "Enter first number",Toast.LENGTH_SHORT).show();
        }
        edittext.setText("");
    }

}
