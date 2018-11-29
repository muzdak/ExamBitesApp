//package education.exambites;
//
//import android.content.Intent;
//import android.graphics.Color;
//import android.os.CountDownTimer;
//import android.os.Handler;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import education.exambites.Model.Question;
//
//public class recoveryQuiz extends AppCompatActivity {
//    TextView questionTxt, timerText;
//    Button option1, option2, option3, option4, SubmitBtn;
//    int total = 0;
//    int correct = 0;
//    int wrong = 0;
//    DatabaseReference reference;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.quiz_layout);
//        questionTxt = (TextView) findViewById(R.id.questionTxt);
//        option1 = (Button) findViewById(R.id.optionA);
//        option2 = (Button) findViewById(R.id.optionB);
//        option3 = (Button) findViewById(R.id.optionC);
//        option4 = (Button) findViewById(R.id.optionD);
//        timerText = (TextView) findViewById(R.id.timerTxt);
//        SubmitBtn = (Button) findViewById(R.id.submitBtn);
//        updateQuestion();
//        //   reverseTimer(30,timerText);
//    }
//
//    private void updateQuestion() {
//        total = total + 1;
//        if (total > 4) {
//
//        }
//        else {
//            reference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
//            reference.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//
//                    //    try {
//                    final Question question =dataSnapshot.getValue(Question.class);
//                    // final Question question = dataSnapshot.getValue(Question.class);
//                    questionTxt.setText(question.getQuestions());
//                    option1.setText(question.getOption1());
//                    option2.setText(question.getOption2());
//                    option3.setText(question.getOption3());
//                    option4.setText(question.getOption4());
//
//                    option1.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            if (option1.getText().toString().equals(question.getAnswer())) {
//                                option1.setBackgroundColor(Color.GREEN);
//                                Handler handler = new Handler();
//                                handler.postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//
//                                        correct = correct + 1;
//                                        option1.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        updateQuestion();
//                                    }
//                                }, 1500);
//                            } else {
//                                wrong = wrong + 1;
//                                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
//                                option1.setBackgroundColor(Color.RED);
//
//                                if (option2.getText().toString().equals(question.getAnswer())) {
//                                    option2.setBackgroundColor(Color.GREEN);
//                                } else if (option3.getText().toString().equals(question.getAnswer())) {
//                                    option3.setBackgroundColor(Color.GREEN);
//                                } else if (option4.getText().toString().equals(question.getAnswer())) {
//                                    option4.setBackgroundColor(Color.GREEN);
//                                }
//
//                                Handler handler = new Handler();
//                                handler.postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//
//                                        option1.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        option2.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        option3.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        option4.setBackgroundColor(Color.parseColor("#03A9F4"));
//
//                                    }
//                                }, 1500);
//
//
//                            }
//                        }
//                    });
//
//
//                    option2.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            if (option2.getText().toString().equals(question.getAnswer())) {
//                                option2.setBackgroundColor(Color.GREEN);
//                                Handler handler = new Handler();
//                                handler.postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//
//                                        correct = correct + 1;
//                                        option2.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        updateQuestion();
//                                    }
//                                }, 1500);
//                            } else {
//                                wrong = wrong + 1;
//                                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
//                                option2.setBackgroundColor(Color.RED);
//
//                                if (option1.getText().toString().equals(question.getAnswer())) {
//                                    option1.setBackgroundColor(Color.GREEN);
//                                } else if (option3.getText().toString().equals(question.getAnswer())) {
//                                    option3.setBackgroundColor(Color.GREEN);
//                                } else if (option4.getText().toString().equals(question.getAnswer())) {
//                                    option4.setBackgroundColor(Color.GREEN);
//                                }
//
//                                Handler handler = new Handler();
//                                handler.postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//
//                                        option1.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        option2.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        option3.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        option4.setBackgroundColor(Color.parseColor("#03A9F4"));
//
//                                    }
//                                }, 1500);
//
//
//                            }
//                        }
//                    });
//
//
//                    option3.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            if (option3.getText().toString().equals(question.getAnswer())) {
//                                option3.setBackgroundColor(Color.GREEN);
//                                Handler handler = new Handler();
//                                handler.postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//
//                                        correct = correct + 1;
//                                        option3.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        updateQuestion();
//                                    }
//                                }, 1500);
//                            } else {
//                                wrong = wrong + 1;
//                                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
//                                option3.setBackgroundColor(Color.RED);
//
//                                if (option1.getText().toString().equals(question.getAnswer())) {
//                                    option1.setBackgroundColor(Color.GREEN);
//                                } else if (option2.getText().toString().equals(question.getAnswer())) {
//                                    option2.setBackgroundColor(Color.GREEN);
//                                } else if (option4.getText().toString().equals(question.getAnswer())) {
//                                    option4.setBackgroundColor(Color.GREEN);
//                                }
//
//                                Handler handler = new Handler();
//                                handler.postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//
//                                        option1.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        option2.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        option3.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        option4.setBackgroundColor(Color.parseColor("#03A9F4"));
//
//                                    }
//                                }, 1500);
//
//
//                            }
//
//
//                        }
//                    });
//
//
//                    option4.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            if (option4.getText().toString().equals(question.getAnswer())) {
//                                option4.setBackgroundColor(Color.GREEN);
//                                Handler handler = new Handler();
//                                handler.postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//
//                                        correct = correct + 1;
//                                        option4.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        updateQuestion();
//                                    }
//                                }, 1500);
//                            } else {
//                                wrong = wrong + 1;
//                                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
//                                option4.setBackgroundColor(Color.RED);
//
//                                if (option1.getText().toString().equals(question.getAnswer())) {
//                                    option1.setBackgroundColor(Color.GREEN);
//                                } else if (option2.getText().toString().equals(question.getAnswer())) {
//                                    option2.setBackgroundColor(Color.GREEN);
//                                } else if (option3.getText().toString().equals(question.getAnswer())) {
//                                    option3.setBackgroundColor(Color.GREEN);
//                                }
//
//                                Handler handler = new Handler();
//                                handler.postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//
//                                        option1.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        option2.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        option3.setBackgroundColor(Color.parseColor("#03A9F4"));
//                                        option4.setBackgroundColor(Color.parseColor("#03A9F4"));
//
//                                    }
//                                }, 1500);
//
//
//                            }
//                        }
//                    });
//
//
//                }// catch (Exception ex) {
//                //  Log.d("QuizActivity", "onDataChange: " + ex.getMessage(), ex);
//                // }
//                //}
//
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//
//                }
//            });
//        }
//    }
//}
//
//
