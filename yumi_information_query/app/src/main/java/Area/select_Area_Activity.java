package Area;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.main.R;

import choose.chooseActivity;


/**
 * @author ZMC
 * 三级联动主要是灵活的应用三维数组
 * 选择地区
 */
public class select_Area_Activity extends Activity {
    Spinner provincee, cityy;
    EditText countryside1, north_input1, south_input1, west_input1, east_input1;
    Button entry;

    private String province[] = new String[]{"哈尔滨市","大庆市","齐齐哈尔市","绥化市市","佳木斯市","双鸭山市","鹤岗市","鸡西市","七台河市","牡丹江市","黑河市","伊春市","大兴安岭地区"};
    private Spinner spinner1,spinner2,spinner3;


    private int provinceindex;
    private String city [][] = {{"道里区","南岗区","松北区","呼兰区","平房区","香坊区","五常市","道外区","阿城区","宾县","巴彦县","尚志市","木兰县","依兰县","延寿县","通河县","方正县"},
            {"肇源县","杜尔伯特蒙古族自治县","大同区","红岗区","让胡路区","龙凤区","萨尔图区","林甸县"},
            {"泰来县","龙江县","昂昂溪区","富拉尔基区","龙沙区","梅里斯达斡尔族区","铁峰区","建华区","富裕县","甘南县","依安县","富裕县","拜泉县","讷河市","碾子山区","克山县"},
            {"肇东市","安达市","兰西县","青冈县","北林区","让胡路区","望奎县","明水县","望奎县","海伦市","庆安县","绥棱县"},
            {"富锦市","桦川县","东风区","汤原县","郊区","桦南县","向阳区","同江市"},
            {"友谊县","集贤县","四方台区","尖山区","宝清县","岭东区","饶河县"},
            {"绥滨县","萝北县"},
            {"密山市","鸡东县","虎林市","城子河区","滴道区","鸡冠区","恒山区","梨树区","麻山区"},
            {"新兴区","勃利县","茄子河区","桃山区"},//七台河
            {"林口县","西安区","宁安市","爱民区","海林市","阳明区","穆棱市","林口县","绥芬河市"},
            {"北安市","五大连池市","嫩江县","逊克县","孙吴县","爱辉区"},
            {"铁力市","南岔区","嘉荫县","金山屯区","乌伊岭区","带岭区","汤旺河区","翠峦区","美溪区","友好区","乌马河区","伊春区","上甘岭区","五营区","红星区"},
            {"呼玛县","塔河县"}
    };
    //private String counstryside [][][] = {{{"青山湖区","南昌县"},{"章贡区","赣县"},{"长沙县","沙县"}},{{"长沙县","沙县"},{"湘潭县","象限"}}};
    ArrayAdapter<String> adapter1,adapter2,adapter3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_area);
        spinner1 = (Spinner) findViewById(R.id.spn);
        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,province);
        spinner1.setAdapter(adapter1);

        spinner2 = (Spinner)findViewById(R.id.city);
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,city[0]);
        spinner2.setAdapter(adapter2);

        //spinner3 = (Spinner)findViewById(R.id.counstryside);
        //adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,counstryside[0][0]);
        // spinner3.setAdapter(adapter3);
        spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub
                provinceindex = position;
                adapter2 = new ArrayAdapter<>(select_Area_Activity.this, android.R.layout.simple_dropdown_item_1line,city[position]);
                spinner2.setAdapter(adapter2);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });
        spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub

                // adapter3 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,counstryside[provinceindex][position]);
                //adapter3.notifyDataSetChanged();
                //   spinner3.setAdapter(adapter3);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
                //当时据为空的时候触发的
            }
        });
        /**
         * 确认之后跳转界面
         */
        provincee = (Spinner) findViewById(R.id.spn);
        cityy=(Spinner) findViewById(R.id.city);
        countryside1= (EditText) findViewById(R.id.edittext);
        entry=(Button) findViewById(R.id.entry);
        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city1=provincee.getSelectedItem().toString();//传城市
                String city2=cityy.getSelectedItem().toString();//传区域
                String countryside=countryside1.getText().toString();
                Toast.makeText(select_Area_Activity.this,"已点击,正在跳转！",Toast.LENGTH_SHORT).show();
//                String north_input1=north_input.getText().toString();
//                String south_input1=south_input.getText().toString();
//                String west_input1=west_input.getText().toString();
//                String east_input1=east_input.getText().toString();
                Intent intent =new Intent(select_Area_Activity.this, select_area_activity_show.class);
                startActivity(intent);
                intent.putExtra("city1",city1);
                intent.putExtra("city2",city2);
                intent.putExtra("countryside",countryside);
                startActivity(intent);
            }
        });
    }
}