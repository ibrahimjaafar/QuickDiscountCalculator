package apps.ibrahim.com.quickdiscountcalculator;

        import android.app.Activity;
        import android.os.Bundle;
        import android.widget.EditText;
        import android.widget.SeekBar;
        import android.widget.TextView;
        import android.widget.Toast;


public class MainActivity extends Activity {
    private SeekBar seekBar;
    private TextView sliderText;
    private TextView discountText;
    private TextView savingText;
    private EditText cost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar2);
        sliderText = (TextView) findViewById(R.id.textView4);
        discountText = (TextView) findViewById(R.id.textView);
        savingText = (TextView) findViewById(R.id.textView3);
        cost = (EditText) findViewById(R.id.editText2);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           int discount = 0;
           double percentage = 0;
           double total=0;
           double saving=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                discount = i*5;
                percentage = discount / 100.0;

                total = Double.parseDouble(cost.getText().toString());
                total = percentage * total;
                sliderText.setText(discount + "%");
                saving = Math.round(saving * 100);

                discountText.setText("After the discount $" + saving/100);
                saving = Double.parseDouble(cost.getText().toString()) - total;
                total = Math.round(total * 100);
                savingText.setText("You saved $" + total/100);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                percentage = discount / 100.0;

                total = Double.parseDouble(cost.getText().toString());
                total = percentage * total;
                sliderText.setText(discount + "%");
                saving = Math.round(saving * 100);

                discountText.setText("After the discount $" + saving/100);
                saving = Double.parseDouble(cost.getText().toString()) - total;
                total = Math.round(total * 100);
                savingText.setText("You saved $" + total/100);
            }
        });

    }
}
