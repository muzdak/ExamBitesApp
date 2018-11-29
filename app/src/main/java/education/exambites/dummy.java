package education.exambites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import qdx.bezierviewpager_compile.BezierRoundView;
import qdx.bezierviewpager_compile.vPage.BezierViewPager;
import qdx.bezierviewpager_compile.vPage.CardPagerAdapter;

/**
 * Created by Muzdak Afzal Butt on 11/22/2018.
 */

public class dummy extends AppCompatActivity {
    ArrayList listImages = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        buildImageList();
        CardPagerAdapter cardAdapter = new CardPagerAdapter(this);
        cardAdapter.addImgUrlList(listImages);
        BezierViewPager view_pager = (BezierViewPager)findViewById(R.id.viewpager);
        view_pager.setAdapter(cardAdapter);

        BezierRoundView round_view = (BezierRoundView)findViewById(R.id.round_view);
        round_view.attach2ViewPage(view_pager);
    }

    private void buildImageList() {
        listImages.add("https://safiramericanschool.com/wp-content/uploads/2018/07/file-20171025-25516-g7rtyl.jpg");
        listImages.add("http://www.evrenselkolej.k12.tr/wp-content/uploads/2018/06/kimya-resim.jpg");
        listImages.add("https://www.jagranjosh.com/imported/images/E/Articles/maths2.jpg");
        listImages.add("https://groves.christian.college/wp-content/uploads/2018/08/biology-pic.jpg");
    }
}
