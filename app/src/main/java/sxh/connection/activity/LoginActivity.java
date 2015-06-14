package sxh.connection.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import sxh.connection.R;
import sxh.connection.data.DataAccessor;
import sxh.connection.data.HttpAccessor;
import sxh.connection.data.MongoHQ.SaveAsyncTask;
import sxh.connection.function.FunctionAccessor;
import sxh.connection.function.FunctionImpl;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /**
     * some test code by ChadSang
     */
    private void testByChad() {
        System.out.println("init");
        DataAccessor da = new HttpAccessor();

        System.out.println("try");
        da.add_user("i@chadsang.me", "mypassword");
        System.out.println("finish");
    }

    //called when the user pushed sign in button
    public void signIn(View view) {
        //
        // testByChad();
        FunctionAccessor fa = new FunctionImpl();
        EditText email = (EditText) findViewById(R.id.login_email);
        EditText password = (EditText) findViewById(R.id.login_password);
        String email_str = email.getText().toString();
        String password_str = password.getText().toString();
        // if(fa.user_login(email_str,password_str)) {
        Intent intent = new Intent(this, CardHolderActivity.class);
        startActivity((intent));
        //  }
    }

    //called when user pushed sign up button
    public void signUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
