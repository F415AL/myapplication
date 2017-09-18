package id.web.faisal.mygram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    TextView tvChangeMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvChangeMode = (TextView) findViewById(R.id.tvChangeMode);

        ParseInit();
}

    private void ParseInit() {
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("9c344d161a974bb20f0cbb5e869a455e2bacb9ef")
                .server("http://ec2-52-14-11-143.us-east-2.compute.amazonaws.com:80/parse")
                .build()
        );
    }

    public void BtnClicked(View view){

        ParseUser user = new ParseUser();
        user.setUsername(etUsername.getText().toString());
        user.setPassword(etPassword.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Toast.makeText(MainActivity.this, "BERHASIL", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "GAGAL", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        ParseObject obj = new ParseObject("Hobbies");
//        obj.put("nama","Faisal");
//        obj.put("hobbies","soccer");

//        obj.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if(e == null){
//                    Toast.makeText(MainActivity.this, "BERHASIL", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MainActivity.this, "GAGAL", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }

    public void ChangeMode (View view){

    }

    public void GoToHome(){

    }




}