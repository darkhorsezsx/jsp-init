package com.zsx.demo.jsp;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This is {@link FooServlet}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@WebServlet(urlPatterns = {"/foo", "/another/foo"}, description = "foo service")
public class FooServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String content = "{\n" +
                "  \"service\": \"foo\",\n" +
                "  \"message\": \"hello\"\n" +
                "}";
        resp.setContentType("application/json");
        resp.setContentLength(content.getBytes().length);

        ServletOutputStream os = resp.getOutputStream();
        byte[] bufferData = content.getBytes();
        os.write(bufferData);
        os.flush();
        os.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
