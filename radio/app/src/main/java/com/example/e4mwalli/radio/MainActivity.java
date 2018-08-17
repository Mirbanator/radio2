package com.example.e4mwalli.radio;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar sb1;

    TextView number;
    TextView current;
    int saved1;
    int saved2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = (TextView) findViewById(R.id.taaj);
        current = (TextView) findViewById(R.id.current);
        sb1 = (SeekBar) findViewById(R.id.seekBar1); // Seekbar UI muuttuja

        sb1.setProgress(10);
        current.setText("10");  // astetaan SB:lle alkuarvo = 10
        sb1.setMax(100);

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // Asetaan Seekbar kuuntelija

            @Override
            /// kutsutaan kun seekbar arvo muuttuu
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {

                String st = String.valueOf(progresValue);
                current.setText(st);

            //  saved1.setText(st);

            }

            @Override
            // kutsutaan kun osoitetaan seekbariin
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            // kutsutaan kun seek osoitus loppuu
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
  /*          @Override
            public void onPress(SeekBar seekBar, int progresValue){
                String jj = String.copyValueOf(saved);
            }
*/
        });
    }

    // image button
    public void IB_vas_pit(View v)
    {

        number.setText("Radio ON");
        System.out.println(" Nuoli alas");

        // aanimerkki
        ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
        toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP, 500);

    }
    // image button
    public void Radio_on(View v)
    {
        number.setText(" Radio ON");
    }
  public void button(View v)
    {

        String presentS = current.getText().toString();
        int presentI = Integer.parseInt(presentS);
        ++presentI;
        current.setText(String.valueOf(presentI));
        sb1.setProgress(presentI);
    }
    public void button2(View v)
    {
        String presentS = current.getText().toString();
        int presentI = Integer.parseInt(presentS);
        presentI--;
        current.setText(String.valueOf(presentI));
        sb1.setProgress(presentI);
    }
    public void onRadioButtonClicked(View view) {
        // Tarkistaa onko radio nappi aktivoitu
        boolean checked = ((RadioButton) view).isChecked();

        // Tarkistaa, kumpi radio napeista on aktivoitu
        switch(view.getId()) {
            case R.id.ch1:
                if (checked) {
                    saved2 = Integer.parseInt(current.getText().toString());
                    current.setText(String.valueOf(saved1));
                   sb1.setProgress(saved2);

                    break;
                }
            case R.id.ch2:
                if (checked) {
                    saved1 = Integer.parseInt(current.getText().toString());
                    current.setText(String.valueOf(saved2));
                    sb1.setProgress(saved1);

                    break;
                }
        }
    }
}
