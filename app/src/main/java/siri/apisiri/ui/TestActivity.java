package siri.apisiri.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import siri.apisiri.R;

public class TestActivity extends AppCompatActivity {

    RollPagerView mRollPagerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looptest);

        mRollPagerView = (RollPagerView)findViewById(R.id.roll_pager);

        mRollPagerView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(TestActivity.this, "Position : " + position, Toast.LENGTH_SHORT).show();
            }
        });

        mRollPagerView.setAdapter(new TestLoopAdapter(mRollPagerView));
        mRollPagerView.setHintView(new ColorPointHintView(this,
                ContextCompat.getColor(this, R.color.colorWhite),
                ContextCompat.getColor(this, R.color.colorWhite30)));
    }

    private class TestLoopAdapter extends LoopPagerAdapter {
        private int[] imgs = {
                R.drawable.aa,
                R.drawable.bb,
                R.drawable.cc,
                R.drawable.dd,
        };

        public TestLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }
    }
}
