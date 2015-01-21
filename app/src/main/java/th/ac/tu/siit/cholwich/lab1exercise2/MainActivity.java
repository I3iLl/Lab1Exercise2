package th.ac.tu.siit.cholwich.lab1exercise2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void buttonClick(View v){
        EditText etInput = (EditText)findViewById(R.id.etInput);
        String s = etInput.getText().toString();
        Double tem = Double.parseDouble(s);

        RadioGroup rgFrom = (RadioGroup)findViewById(R.id.rgFrom);
        int selFrom = rgFrom.getCheckedRadioButtonId();

        RadioGroup rgTo = (RadioGroup)findViewById(R.id.rgTo);
        int selTo = rgTo.getCheckedRadioButtonId();

        if(selFrom == R.id.rbFrmC){

            if(selTo == R.id.rbToC){
                //tem = tem;
            }
            else if(selTo == R.id.rbToF){
                tem = (tem * 9/5) + 32;
            }
            else if(selTo == R.id.rbToK){
                tem = tem + 273.15;
            }
        }

        else if(selFrom == R.id.rbFrmF){

            if(selTo == R.id.rbToC){
                tem = (tem - 32) * 5/9;
            }
            else if(selTo == R.id.rbToF){
                //tem = tem;
            }
            else if(selTo == R.id.rbToK){
                tem = ((tem - 32) * 5/9) + 273.15;
            }
        }

        else if(selFrom == R.id.rbFrmK){

            if(selTo == R.id.rbToC){
                tem = tem - 273.15;
            }
            else if(selTo == R.id.rbToF){
                tem = (((tem - 273.15) * 9)/5)+ 32;
            }
            else if(selTo == R.id.rbToK){
                //tem = tem;
            }
        }

        TextView tv = (TextView)findViewById(R.id.tvOutput);
        tv.setText(String.format("%.2f",tem));
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
}
