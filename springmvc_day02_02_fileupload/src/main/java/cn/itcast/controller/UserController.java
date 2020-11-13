package cn.itcast.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 文件上传的必要前提：
     *    1.form表单的enctype取值必须是：multipart/form-data(默认值是application/x-www-form-urlencoded)
     *          enctype:表单请求正文的类型
     *    2.method属性取值必须是post
     *    3.提供一个文件选择域<input type="file"/>
     *
     * 文件上传的原理分析：
     *    当form表单的enctype取值不是默认值后，request.getParameter()将失效。
     *    enctype=application/x-www-form-urlencoded时，form表单的正文内容是：key=value&key=value&...
     *    enctype=multipart/form-data时，请求正文内容变成：
     *    每一部分都是MIME类型描述的正文
     *    -------------------------7dela433602ac           分界符
     *    Content-Disposition:form-data; name="userName"   协议头
     *    ......
     * @return
     */
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传。。。");
        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断该路径是否存在
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }
        // 解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析request
        List<FileItem> items = upload.parseRequest(request);
        System.out.println(items);
        // 遍历
        for(FileItem item : items){
            // 进行判断，当前item对象是否是上传文件项
            if(item.isFormField()){
                // 说明说普通表单项
            }else{
                // 说明是上传文件项
                // 获取上传文件的名称
                String fileName = item.getName();
                System.out.println(fileName);
                //把文件的名称设置成唯一值,uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" + fileName;
                // 完成文件上传
                item.write(new File(path, fileName));
                // 删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /**
     *  springmvc文件上传：需要在xml文件中配置文件解析器
     *  参数中的upload必须和form表单的name
     *
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2 (HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传。。。");
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断该路径是否存在
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }
        // 说明是上传文件项
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        System.out.println(filename);
        //把文件的名称设置成唯一值,uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        // 完成文件上传
        upload.transferTo(new File(path, filename));
        return "success";
    }

    /**
     *  跨服务器文件上传
     *
     */
    @RequestMapping("/fileUpload3")
    public String fileUpload3 (MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传。。。");
        // 定义上传文件服务器路径
        String path = "http://localhost:8989/uploads/";

        // 说明是上传文件项
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        System.out.println(filename);
        //把文件的名称设置成唯一值,uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        // 完成跨服务器文件上传
        // 创建客户端对象
        Client client = Client.create();
        // 和图片服务器进行连接
        WebResource resource = client.resource(path + filename);
        // 上传文件
        resource.put(upload.getBytes());

        return "success";
    }
}
