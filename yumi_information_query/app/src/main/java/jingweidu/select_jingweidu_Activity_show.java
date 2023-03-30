package jingweidu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

import Area.select_area_activity_show;

/**
 * Created by Administrator on 2022/4/11.显示根据地区查询的值
 */
public class select_jingweidu_Activity_show extends Activity {
    //EditText output;
    TextView textview;
    static String jingdu;
    static String weidu;
    static String countryside;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_jingweidu_show);
        //output = (EditText) findViewById(R.id.textOut);
        textview = (TextView) findViewById(R.id.textview);
        /**
         * 查询操作
         */
    }

    /**
     * 按照经纬度读出全部数据
     *
     * @param view
     */
    public void show_value(View view) {
        printlnToUser("正在按照该地区经纬度进行数据读取......");
        InputStream stream = getResources().openRawResource(R.raw.test3);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowsCount = sheet.getPhysicalNumberOfRows();//计算行数
            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
            int flag=0;
            for (int r = 0; r < rowsCount; r++) {//行数
                Row row = sheet.getRow(r);
                int cellsCount = row.getPhysicalNumberOfCells();//计算列数
                String cunshu[] = new String[14];//用数组存入这一行数据
                jingdu = getIntent().getStringExtra("jingdu");
                weidu = getIntent().getStringExtra("weidu");
                for (int c = 0; c < cellsCount; c++) {
                    String value = getCellAsString(row, c, formulaEvaluator);
                    String cellInfo = "row:" + r + "; column:" + c + "; value:" + value;
                    cunshu[c] = value;
                    if (c == 13) {
                        if (Double.valueOf(cunshu[3])<=Double.valueOf(weidu)&&Double.valueOf(weidu)<=Double.valueOf(cunshu[4]) && Double.valueOf(cunshu[5])<= Double.valueOf(jingdu)&& Double.valueOf(jingdu)<=Double.valueOf(cunshu[6])) {
                            flag=1;
                            textview.setText("");
                            textview.append("该地区的所有信息:" + "\n\n");
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
                int n=rowsCount-1;
                if(r==n&&flag==0) {
                    Toast.makeText(select_jingweidu_Activity_show.this, "该经纬度输入信息有误，无法查询,请重新输入！", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {
            /* proper exception handling to be here */
            printlnToUser(e.toString());
        }
    }
    /**
     * 按照经纬度查询地区
     *
     * @param view
     */
    public void show_area(View view) {
        printlnToUser("正在按照该地区经纬度查询地区......");
        InputStream stream = getResources().openRawResource(R.raw.test3);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowsCount = sheet.getPhysicalNumberOfRows();//计算行数
            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
            for (int r = 0; r < rowsCount; r++) {//行数
                Row row = sheet.getRow(r);
                int cellsCount = row.getPhysicalNumberOfCells();//计算列数
                String cunshu[] = new String[14];//用数组存入这一行数据
                jingdu = getIntent().getStringExtra("jingdu");
                weidu = getIntent().getStringExtra("weidu");
                for (int c = 0; c < cellsCount; c++) {
                    String value = getCellAsString(row, c, formulaEvaluator);
                    String cellInfo = "row:" + r + "; column:" + c + "; value:" + value;
                    cunshu[c] = value;
                    if (c == 13) {
                        if (Double.valueOf(cunshu[3])<=Double.valueOf(weidu)&&Double.valueOf(weidu)<=Double.valueOf(cunshu[4]) && Double.valueOf(cunshu[5])<= Double.valueOf(jingdu)&& Double.valueOf(jingdu)<=Double.valueOf(cunshu[6])) {
                            textview.setText("");
                            textview.append("该经纬度下对应的地区如下:" + "\n\n");
                            textview.append("城市:" + cunshu[0] + "\n\n");
                            textview.append("县区:" + cunshu[1] + "\n\n");
                            textview.append("乡镇:" + cunshu[2] + "\n\n");

                        }
                    }
                }
            }
        } catch (Exception e) {
            /* proper exception handling to be here */
            printlnToUser(e.toString());
        }
    }
    /**
     * 按照经纬度查询10°以上活动积温
     *
     * @param view
     */
    public void show_jiwen(View view) {
        printlnToUser("正在按照该地区经纬度查询活动积温......");
        InputStream stream = getResources().openRawResource(R.raw.test3);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowsCount = sheet.getPhysicalNumberOfRows();//计算行数
            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
            for (int r = 0; r < rowsCount; r++) {//行数
                Row row = sheet.getRow(r);
                int cellsCount = row.getPhysicalNumberOfCells();//计算列数
                String cunshu[] = new String[14];//用数组存入这一行数据
                jingdu = getIntent().getStringExtra("jingdu");
                weidu = getIntent().getStringExtra("weidu");
                for (int c = 0; c < cellsCount; c++) {
                    String value = getCellAsString(row, c, formulaEvaluator);
                    String cellInfo = "row:" + r + "; column:" + c + "; value:" + value;
                    cunshu[c] = value;
                    if (c == 13) {
                        if (Double.valueOf(cunshu[3])<=Double.valueOf(weidu)&&Double.valueOf(weidu)<=Double.valueOf(cunshu[4]) && Double.valueOf(cunshu[5])<= Double.valueOf(jingdu)&& Double.valueOf(jingdu)<=Double.valueOf(cunshu[6])) {
                            textview.setText("");
                            textview.append("该经纬度下对应的活动积温如下:" + "\n\n");
                            textview.append("10℃以上活动积温(℃·d):" + "   " + cunshu[8] + "\n\n");
                        }
                    }
                }
            }
        } catch (Exception e) {
            /* proper exception handling to be here */
            printlnToUser(e.toString());
        }
    }
    /**
     * 按照经纬度查询积温带
     *
     * @param view
     */
    public void show_jiwendai(View view) {
        printlnToUser("正在按照该地区经纬度查询所属积温带......");
        InputStream stream = getResources().openRawResource(R.raw.test3);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowsCount = sheet.getPhysicalNumberOfRows();//计算行数
            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
            for (int r = 0; r < rowsCount; r++) {//行数
                Row row = sheet.getRow(r);
                int cellsCount = row.getPhysicalNumberOfCells();//计算列数
                String cunshu[] = new String[14];//用数组存入这一行数据
                jingdu = getIntent().getStringExtra("jingdu");
                weidu = getIntent().getStringExtra("weidu");
                for (int c = 0; c < cellsCount; c++) {
                    String value = getCellAsString(row, c, formulaEvaluator);
                    String cellInfo = "row:" + r + "; column:" + c + "; value:" + value;
                    cunshu[c] = value;
                    if (c == 13) {
                        if (Double.valueOf(cunshu[3])<=Double.valueOf(weidu)&&Double.valueOf(weidu)<=Double.valueOf(cunshu[4]) && Double.valueOf(cunshu[5])<= Double.valueOf(jingdu)&& Double.valueOf(jingdu)<=Double.valueOf(cunshu[6])) {
                            textview.setText("");
                            textview.append("该地区的积温带如下:" + "\n\n");
                            textview.append("积温带划分:" + "   " + cunshu[10] + "\n\n");
                        }
                    }
                }
            }
        } catch (Exception e) {
            /* proper exception handling to be here */
            printlnToUser(e.toString());
        }
    }
    /**
     * 按照经纬度查询籽粒用玉米
     *
     * @param view
     */
    public void show_zili(View view) {
        printlnToUser("正在按照该经纬度为您推荐籽粒用玉米品种.....");
        InputStream stream = getResources().openRawResource(R.raw.test3);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowsCount = sheet.getPhysicalNumberOfRows();//计算行数
            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
            for (int r = 0; r < rowsCount; r++) {//行数
                Row row = sheet.getRow(r);
                int cellsCount = row.getPhysicalNumberOfCells();//计算列数
                String cunshu[] = new String[14];//用数组存入这一行数据
                jingdu = getIntent().getStringExtra("jingdu");
                weidu = getIntent().getStringExtra("weidu");
                for (int c = 0; c < cellsCount; c++) {
                    String value = getCellAsString(row, c, formulaEvaluator);
                    String cellInfo = "row:" + r + "; column:" + c + "; value:" + value;
                    cunshu[c] = value;
                    if (c == 13) {
                        if (Double.valueOf(cunshu[3])<=Double.valueOf(weidu)&&Double.valueOf(weidu)<=Double.valueOf(cunshu[4]) && Double.valueOf(cunshu[5])<= Double.valueOf(jingdu)&& Double.valueOf(jingdu)<=Double.valueOf(cunshu[6])) {
                            textview.setText("");
                            textview.append("该经纬度下推荐籽粒用玉米品种如下:" + "\n\n");
                            textview.append("籽粒用玉米:" + "   " + cunshu[11] + "\n\n");
                        }
                    }
                }
            }
        } catch (Exception e) {
            /* proper exception handling to be here */
            printlnToUser(e.toString());
        }
    }
    /**
     * 按照经纬度查询青贮玉米
     *
     * @param view
     */
    public void show_qingzhu(View view) {
        printlnToUser("正在按照该经纬度为您推荐青贮玉米品种.....");
        InputStream stream = getResources().openRawResource(R.raw.test3);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowsCount = sheet.getPhysicalNumberOfRows();//计算行数
            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
            for (int r = 0; r < rowsCount; r++) {//行数
                Row row = sheet.getRow(r);
                int cellsCount = row.getPhysicalNumberOfCells();//计算列数
                String cunshu[] = new String[14];//用数组存入这一行数据
                jingdu = getIntent().getStringExtra("jingdu");
                weidu = getIntent().getStringExtra("weidu");
                for (int c = 0; c < cellsCount; c++) {
                    String value = getCellAsString(row, c, formulaEvaluator);
                    String cellInfo = "row:" + r + "; column:" + c + "; value:" + value;
                    cunshu[c] = value;
                    if (c == 13) {
                        if (Double.valueOf(cunshu[3])<=Double.valueOf(weidu)&&Double.valueOf(weidu)<=Double.valueOf(cunshu[4]) && Double.valueOf(cunshu[5])<= Double.valueOf(jingdu)&& Double.valueOf(jingdu)<=Double.valueOf(cunshu[6])) {
                            textview.setText("");
                            textview.append("该经纬度下推荐青贮玉米品种如下:" + "\n\n");
                            textview.append("青贮用玉米:" + "   " + cunshu[12] + "\n\n");
                        }
                    }
                }
            }
        } catch (Exception e) {
            /* proper exception handling to be here */
            printlnToUser(e.toString());
        }
    }
    /**
     * 按照经纬度查询鲜食玉米
     *
     * @param view
     */
    public void show_xianshi(View view) {
        printlnToUser("正在按照该经纬度为您推荐青贮玉米品种.....");
        InputStream stream = getResources().openRawResource(R.raw.test3);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowsCount = sheet.getPhysicalNumberOfRows();//计算行数
            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
            for (int r = 0; r < rowsCount; r++) {//行数
                Row row = sheet.getRow(r);
                int cellsCount = row.getPhysicalNumberOfCells();//计算列数
                String cunshu[] = new String[14];//用数组存入这一行数据
                jingdu = getIntent().getStringExtra("jingdu");
                weidu = getIntent().getStringExtra("weidu");
                for (int c = 0; c < cellsCount; c++) {
                    String value = getCellAsString(row, c, formulaEvaluator);
                    String cellInfo = "row:" + r + "; column:" + c + "; value:" + value;
                    cunshu[c] = value;
                    if (c == 13) {
                        if (Double.valueOf(cunshu[3])<=Double.valueOf(weidu)&&Double.valueOf(weidu)<=Double.valueOf(cunshu[4]) && Double.valueOf(cunshu[5])<= Double.valueOf(jingdu)&& Double.valueOf(jingdu)<=Double.valueOf(cunshu[6])) {
                            textview.setText("");
                            textview.append("该经纬度下推荐鲜食玉米品种如下:" + "\n\n");
                            textview.append("鲜食玉米:" + "   " + cunshu[13] + "\n\n");
                        }
                    }
                }
            }
        } catch (Exception e) {
            /* proper exception handling to be here */
            printlnToUser(e.toString());
        }
    }
    public void  qingchuwenben(View view)
    {
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