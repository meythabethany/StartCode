package id.sch.smktelkom_mlg.www.startcode;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    public int[] slide_image = {
            R.drawable.people,
            R.drawable.book,
            R.drawable.pc
    };
    public String[] slide_heading = {
            "Testimonial",
            "Material Code",
            "Programming"
    };
    public String[] slide_desc = {
            "Anda dan semua orang dapat meninggalkan pesan testimoni pada aplikasi",
            "Tersedia juga modul-modul dan juga berupa kuis yang akan membantu anda dalam pembelajaran",
            "Pembelajaran mengenai bahasa-bahasa pemrograman"
    };
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_slider_adapter, container, false);

        ImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.slide_heading);
        TextView slideDescription = view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_image[position]);
        slideHeading.setText(slide_heading[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
