package education.exambites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class ImageSlider extends AppCompatActivity {
ViewFlipper v_flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slider);

        int images[] = {R.drawable.sliderphysics, R.drawable.sliderchemistry, R.drawable.slidermath, R.drawable.sliderbiology};
        v_flipper= (ViewFlipper) findViewById(R.id.v_flipper);

        for(int image:images)
        {
            flipperImage(image);
        }
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
}
