//**************************************************************
//  InputFragment.java     Vicki Long and Nadine Shaalan
//
//  InputFragment holds several EditTexts that allow the user
//  to change the tint of the image in ImageFragment.
//**************************************************************

package long0.shaalan.imagesizer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputFragment extends Fragment {
	private static int mRedValue, mGreenValue, mBlueValue;
	
	ButtonListener mCallback;
	
	public interface ButtonListener {
		public void onButtonClick(int color);
	}
	
	@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (ButtonListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement ButtonListener");
        }
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater,
							ViewGroup container, Bundle savedInstanceState) {
		//Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.input_fragment,
				container, false);
		final Button tintButton = (Button) view.findViewById(R.id.button);
		final EditText inputRed = (EditText) view.findViewById(R.id.edit_red);
		final EditText inputGreen = (EditText) view.findViewById(R.id.edit_green);
		final EditText inputBlue = (EditText) view.findViewById(R.id.edit_blue);
		
		mRedValue = 0;
		mGreenValue = 0;
		mBlueValue = 0;
		
		//When the button is pressed, a Color as an integer is constructed using the
		//values in the EditTexts.
		tintButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mRedValue = Integer.parseInt(inputRed.getText().toString());
				mGreenValue = Integer.parseInt(inputGreen.getText().toString());
				mBlueValue = Integer.parseInt(inputBlue.getText().toString());
				int colorValue = convertInputToColor(mRedValue, mGreenValue, mBlueValue);
				buttonClicked(v, colorValue);
			}
		});
		
		return view;
	}
	
	//public int convertInputToColor (int red, int green, int blue)
	//Returns a Color in the form of an integer from rgb values
	public int convertInputToColor (int red, int green, int blue) {
		return Color.rgb(red, green, blue);
	}
	
	public void buttonClicked (View view, int color) {
		mCallback.onButtonClick(color);
	}

}
