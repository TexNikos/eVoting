/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.util.Map;

/**
 *
 * @author Nikos
 */
public class XMLElectionResults extends ElectionResults implements XMLExport {

    public XMLElectionResults(String name, Map m) {
        super(name, m);
    }
    

    @Override
    public String toXML() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
