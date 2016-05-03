package rqg.test.dashandmoveto;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TestView mTestView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTestView = (TestView) findViewById(R.id.test_view);

        initPath();
    }


    private void initPath() {
        ArrayList<Point> pointArrayList = new ArrayList<>();

        Random random = new Random(System.currentTimeMillis());


        int x = 0;
        int y = 400;

        for (int i = 0; i < 10; i++) {
            pointArrayList.add(new Point(x, y));
            x += random.nextInt(180);
            y = random.nextInt(400);
        }

        mTestView.setPath(pointArrayList);
    }

    public void switchPathEffect(View view) {
        mTestView.setEnablePathEffect(!mTestView.isEnablePathEffect());
    }
}
