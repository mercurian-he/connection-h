package sxh.connection.activity;

//import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;

import sxh.connection.R;

public class SignUpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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

    public void register(View view) {

        //trick
        Intent it = new Intent(this,CreateCardActivity.class);
        startActivity(it);


        /*
        String email = ((EditText)findViewById(R.id.rg_email)).getText().toString();
        String pw1 = ((EditText)findViewById(R.id.rg_pw1)).getText().toString();
        String pw2 = ((EditText)findViewById(R.id.rg_pw2)).getText().toString();

        if(pw1.equals(pw2)){
            FunctionAccessor fa = new FunctionImpl();
            fa.user_register(email,pw1);
            Intent intent = new Intent(this,CreateCardActivity.class);
            startActivity(intent);
        }
        else {
            TextView t = (TextView)findViewById(R.id.rg_err_str);
            t.setText(R.string.pw_different_err);
        }
        */


    }

}
