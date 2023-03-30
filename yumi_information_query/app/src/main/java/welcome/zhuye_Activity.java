package welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.main.R;

import Myself_information.gerenxinxi_Activity;
import choose.chooseActivity;

/**
 * Created by Administrator on 2022/4/12.
 * 主界面选择您所要进行的操作
 */
public class zhuye_Activity extends Activity {
    private ImageView shouye_img,chaxun_xinxi_img,wode_img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuye);
        chaxun_xinxi_img= (ImageView) findViewById(R.id.chaxun_xinxi_img);
        shouye_img=(ImageView)findViewById(R.id.shouye_img);
        wode_img=(ImageView)findViewById(R.id.wode_img);
        /**
         * 设置按钮灰色
         */
        //shouye_img.setImageResource(R.drawable.shoyye_hou);
        chaxun_xinxi_img.setImageResource(R.drawable.sousuo_hou);
        wode_img.setImageResource(R.drawable.wode_hou);

      shouye_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(zhuye_Activity.this, zhuye_Activity.class);
                startActivity(intent);
            }
        });
        chaxun_xinxi_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(zhuye_Activity.this, chooseActivity.class);
                startActivity(intent);
            }
        });
        wode_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(zhuye_Activity.this, gerenxinxi_Activity.class);
                startActivity(intent);
            }
        });
    }
}
