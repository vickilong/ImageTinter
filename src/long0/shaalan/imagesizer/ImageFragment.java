package long0.shaalan.imagesizer;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageFragment extends Fragment {
	
	private static ImageView sImage;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
							ViewGroup container, Bundle savedInstanceState) {
		//Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.image_fragment,
				container, false);
		sImage = (ImageView) view.findViewById(R.id.imageview);
		return view;
	}
	
	public void changeImageTint(int color, PorterDuff.Mode mode) {
		sImage.setColorFilter(color, mode);
	}

}
