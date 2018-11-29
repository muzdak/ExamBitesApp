package education.exambites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {
TextView total1,correct,wrong;
    Button tryAgain_btn, nextToopic_btn, changeSubject_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        total1=(TextView)findViewById(R.id.dTotal);
        correct=(TextView)findViewById(R.id.dCorrect);
        wrong=(TextView)findViewById(R.id.dWrong);
        tryAgain_btn=(Button)findViewById(R.id.tryAgain_btn);
        nextToopic_btn=(Button)findViewById(R.id.nextTopic_btn);
        changeSubject_btn=(Button)findViewById(R.id.changeSubject_btn);

        Intent i= getIntent();
        String questions=i.getStringExtra("total");
        String correct1=i.getStringExtra("correct");
        String wrong1=i.getStringExtra("incorrect");

    total1.setText(questions);
    correct.setText(correct1);
    wrong.setText(wrong1);
    }

    public void tryAgain(View view)
    {
        Intent i= new Intent(this,quiz.class);
        startActivity(i);
    }

    public void nextTopic(View view)
    {
        Intent i=new Intent(this,chapterG9.class);
        startActivity(i);
    }

    public void changeSubject(View view)
    {
        Intent i= new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
