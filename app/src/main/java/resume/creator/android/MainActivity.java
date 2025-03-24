package resume.creator.android;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.FutureTarget;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private MainActivity main;
    private Drawable imageVelue;
    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private List<CardItem> cardItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cardItemList = new ArrayList<>();
        String imageUrl = "";
        String Text = "Test";
        main = this;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FutureTarget<Drawable> futureTarget = Glide.with(main)
                            .load(imageUrl)
                            .submit();
                    imageVelue = futureTarget.get();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            cardItemList.add(new CardItem(Text,imageVelue ));

                            cardAdapter = new CardAdapter(cardItemList);
                            recyclerView.setAdapter(cardAdapter);
                        }
                    });
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setContentView(R.layout.item_card);
                        }
                    });
                }
            }
        }).start();
    }
}