package long0.shaalan.imagesizer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class InputFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater,
							ViewGroup container, Bundle savedInstanceState) {
		//Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.image_fragment,
				container, false);
		final EditText inputRed = (EditText) view.findViewById(R.id.edit_red);
		final EditText inputGreen = (EditText) view.findViewById(R.id.edit_green);
		final EditText inputBlue = (EditText) view.findViewById(R.id.edit_blue);
		return view;
	}

}
