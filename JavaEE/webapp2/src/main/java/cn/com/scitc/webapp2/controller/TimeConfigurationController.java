package cn.com.scitc.webapp2.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TimeConfigurationController {

    @PostMapping("/settime")
    public void settime(HttpServletRequest req) {
        try {
            File f = new File("D:/demo.txt");
            FileWriter fw = new FileWriter(f);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date startTime = sdf.parse(req.getParameter("startTime").replace("T"," "));
            String time = startTime.toString();
            System.out.println(time);
            fw.write(time);
            fw.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/gettime")
    @ResponseBody
    public JSONObject gettime() {
        try {
            File f = new File("D:/demo.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            JSONObject jsonObject = new JSONObject();
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                jsonObject.put("xxx",line);
                return jsonObject;
            }
            fr.close();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
