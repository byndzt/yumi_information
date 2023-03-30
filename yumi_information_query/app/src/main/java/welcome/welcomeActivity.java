package welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.main.R;

/**
 * Created by Administrator on 2022/4/12.
 */

public class welcomeActivity extends Activity{
    ImageView imageview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        imageview=(ImageView) findViewById(R.id.welcome);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(welcomeActivity.this, zhuye_Activity.class);
                startActivity(intent);
            }
        });
    }
}
