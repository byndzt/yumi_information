package choose;
        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.text.method.ScrollingMovementMethod;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import com.example.administrator.main.R;

        import org.apache.poi.hssf.usermodel.HSSFDateUtil;
        import org.apache.poi.ss.usermodel.Cell;
        import org.apache.poi.ss.usermodel.CellValue;
        import org.apache.poi.ss.usermodel.FormulaEvaluator;
        import org.apache.poi.ss.usermodel.Row;
        import org.apache.poi.ss.util.WorkbookUtil;
        import org.apache.poi.xssf.usermodel.XSSFSheet;
        import org.apache.poi.xssf.usermodel.XSSFWorkbook;
        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.InputStream;
        import java.io.OutputStream;
        import java.text.SimpleDateFormat;
/**
 * Created by Administrator on 2022/4/11.查询所有信息
 */
public class select_All_Activity extends Activity {
    //EditText output;
    TextView textview;
    static String province;
    static String city;
    static  String countryside;
    static  String north_input;
    static  String south_input;
    static  String west_input;
    static  String east_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_all);
        //output = (EditText) findViewById(R.id.textOut);
        textview = (TextView) findViewById(R.id.textview);
    }
    /**
     * 读出全部数据
     * @param view
     */
    public void onReadClick(View view) {
        printlnToUser("正在读取全部数据......");
        InputStream stream = getResources().openRawResource(R.raw.test3);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowsCount = sheet.getPhysicalNumberOfRows();//计算行数
            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
            for (int r = 0; r<rowsCount; r++) {//行数
                Row row = sheet.getRow(r);
                int cellsCount = row.getPhysicalNumberOfCells();//计算列数
                String cunshu[] = new String[14];//用数组存入这一行数据
                province=getIntent().getStringExtra("city1");
                city=getIntent().getStringExtra("city2");
                countryside=getIntent().getStringExtra("countryside");
                for (int c = 0; c<cellsCount; c++) {
                    String value = getCellAsString(row, c, formulaEvaluator);
                    cunshu[c]=value;
                    int a=r+1;
                    int b=c+1;
                    String cellInfo = "行:"+a+"; 列:"+b+"; value:"+value;
                    if(c==13) {
                        textview.append("城市:" + cunshu[0] + "\n\n");
                        textview.append("县区:" + cunshu[1] + "\n\n");
                        textview.append("乡镇:" + cunshu[2] + "\n\n");
                        textview.append("南端纬度:" + cunshu[3] + "\n\n");
                        textview.append("北端纬度:" + cunshu[4] + "\n\n");
                        textview.append("西端经度:" + cunshu[5] + "\n\n");
                        textview.append("东端经度:" + cunshu[6] + "\n\n");
                        textview.append("太阳总辐射(MJ/m**2/a):" + "   " + cunshu[7] + "\n\n");
                        textview.append("10℃以上活动积温(℃·d):" + "   " + cunshu[8] + "\n\n");
                        textview.append("年降水量(mm/a):" + "   " + cunshu[9] + "\n\n");
                        textview.append("积温带划分:" + "   " + cunshu[10] + "\n\n");
                        textview.append("籽粒用玉米:" + "   " + cunshu[11] + "\n\n");
                        textview.append("青贮玉米:" + "   " + cunshu[12] + "\n\n");
                        textview.append("鲜食玉米:" + "   " + cunshu[13] + "\n\n");
                    }
                }
            }
        }catch (Exception e) {
            /* proper exception handling to be here */
            printlnToUser(e.toString());
        }
    }
    public void qingchuwenben(View view) {
        printlnToUser("正在清除文本显示......");
        textview.setText("");


    }
    protected String getCellAsString(Row row, int c, FormulaEvaluator formulaEvaluator) {
        String value = "";
        try {
            Cell cell = row.getCell(c);
            CellValue cellValue = formulaEvaluator.evaluate(cell);
            switch (cellValue.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    value = ""+cellValue.getBooleanValue();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    double numericValue = cellValue.getNumberValue();
                    if(HSSFDateUtil.isCellDateFormatted(cell)) {
                        double date = cellValue.getNumberValue();
                        SimpleDateFormat formatter =
                                new SimpleDateFormat("dd/MM/yy");
                        value = formatter.format(HSSFDateUtil.getJavaDate(date));
                    } else {
                        value = ""+numericValue;
                    }
                    break;
                case Cell.CELL_TYPE_STRING:
                    value = ""+cellValue.getStringValue();
                    break;
                default:
            }
        } catch (NullPointerException e) {
            /* proper error handling should be here */
            printlnToUser(e.toString());
        }
        return value;
    }
    /**
     * 在edittext上边显示全部excel表格信息
     * @param str
     */
    private void printlnToUser(String str) {
        final String string = str;
/*//限制输出
        if (output.length()>8000) {
           CharSequence fullOutput = output.getText();
            //CharSequence fullOutput = textview.getText();
            fullOutput = fullOutput.subSequence(5000,fullOutput.length());
            output.setText(fullOutput);
            //textview.setText(fullOutput);
            output.setSelection(fullOutput.length());
        }
*/     textview.setMovementMethod(ScrollingMovementMethod.getInstance());
        textview.append(string+"\n");
        //output.append(string+"\n");
        //textview.append(string+"\n");
    }

}
