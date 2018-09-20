package util;

import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BarcodeList {

    public static List<String> barCode() {
        List<String> person = new ArrayList<>();
        person.add("6902017363717");
        person.add("1425836884456");
        person.add("9900000");
        person.add("46268523688");
        person.add("589632588");
        person.add("6922711079073");
        person.add("555555555588888");
        person.add("467288427");
        person.add("784571549");
        person.add("12345678965");
        person.add("6940467801006");
        person.add("155583883789999");
        person.add("2222222222");
        person.add("1313131313");
        person.add("141414141414");
        person.add("6927556909332");
        person.add("6940467801007");
        person.add("6922868285730");
        person.add("589632588");
        person.add("59636852");
        person.add("709394257");
        person.add("1425836884456");
        person.add("1425836884456");
        person.add("6920718412954");
        person.add("1425836884456");
        person.add("6914358312606");
        person.add("9345448001013");
        person.add("9900001");
        person.add("6932096405671");
        person.add("9900000");
        person.add("7373727727272");
        person.add("6932096400065");
        person.add("1111111111133");
        person.add("74558844115");
        person.add("555555555588888");
        person.add("1111111111111");
        person.add("6926762500036");
        person.add("356643323");

        return person;
    }

    public static boolean exportCsv(File file, List<String> dataList){
        boolean isSucess=false;

        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out);
            bw =new BufferedWriter(osw);
            if(dataList!=null && !dataList.isEmpty()){
                for(String data : dataList){
                    bw.append(data).append("\r");
                }
            }
            isSucess=true;
        } catch (Exception e) {
            isSucess=false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSucess;
    }

    @Test
    public void exportFile(){
        boolean b = exportCsv(new File("E:\\CSVFile\\ProductID.csv"), barCode());
        System.out.println(b);

    }
}
