package education.exambites;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
DrawerLayout drawerLayout;
    ViewFlipper v_flipper;
    ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int images[] = {R.drawable.sliderphysics, R.drawable.sliderchemistry, R.drawable.slidermath, R.drawable.sliderbiology};
        v_flipper= (ViewFlipper) findViewById(R.id.v_flipper);
        for(int image:images)
        {
            flipperImage(image);
        }
    toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }
    public void flipperImage(int image)
    {
        ImageView imageview= new ImageView(this);
        imageview.setBackgroundResource(image);

        v_flipper.addView(imageview);
        v_flipper.setFlipInterval(5000);
        v_flipper.setAutoStart(true);
        //animation
        v_flipper.setInAnimation(this, android.R.anim.fade_in);
        //v_flipper.setInAnimation(this, android.R.anim.fade_out);
    }

//    public void quiz(View view){
//        Intent intent=new Intent(this,quiz.class);
//        startActivity(intent);
//    }

//    public void chemistryClick(View view){
//        Intent intent =new Intent(this,SelectLanguage.class);
//        startActivity(intent);
//
//    }
//    public void mathClick(View view){
//        Intent intent =new Intent(this,SelectLanguage.class);
//        startActivity(intent);

//    }
//    public void biologyClick(View view){
//        Intent intent =new Intent(this,SelectLanguage.class);
//        startActivity(intent);
//
//    }
    public void physicsClick(View view){
        Intent intent =new Intent(this,chapterG9.class);
        startActivity(intent);

    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();

    }




}


