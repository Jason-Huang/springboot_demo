package cn.jason.demo.cbbaoguanzhijian;


import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateXML {

    private int seq = 0;

    //自定义  创建xml
    public String AddXml(ZhiJian zj, String certNo) {
        String xmlString = "";
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");//转换日期
        String now = sdf.format(new Date());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            document.setXmlStandalone(true);

            Element ROOT = document.createElement("ROOT");
            document.appendChild(ROOT);
            {
                Element Head = document.createElement("Head");
                ROOT.appendChild(Head);
                {
                    Element MessageID = document.createElement("MessageID");
                    MessageID.setTextContent(zj.getMessageID());
                    Head.appendChild(MessageID);
                    Element MessageType = document.createElement("MessageType");
                    MessageType.setTextContent("661107");
                    Head.appendChild(MessageType);
                    Element Sender = document.createElement("Sender");
                    Sender.setTextContent("1509012633");
                    Head.appendChild(Sender);
                    Element Receiver = document.createElement("Receiver");
                    Receiver.setTextContent("ICIP");
                    Head.appendChild(Receiver);
                    Element SendTime = document.createElement("SendTime");
                    SendTime.setTextContent(now);
                    Head.appendChild(SendTime);
                    Element FunctionCode = document.createElement("FunctionCode");
                    FunctionCode.setTextContent("");
                    Head.appendChild(FunctionCode);
                    Element Version = document.createElement("Version");
                    Version.setTextContent("1.0");
                    Head.appendChild(Version);
                }
                {
                    Element Body = document.createElement("Body");
                    ROOT.appendChild(Body);
                    {
                        Element SwbPayment = document.createElement("SwbPayment");
                        Body.appendChild(SwbPayment);
                        {
                            Element Record = document.createElement("Record");
                            SwbPayment.appendChild(Record);
                            {
                                Element Payno = document.createElement("Payno");
                                Payno.setTextContent(zj.getPayNo());
                                Record.appendChild(Payno);
                                Element Ciqbcode = document.createElement("Ciqbcode");
                                Ciqbcode.setTextContent("000069");
                                Record.appendChild(Ciqbcode);
                                Element PaypComcode = document.createElement("PaypComcode");
                                PaypComcode.setTextContent("1509012633");
                                Record.appendChild(PaypComcode);
                                Element CbepComcode = document.createElement("CbepComcode");
                                CbepComcode.setTextContent("1500004142");
                                Record.appendChild(CbepComcode);
                                Element Enordercode = document.createElement("Enordercode");
                                Enordercode.setTextContent(zj.getEnordercode());
                                Record.appendChild(Enordercode);
                                Element PayorName = document.createElement("PayorName");
                                PayorName.setTextContent(zj.getPayorName());
                                Record.appendChild(PayorName);
                                Element PayorAccount = document.createElement("PayorAccount");
                                PayorAccount.setTextContent("");
                                Record.appendChild(PayorAccount);
                                Element ShipperName = document.createElement("ShipperName");
                                ShipperName.setTextContent("");
                                Record.appendChild(ShipperName);
                                Element OrderFcy = document.createElement("OrderFcy");
                                OrderFcy.setTextContent(zj.getOrderFcy());
                                Record.appendChild(OrderFcy);
                                Element OrderFcode = document.createElement("OrderFcode");
                                OrderFcode.setTextContent("CNY");
                                Record.appendChild(OrderFcode);
                                Element ReceiveNo = document.createElement("ReceiveNo");
                                ReceiveNo.setTextContent(certNo);
                                Record.appendChild(ReceiveNo);
                                Element PayFcy = document.createElement("PayFcy");
                                PayFcy.setTextContent(zj.getPayFcy());
                                Record.appendChild(PayFcy);
                                Element PayFcode = document.createElement("PayFcode");
                                PayFcode.setTextContent("CNY");
                                Record.appendChild(PayFcode);
                                Element PayDate = document.createElement("PayDate");
                                PayDate.setTextContent(zj.getPayDate());
                                Record.appendChild(PayDate);
                                Element Shippercompcode = document.createElement("Shippercompcode");
                                Shippercompcode.setTextContent("1509012633");
                                Record.appendChild(Shippercompcode);
                                Element Notes = document.createElement("Notes");
                                Notes.setTextContent("");
                                Record.appendChild(Notes);
                            }
                        }
                    }
                }
            }


            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);

            // xml transform String
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            transformer.transform(domSource, new StreamResult(bos));
            xmlString = bos.toString();
            System.out.println(xmlString);
            String fileName = "661107_" + now + getSeq() + ".xml";
            String filePath = "./baoguan/";
            File f = new File(filePath);
            if (!f.exists()) {
                f.mkdirs();
            }
            OutputStream xmlFile = new FileOutputStream(filePath + fileName);
            bos.writeTo(xmlFile);
            xmlFile.close();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlString;
    }

    public String getSeq() {
        if (seq > 999) {
            seq = 0;
        }
        return StringUtils.leftPad("" + seq++, 3, "0");
    }

    public static void main(String[] args) {
        CreateXML x = new CreateXML();
        for(int i =0;i<2000;i++){
            System.out.println(x.getSeq());
        }
    }


}