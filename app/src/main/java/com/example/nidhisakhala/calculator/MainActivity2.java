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

public class MainActivity2 extends ActionBarActivity implements OnClickListener{

    private EditText num;
    private TextView result;
    private Button sin,cos,tan,ln,log,e,power,fact,root,pi,clear,equal;
    private double number,exponent;
    private int operation=0,flag=0,num_fact,value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        num = (EditText) findViewById(R.id.input);
        result = (TextView) findViewById(R.id.output);
        sin = (Button) findViewById(R.id.sine);
        cos = (Button) findViewById(R.id.cosine);
        tan = (Button) findViewById(R.id.tangent);
        ln = (Button) findViewById(R.id.ln);
        log = (Button) findViewById(R.id.log);
        e = (Button) findViewById(R.id.exponential);
        power = (Button) findViewById(R.id.power);
        fact = (Button) findViewById(R.id.factorial);
        root = (Button) findViewById(R.id.squareroot);
        pi = (Button) findViewById(R.id.pi);
        clear = (Button) findViewById(R.id.clear);
        equal = (Button) findViewById(R.id.equal);

        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        ln.setOnClickListener(this);
        log.setOnClickListener(this);
        e.setOnClickListener(this);
        power.setOnClickListener(this);
        fact.setOnClickListener(this);
        root.setOnClickListener(this);
        pi.setOnClickListener(this);
        clear.setOnClickListener(this);
        equal.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private int factorial(int num)
    {
        if(num == 1)
            return num;
        else
        {
            num = num * factorial(num - 1);
            return num;
        }
    }

    private void operate(int operation)
    {
        if(!num.getText().toString().equals(""))
        {
            if(operation == 1)
            {
                if(num.getText().toString().equals(Double.toString(Math.PI)))
                    result.setText("Sin( pi ) = 0");
                else
                {
                    number = Double.parseDouble(num.getText().toString());
                    result.setText("Sin( " + Double.toString(number) + " ) = " + Double.toString(Math.sin(number)));
                    num.setText("");
                }
            }
        else if(operation == 2)
            {
                if(num.getText().toString().equals(Double.toString(Math.PI)))
                    result.setText("Cos( pi ) = -1");
                else
                {
                    number = Double.parseDouble(num.getText().toString());
                    result.setText("Cos( " + Double.toString(number) + " ) = " + Double.toString(Math.cos(number)));
                    num.setText("");
                }
            }
        else if(operation == 3)
            {
                if(num.getText().toString().equals(Double.toString(Math.PI)))
                    result.setText("Tan( pi ) = 0");
                else
                {
                    number = Double.parseDouble(num.getText().toString());
                    result.setText("Tan( " + Double.toString(number) + " ) = " + Double.toString(Math.tan(number)));
                    num.setText("");
                }
            }
        else if(operation == 4)
            {
                number= Double.parseDouble(num.getText().toString());
                result.setText("ln( "+Double.toString(number)+" ) = "+Double.toString(Math.log(number)));
                num.setText("");
            }
        else if(operation == 5)
            {
                number= Double.parseDouble(num.getText().toString());
                result.setText("log( "+Double.toString(number)+" ) = "+ Double.toString(Math.log10(number)));
                num.setText("");
            }
        else if(operation == 6)
            {
                number= Double.parseDouble(num.getText().toString());
                result.setText("root( "+Double.toString(number)+" ) = "+Double.toString(Math.sqrt(number)));
                num.setText("");
            }
        else if(operation == 7)
            {
                exponent = Double.parseDouble(num.getText().toString());
                result.setText(Double.toString(number)+" ^ "+Double.toString(exponent)+" = "+Double.toString(Math.pow(number,exponent)));
                num.setText("");
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Enter a Number",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.sine)
        {
            result.setText("Sin(");
            operation = 1;
        }
        if(v.getId() == R.id.cosine)
        {
            result.setText("Cos(");
            operation = 2;
        }
        if(v.getId() == R.id.tangent)
        {
            result.setText("Tan(");
            operation = 3;
        }
        if(v.getId() == R.id.ln)
        {
            result.setText("ln(");
            operation = 4;
        }
        if(v.getId() == R.id.log)
        {
            result.setText("log(");
            operation = 5;
        }
        if(v.getId() == R.id.pi)
        {
            result.setText("");
            num.setText("");
            num.setText(Double.toString(Math.PI));
        }
        if(v.getId() == R.id.exponential)
        {
            result.setText("");
            num.setText("");
            num.setText(Double.toString(Math.E));
        }
        if(v.getId() == R.id.squareroot)
        {
            result.setText("root(");
            operation = 6;
        }
        if(v.getId() == R.id.clear)
        {
            num.setText("");
            result.setText("");
            flag=1;
        }
        if(v.getId() == R.id.power)
        {
            if(!num.getText().toString().equals(""))
            {
                number= Double.parseDouble(num.getText().toString());
                result.setText(Double.toString(number)+" ^ ");
                num.setText("");
                operation =7;
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Enter a Number",Toast.LENGTH_SHORT).show();
            }
        }
        if(v.getId() == R.id.factorial)
        {
            if(!num.getText().toString().equals(""))
            {
                num_fact= Integer.parseInt(num.getText().toString());
                value = factorial(num_fact);
                result.setText(Integer.toString(num_fact)+"! = "+Integer.toString(value));
                num.setText("");
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Enter a Number",Toast.LENGTH_SHORT).show();
            }
        }
        if(v.getId() == R.id.equal)
        {
            operate(operation);
        }
    }
}
