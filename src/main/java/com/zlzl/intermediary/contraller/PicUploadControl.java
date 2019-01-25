package com.zlzl.intermediary.contraller;

import com.zlzl.intermediary.entity.HouseBasics;
import com.zlzl.intermediary.repository.HouseBasicsRepository;
import com.zlzl.intermediary.repository.HousePhotoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PicUploadControl {
    @Resource
    private HouseBasicsRepository houseBasicsRepository;
    @Resource
    private HousePhotoRepository housePhotoRepository;
    @RequestMapping("picupload")
    public  String topicupload(Model map){
        String[]  detailedadd =houseBasicsRepository.findDetailedAdd();
        map.addAttribute("detailedadd",detailedadd);
        System.out.println(detailedadd);
        return "picupload";
    }
    @ResponseBody
    @RequestMapping("files.do")
    //requestParam要写才知道是前台的那个数组
    public void filesUpload(@RequestParam("myfiles") MultipartFile[] files,
                              HttpServletRequest request) {
        List<String> list = new ArrayList<String>();
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                // 保存文件
                list = saveFile(request, file, list);
            }
        }



    }


    private List<String> saveFile(HttpServletRequest request,
                                  MultipartFile file, List<String> list) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                String detailedAdd=request.getParameter("select_detailedAdd");
                String hdId=houseBasicsRepository.findhdIdByDetailedAdd(detailedAdd);
                String[] phopoadd=housePhotoRepository.selectphotoAdd(Integer.parseInt(hdId));
                String phopoadd2="";
                if(phopoadd==null){
                    phopoadd2="pic"+hdId+"_"+"01.jpg";
                    System.out.println(phopoadd2);
                    housePhotoRepository.insertdata(Integer.parseInt(hdId),phopoadd2);

                }else{
                    String[] phopoadd1=phopoadd[phopoadd.length-1].split("_");
                    phopoadd2=phopoadd1[0]+"_"+(Integer.parseInt(phopoadd1[1].substring(0,2))+1)+".jpg";
                    System.out.println(phopoadd2);
                    housePhotoRepository.insertdata(Integer.parseInt(hdId),phopoadd2);
                }
                // 保存的文件路径(如果用的是Tomcat服务器，文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中
                // )
                String filePath =  "D:\\GIT\\src\\main\\resources\\static\\image\\" +phopoadd2;
                list.add(file.getOriginalFilename());
                File saveDir = new File(filePath);
                if (!saveDir.getParentFile().exists())
                    saveDir.getParentFile().mkdirs();

                // 转存文件
                file.transferTo(saveDir);
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
