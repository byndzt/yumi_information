package choose;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.main.R;

import Area.select_Area_Activity;
import Myself_information.gerenxinxi_Activity;
import jingweidu.select_jingweidu_Activity;

/**
 * Created by Administrator on 2022/4/12.
 * 主界面选择您所要进行的操作
 */
public class chooseActivity extends Activity {
    Button select_all,select_area,select_jingweidu;
    private ImageView shouye_img,chaxun_xinxi_img,wode_img;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_xiugai2);
        select_all=(Button)findViewById(R.id.button1);
        select_area=(Button)findViewById(R.id.button2);
        select_jingweidu=(Button)findViewById(R.id.button3);
        chaxun_xinxi_img= (ImageView) findViewById(R.id.chaxun_xinxi_img);
        shouye_img=(ImageView)findViewById(R.id.shouye_img);
        wode_img=(ImageView)findViewById(R.id.wode_img);
        /**
         * 设置按钮灰色
         */
        shouye_img.setImageResource(R.drawable.shoyye_hou);
        //chaxun_xinxi_img.setImageResource(R.drawable.shoyye_hou);
        wode_img.setImageResource(R.drawable.wode_hou);

        shouye_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(chooseActivity.this, gerenxinxi_Activity.class);
                startActivity(intent);
            }
        });
        chaxun_xinxi_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(chooseActivity.this, chooseActivity.class);
                startActivity(intent);
            }
        });
        wode_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(chooseActivity.this, gerenxinxi_Activity.class);
                startActivity(intent);
            }
        });
        select_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(chooseActivity.this,"已点击,进入全部信息查询！",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(chooseActivity.this, select_All_Activity.class);
                startActivity(intent);
            }
        });
        select_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(chooseActivity.this,"已点击,进入地区查询！",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(chooseActivity.this, select_Area_Activity.class);
                startActivity(intent);
            }
        });
        select_jingweidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(chooseActivity.this,"已点击,进入经纬度查询！",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(chooseActivity.this, select_jingweidu_Activity.class);
                startActivity(intent);
            }
        });
    }
}
