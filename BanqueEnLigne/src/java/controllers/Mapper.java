/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Julien
 */
public  class Mapper {
    
    public static JSONObject requestToJSONObj(HttpServletRequest request) throws  IOException, JSONException
        {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = request.getReader();
            try {
                String str = null;
                while ((str = br.readLine()) != null) {
                    sb.append(str);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("requete: " + sb.toString());
            JSONObject jObj = new JSONObject(sb.toString());
            return jObj;
        }
    
    
}
