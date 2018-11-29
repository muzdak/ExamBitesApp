package education.exambites;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import education.exambites.Model.Question;

public class quiz extends AppCompatActivity {
    TextView questionTxt;
    TextView timerText;
    Button option1;
    Button option2;
    Button option3;
    Button option4;
    Button submitBtn;
    Button QuizQuit;
    int total = 0;
    int correct = 0;
    int wrong = 0;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);
      questionTxt = (TextView) findViewById(R.id.questionTxt);
     option1 = (Button) findViewById(R.id.optionA);
        option2 = (Button) findViewById(R.id.optionB);
       option3 = (Button) findViewById(R.id.optionC);
        option4 = (Button) findViewById(R.id.optionD);
        timerText = (TextView) findViewById(R.id.timerTxt);
       submitBtn = (Button) findViewById(R.id.submitBtn);
        QuizQuit= (Button)findViewById(R.id.QuizQuitBtn);
     updateQuestion();

    }

    public void QuitQuiz(View view) {
        Intent i= new Intent(this,MainActivity.class);
        startActivity(i);
    }


    private void updateQuestion() {
        ++total;
        if(total>4){

            Intent i =new Intent(this,resultActivity.class);
            i.putExtra("total",String.valueOf(total-1));
            i.putExtra("correct",String.valueOf(correct));
            i.putExtra("incorrect",String.valueOf(wrong));
            startActivity(i);
                }



        else{
            reference=FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                final Question question = dataSnapshot.getValue(Question.class);

                    questionTxt.setText(question.getQuestions());
                    option1.setText(question.getOption1());
                    option2.setText(question.getOption2());
                    option3.setText(question.getOption3());
                    option4.setText(question.getOption4());

                option1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (option1.getText().toString().equals(question.getAnswer()))
                        {   option1.setBackgroundColor(Color.GREEN);
                            Handler handler =new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    correct=correct+1;
                                    option1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    updateQuestion();

                                }
                            },1500);
                        }
                        //IF  answer is wrong
                        else {
                            wrong=wrong+1;
                            option1.setBackgroundColor(Color.RED);

//                            Handler handler =new Handler();
//                            handler.postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//                                    updateQuestion();
//                                }
//                            },1000);


                            if(option2.getText().toString().equals(question.getAnswer()))
                            {
                                option2.setBackgroundColor(Color.GREEN);

                            }
                            else if (option3.getText().toString().equals(question.getAnswer()))
                            {
                                option3.setBackgroundColor(Color.GREEN);

                            }
                            else if(option4.getText().toString().equals(question.getAnswer()))
                            {
                                option4.setBackgroundColor(Color.GREEN);

                            }
                          //  updateQuestion();
                            Handler handler= new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    option1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    option2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    option3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    option4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                updateQuestion();
                                }
                            },1500);

                        }
                    }
                });


                    option2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (option2.getText().toString().equals(question.getAnswer()))
                            {   option2.setBackgroundColor(Color.GREEN);
                                Handler handler =new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct=correct+1;
                                        option2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                },1500);
                            }
                            else {
                                wrong=wrong+1;
                                option2.setBackgroundColor(Color.RED);


                                if(option1.getText().toString().equals(question.getAnswer()))
                                {
                                    option1.setBackgroundColor(Color.GREEN);
                                }
                                else if (option3.getText().toString().equals(question.getAnswer()))
                                {
                                    option3.setBackgroundColor(Color.GREEN);
                                }
                                else if(option4.getText().toString().equals(question.getAnswer()))
                                {
                                    option4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler= new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        option1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        option4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },1500);

                            }
                        }
                    });



                option3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (option3.getText().toString().equals(question.getAnswer()))
                        {   option3.setBackgroundColor(Color.GREEN);
                            Handler handler =new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    correct=correct+1;
                                    option3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    updateQuestion();

                                }
                            },1500);
                        }
                        else {
                            wrong=wrong+1;
                            option3.setBackgroundColor(Color.RED);

                            if(option1.getText().toString().equals(question.getAnswer()))
                            {
                                option1.setBackgroundColor(Color.GREEN);
                            }
                            else if (option2.getText().toString().equals(question.getAnswer()))
                            {
                                option2.setBackgroundColor(Color.GREEN);
                            }
                            else if(option4.getText().toString().equals(question.getAnswer()))
                            {
                                option4.setBackgroundColor(Color.GREEN);
                            }

                            Handler handler= new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    option1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    option2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    option3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    option4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    updateQuestion();
                                }
                            },1500);

                        }
                    }
                });


             option4.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if (option4.getText().toString().equals(question.getAnswer()))
                     {   option4.setBackgroundColor(Color.GREEN);
                         Handler handler =new Handler();
                         handler.postDelayed(new Runnable() {
                             @Override
                             public void run() {
                                 correct=correct+1;
                                 option4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                 updateQuestion();

                             }
                         },1500);
                     }
                     else {
                         wrong=wrong+1;
                         option4.setBackgroundColor(Color.RED);

                         if(option1.getText().toString().equals(question.getAnswer()))
                         {
                             option1.setBackgroundColor(Color.GREEN);
                         }
                         else if (option2.getText().toString().equals(question.getAnswer()))
                         {
                             option2.setBackgroundColor(Color.GREEN);
                         }
                         else if(option3.getText().toString().equals(question.getAnswer()))
                         {
                             option3.setBackgroundColor(Color.GREEN);
                         }

                         Handler handler= new Handler();
                         handler.postDelayed(new Runnable() {
                             @Override
                             public void run() {
                                 option1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                 option2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                 option3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                 option4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                 updateQuestion();
                             }
                         },1500);

                     }
                 }
             });


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }
    }
}

