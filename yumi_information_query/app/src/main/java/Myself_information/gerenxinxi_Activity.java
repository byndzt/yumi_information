package Myself_information;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.main.R;

import choose.chooseActivity;

/**
 * Created by Administrator on 2022/7/28.
 */

public class gerenxinxi_Activity extends Activity{
    private ImageView shouye_img,chaxun_xinxi_img,wode_img;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gerenxinxi_zhujiemian);
        chaxun_xinxi_img= (ImageView) findViewById(R.id.chaxun_xinxi_img);
        shouye_img=(ImageView)findViewById(R.id.shouye_img);
        wode_img=(ImageView)findViewById(R.id.wode_img);
        /**
         * 设置按钮灰色
         */
        shouye_img.setImageResource(R.drawable.shoyye_hou);
        chaxun_xinxi_img.setImageResource(R.drawable.sousuo_hou);
        //wode_img.setImageResource(R.drawable.wode_hou);
        shouye_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(gerenxinxi_Activity.this, chooseActivity.class);
                startActivity(intent);
            }
        });
        chaxun_xinxi_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(gerenxinxi_Activity.this, chooseActivity.class);
                startActivity(intent);
            }
        });
        wode_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(gerenxinxi_Activity.this, gerenxinxi_Activity.class);
                startActivity(intent);
            }
        });
    }
}
