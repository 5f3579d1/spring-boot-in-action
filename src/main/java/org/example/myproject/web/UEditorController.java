package org.example.myproject.web;

import com.baidu.ueditor.MyActionEnter;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by k on 9/22/15.
 */
@RestController
public class UEditorController {

    @Value("${ueditor.config.json.path}")
    private String configJSONPath;

    @RequestMapping("/UEditor")
    public String controller(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "text/html");
        ApplicationContext appContext = new ClassPathXmlApplicationContext();
        return new MyActionEnter(request, appContext.getResource(configJSONPath).getInputStream()).exec();
    }

}
