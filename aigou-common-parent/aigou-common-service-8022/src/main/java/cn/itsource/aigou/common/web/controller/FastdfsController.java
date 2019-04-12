package cn.itsource.aigou.common.web.controller;

import cn.itsource.aigou.common.AjaxResult;
import cn.itsource.aigou.common.util.FastDfsApiOpr;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RequestMapping("/common")
@RestController
public class FastdfsController  {
    /**
     * 文件的上传
     * @return
     */
    @RequestMapping(value = "fastdfs",method = RequestMethod.POST)
    public AjaxResult upload(@RequestBody MultipartFile filename) {
        try {
            String extName = FilenameUtils.getExtension(filename.getOriginalFilename());
            String uploadName = FastDfsApiOpr.upload(filename.getBytes(), extName);

            return AjaxResult.me().setMsg("上传成功").setObject(uploadName);
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.me().setMsg("上传失败").setSuccess(false);
        }
    }

        //下载
        @RequestMapping(value = "fastdfs",method = RequestMethod.GET)
        public AjaxResult downLoad(@RequestParam String fileName, HttpServletResponse response){

            String substring = fileName.substring(1);
            System.out.println(substring);
            int i = substring.indexOf("/");
            String substring1 = substring.substring(i+1);
            String group = substring.substring(0, i);
            System.out.println(group);
            System.out.println(substring1);
            byte[] download = FastDfsApiOpr.download(group, substring1);
            //byte数组转换为输入流
            InputStream input=null;
            OutputStream output=null;
            try {
                input=new ByteArrayInputStream(download);
                output=response.getOutputStream();
                IOUtils.copy(input, output);
                return AjaxResult.me().setMsg("下载成功");
            } catch (IOException e) {
                e.printStackTrace();
                return AjaxResult.me().setMsg("下载失败").setSuccess(false);
            }finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

        }

    }
    @RequestMapping(value = "fastdfs",method = RequestMethod.DELETE)
    public AjaxResult delete(@RequestParam String fileName){
        String substring = fileName.substring(1);
        System.out.println(substring);
        int i = substring.indexOf("/");
        String substring1 = substring.substring(i+1);
        String group = substring.substring(0, i);
        int delete = FastDfsApiOpr.delete(group, substring1);
        if(delete==0){
            return AjaxResult.me().setMsg("删除成功");
        }else{
            return AjaxResult.me().setMsg("删除失败").setSuccess(false);
        }

    }

}
