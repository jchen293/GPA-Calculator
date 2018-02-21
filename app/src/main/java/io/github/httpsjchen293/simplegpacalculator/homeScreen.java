package io.github.httpsjchen293.simplegpacalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/**
 * Created by Jack on 8/9/17.
 */
public class homeScreen extends AppCompatActivity implements RewardedVideoAdListener{
    Button college, hs, adButton;
    Spinner more;
    TextView display;
    private RewardedVideoAd mRewardedVideoAd;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        MobileAds.initialize(this, "ca-app-pub-7155890232460555~5886927750");
        adButton = findViewById(R.id.button2);
        adButton.setEnabled(false);

        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        mRewardedVideoAd.loadAd("ca-app-pub-7155890232460555/3396334087", new AdRequest.Builder().build());

        adButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adButton.setEnabled(false);
                if(mRewardedVideoAd.isLoaded()){
                    mRewardedVideoAd.show();
                }
            }
        });

        AdView adView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        AdView adView2 = (AdView)findViewById(R.id.adView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        adView2.loadAd(adRequest2);

        display = findViewById(R.id.display);
        college = (Button) findViewById(R.id.button2s);
        hs = (Button) findViewById(R.id.button);
        more = (Spinner) findViewById(R.id.spinner11);

        hs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeScreen.this, HsGpa.class);

                startActivity(intent);
            }
        });
        college.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeScreen.this, MainActivity.class);

                startActivity(intent);

            }
        });


        List<String> items = new ArrayList<String>();
        items.add("More");
        items.add("Contact");
        items.add("About");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        more.setAdapter(dataAdapter1);


        more.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) more.getSelectedItem().toString();

                if(str.equals("More")){

                }else if (str.equals("Contact")){
                 Intent intent = new Intent(homeScreen.this, contact.class);

                startActivity(intent);

                }else{
                    Intent intent = new Intent(homeScreen.this, about.class);

                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

    }

    @Override
    public void onRewardedVideoAdLoaded() {
        display.setText("Please watch a very short of video to support me, thank you very much!\n");
        adButton.setEnabled(true);
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        display.setText("Thanks for the support:)");

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        display.append("Thank you ver much");

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        display.append(" failed");

    }
}
