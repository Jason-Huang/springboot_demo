package cn.jason.demo.cbbaoguanzhijian;

import java.io.File;
import java.util.List;

public class Run {

    public static void main(String[] args) {
        ReadExcel obj = new ReadExcel();
        File file = new File("baoguan.xls");
        List excelList = obj.readExcel(file);
        OperateOracle oo = new OperateOracle();
        String merOrderId = null;
        String certNo = null;
        try {
            CreateXML createXML = new CreateXML();
            for (int i = 1; i < excelList.size(); i++) {
                List list = (List) excelList.get(i);
                merOrderId = (String) list.get(0);
                certNo = (String) list.get(1);
                System.out.println("merOrderId=" + merOrderId + " certNo=" + certNo);
                DataBaseService service = new DataBaseService();
                ZhiJian zhiJianData = service.getZhiJianData(merOrderId, oo);
                createXML.AddXml(zhiJianData, certNo);

            }
        } catch (Exception e) {
            System.out.println("报错merOrderId=" + merOrderId + " certNo=" + certNo);
            e.printStackTrace();
        } finally {
            oo.ReleaseResource();
        }

    }

}
