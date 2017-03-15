/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nikos
 */
public class ElectionResults extends HashMap {

    private String name;

    public ElectionResults(String name) {
        super();
        this.name = name;
    }

    public ElectionResults(String name, Map m) {
        super(m);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
