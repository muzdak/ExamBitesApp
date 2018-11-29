package education.exambites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SelectLanguage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_language_layout);

    }
    public void english(View view){
        Intent intent=new Intent(this,VideoPlayerMainActivity.class);
        startActivity(intent);
    }
    public void urdu(View view){
        Intent intent=new Intent(this,VideoPlayerMainActivity.class);
        startActivity(intent);
    }
}