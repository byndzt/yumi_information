package jingweidu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.main.R;

import Area.select_Area_Activity;

/**
 * Created by Administrator on 2022/4/11.这里是经纬度的输入界面
 */
public class select_jingweidu_Activity extends Activity {
    TextView jingdu,weidu;
    EditText edit_jingdu,edit_weidu;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinweidu_input);
        //output = (EditText) findViewById(R.id.textOut);
        jingdu = (TextView) findViewById(R.id.jingdu);
        weidu=(TextView) findViewById(R.id.weidu);
        button=(Button)findViewById(R.id.tiaozhuan_jingweidu);
        edit_jingdu=(EditText) findViewById(R.id.edit_jingdu);
        edit_weidu=(EditText) findViewById(R.id.edit_weidu);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit_jingdu1=edit_jingdu.getText().toString();//传经度
                String edit_weidu1=edit_weidu.getText().toString();//传纬度
                Toast.makeText(select_jingweidu_Activity.this,"已点击,正在跳转！",Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(select_jingweidu_Activity.this, select_jingweidu_Activity_show.class);
                startActivity(intent);
                intent.putExtra("jingdu",edit_jingdu1);
                intent.putExtra("weidu",edit_weidu1);
                startActivity(intent);
            }
        });
    }

}
