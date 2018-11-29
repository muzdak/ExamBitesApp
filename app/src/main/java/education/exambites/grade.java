package education.exambites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class grade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_grade_layout);

    }
    public void nine(View view){
        Intent intent=new Intent(this,chapterG9.class);
        startActivity(intent);
    }
    public void ten(View view){
        Intent intent=new Intent(this,chapterG10.class);
        startActivity(intent);
    }
}