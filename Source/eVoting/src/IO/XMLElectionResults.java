/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.StringWriter;
import java.util.Map;
import javax.xml.stream.*;

/**
 *
 * @author Nikos
 */
public class XMLElectionResults extends ElectionResults implements XMLExport {

    public XMLElectionResults(String name, Map m) {
        super(name, m);
    }

    public XMLElectionResults() {
        super();
    }

    @Override
    public String toXML() {
        StringWriter out = new StringWriter();
        XMLOutputFactory xof = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter xsw = xof.createXMLStreamWriter(out);
            int depth;
            xsw.writeStartDocument("UTF-8", "1.0");
            xsw.writeCharacters("\n");
            xsw.writeStartElement("ΑΠΟΤΕΛΕΣΜΑΤΑ");
            xsw.writeCharacters("\n");
            depth = 1;
            for (Object en : this.entrySet()) {
                for (int i = 0; i < depth; i++) {
                    xsw.writeCharacters("    ");
                }
                xsw.writeStartElement(((Entry) en).getKey().toString());
                xsw.writeCharacters("\n");
                depth = 2;
                for (Object e : ((Map) ((Entry) en).getValue()).entrySet()) {
                    for (int i = 0; i < depth; i++) {
                        xsw.writeCharacters("    ");
                    }
                    xsw.writeStartElement(((Entry) e).getKey().toString());
                    xsw.writeCharacters("\n");
                    depth = 3;
                    for (Object entry : ((Map) ((Entry) e).getValue()).entrySet()) {
                        for (int i = 0; i < depth; i++) {
                            xsw.writeCharacters("    ");
                        }
                        xsw.writeStartElement(((Entry) entry).getKey().toString());
                        xsw.writeCharacters("\n");
                        depth = 4;
                        for (int i = 0; i < depth; i++) {
                            xsw.writeCharacters("    ");
                        }
                        xsw.writeCharacters(((Entry) entry).getValue().toString());
                        xsw.writeCharacters("\n");
                        depth = 3;
                        for (int i = 0; i < depth; i++) {
                            xsw.writeCharacters("    ");
                        }
                        xsw.writeEndElement();
                        xsw.writeCharacters("\n");
                    }
                    depth = 2;
                    for (int i = 0; i < depth; i++) {
                        xsw.writeCharacters("    ");
                    }
                    xsw.writeEndElement();
                    xsw.writeCharacters("\n");
                }
                depth = 1;
                for (int i = 0; i < depth; i++) {
                    xsw.writeCharacters("    ");
                }
                xsw.writeEndElement();
                xsw.writeCharacters("\n");
            }
            xsw.writeEndElement();
            xsw.writeEndDocument();
            xsw.flush();
            xsw.close();
        } catch (XMLStreamException xse) {

        }
        
        return out.toString();
    }

}
