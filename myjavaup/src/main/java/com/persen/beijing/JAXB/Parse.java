package com.persen.beijing.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by persen on 16/9/19.
 */
public class Parse {
    public <T> void unmarshal() {
        File simplFile = new File(
                "/Users/persen/github/persencoding/myjavaup/src/main/resources/JAXB/jaxb.xml");

        FileInputStream simplFis = null;
        try {
            simplFis = new FileInputStream(simplFile);

            BufferedInputStream simplBis = new BufferedInputStream(simplFis);
            BufferedReader simplBr = new BufferedReader(new InputStreamReader(simplBis));
            StringBuffer simplsb = new StringBuffer();

            String line = null;

            while ((line = simplBr.readLine()) != null)
                simplsb.append(line).append("\n");


            simplFis.close();
            simplBis.close();

            String xml = simplsb.toString();
            System.out.print(xml);
            JAXBContext context;

            context = JAXBContext.newInstance(XmlRecord.class);
            Unmarshaller unmarshaller = context
                    .createUnmarshaller();

            T t = (T) unmarshaller.unmarshal(new StringReader(xml));
            System.out.println(t.getClass());
            System.out.println(t);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void marshal() {
        File xmlFile = new File("target/jaxbtest.xml");

        XmlRecord record = new XmlRecord();
        record.setName("nana");
        record.setAge("17");
        record.setAdress("home");
        XmlField field = new XmlField();
        field.setBody("bbody");
        field.setHead("hhead");
        record.setField(field);

        JAXBContext context;

        try {
            context = JAXBContext.newInstance(XmlRecord.class);
            Marshaller marshaller = context
                    .createMarshaller();
            marshaller.marshal(record, xmlFile);//myjavaup 路径是相对路径
            xmlFile.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
