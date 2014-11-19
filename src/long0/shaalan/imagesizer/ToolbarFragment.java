package long0.shaalan.imagesizer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ToolbarFragment extends Fragment implements OnSeekBarChangeListener {
	
	private static int sSeekValue = 10;
	
	ToolbarListener activityCallback;
	
	public interface ToolbarListener {
		public void onButtonClick(int position);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			activityCallback = (ToolbarListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement ToolbarListener");
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
							ViewGroup container, Bundle savedInstanceState) {
		//Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.toolbar_fragment, container, false);
		final SeekBar seekbar = (SeekBar) view.findViewById(R.id.toolbar);
		seekbar.setOnSeekBarChangeListener(this);
		final Button button = (Button) view.findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				buttonClicked(v);
			}
		});
		
		return view;
	}
	
	public void buttonClicked (View view) {
		activityCallback.onButtonClick(sSeekValue);
	}
	
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
								boolean fromUser) {
		sSeekValue = progress;
	}
	
	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		//empty
	}
	
	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		//empty
	}

}
