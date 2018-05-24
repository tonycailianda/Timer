package timer.tonycai.com.timer;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean mSet = true;
    private Handler mHandler = new Handler();
    private boolean mStopHandler = false;
    int status=0;
    int sum=1;
    int sumStart =0;
    int noAdding =0;
   // boolean isTrue = false;
    int sumStartClick=0;
    private int mSeconds = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        ImageView im1 = findViewById(R.id.tens_digit);
        ImageView im2 = findViewById(R.id.unit_digit);
        im1.setImageDrawable(getResources().getDrawable(R.mipmap.zero));
        im2.setImageDrawable(getResources().getDrawable(R.mipmap.zero));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TextView tv = findViewById(R.id.hello_world_text);
                //tv.setText("Timer");
            }
        });
        Button startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                noAdding+=1;
                sumStart+=1;
                if (sumStart==2)
                {
                    mStopHandler=false;
                    sumStart=1;
                    Button pauseButton = findViewById(R.id.pause_button);
                    pauseButton.setText("Pause");
                }
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        //mStopHandler=false;
                        // do your stuff - don't create a new runnable here
                        mSeconds+=1;
                        if (!mStopHandler) {
                            mHandler.postDelayed(this, 1000);
                        }
                        ImageView im1 = findViewById(R.id.tens_digit);
                        ImageView im2 = findViewById(R.id.unit_digit);
                        //TextView tv = findViewById(R.id.timer_text);
                        //tv.setText(String.valueOf(mSeconds));
                        if (mSeconds%10==1)
                            im2.setImageDrawable(getResources().getDrawable(R.mipmap.one));
                        if (mSeconds%10==2)
                            im2.setImageDrawable(getResources().getDrawable(R.mipmap.two));
                        if (mSeconds%10==3)
                            im2.setImageDrawable(getResources().getDrawable(R.mipmap.three));
                        if (mSeconds%10==4)
                            im2.setImageDrawable(getResources().getDrawable(R.mipmap.four));
                        if (mSeconds%10==5)
                            im2.setImageDrawable(getResources().getDrawable(R.mipmap.five));
                        if (mSeconds%10==6)
                            im2.setImageDrawable(getResources().getDrawable(R.mipmap.six));
                        if (mSeconds%10==7)
                            im2.setImageDrawable(getResources().getDrawable(R.mipmap.seven));
                        if (mSeconds%10==8)
                            im2.setImageDrawable(getResources().getDrawable(R.mipmap.eight));
                        if (mSeconds%10==9)
                            im2.setImageDrawable(getResources().getDrawable(R.mipmap.nine));
                        if (mSeconds%10==0)
                            im2.setImageDrawable(getResources().getDrawable(R.mipmap.zero));

                        if (mSeconds/10==1)
                            im1.setImageDrawable(getResources().getDrawable(R.mipmap.one));
                        if (mSeconds/10==2)
                            im1.setImageDrawable(getResources().getDrawable(R.mipmap.two));
                        if (mSeconds/10==3)
                            im1.setImageDrawable(getResources().getDrawable(R.mipmap.three));
                        if (mSeconds/10==4)
                            im1.setImageDrawable(getResources().getDrawable(R.mipmap.four));
                        if (mSeconds/10==5)
                            im1.setImageDrawable(getResources().getDrawable(R.mipmap.five));
                        if (mSeconds/10==6)
                            im1.setImageDrawable(getResources().getDrawable(R.mipmap.six));
                        if (mSeconds/10==7)
                            im1.setImageDrawable(getResources().getDrawable(R.mipmap.seven));
                        if (mSeconds/10==8)
                            im1.setImageDrawable(getResources().getDrawable(R.mipmap.eight));
                        if (mSeconds/10==9)
                            im1.setImageDrawable(getResources().getDrawable(R.mipmap.nine));
                        if (mSeconds/10==0)
                            im1.setImageDrawable(getResources().getDrawable(R.mipmap.zero));
                    }
                };
                mHandler.post(runnable);

            }

        });

        final Button pauseButton = findViewById(R.id.pause_button);
        pauseButton.setText("Pause");
        pauseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                    if (sum==1)
                    {
                        mStopHandler=true;
                        pauseButton.setText("Reset");
                        mSeconds-=1;
                        sum+=1;
                      //  status=0;
                    }
                    else
                    if (sum==2&&noAdding==1)
                    {
                        ImageView im1 = findViewById(R.id.tens_digit);
                        ImageView im2 = findViewById(R.id.unit_digit);
                        im1.setImageDrawable(getResources().getDrawable(R.mipmap.zero));
                        im2.setImageDrawable(getResources().getDrawable(R.mipmap.zero));
                        pauseButton.setText("Pause");
                        mSeconds=0;
                        mStopHandler=false;
                        sum=0;
                        status=1;
                    }
                    else
                        if (noAdding!=1)
                        {
                            mStopHandler=true;
                            pauseButton.setText("Reset");
                            sum=2;
                            noAdding=1;
                            mSeconds-=1;
                           // status=0;
                        }
            }
            //}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
