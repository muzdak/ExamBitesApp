package education.exambites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Muzdak Afzal Butt on 11/7/2018.
 */

public class chapterG9 extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_grade9_chapter_layout);
        imageView=(ImageView)findViewById(R.id.imgChapter1);
    }
    public void chapter1(View view){
        Intent intent=new Intent(this,SelectLanguage.class);
        startActivity(intent);
    }
}
