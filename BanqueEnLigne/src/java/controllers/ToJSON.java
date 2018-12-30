/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Julien
 */
public class ToJSON {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private ToJSON() {
    }

    public static String toJson(Object o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
