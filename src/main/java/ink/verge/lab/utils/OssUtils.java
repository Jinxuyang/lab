package ink.verge.lab.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import ink.verge.lab.response.CommonResult;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Verge
 * @Date 2020/10/26 20:21
 * @Version 1.0
 */
@Component
public class OssUtils {
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.endpoint}")
    private String ALIYUN_OSS_ENDPOINT;
    @Value("${aliyun.oss.accessKeyId}")
    private String ALIYUN_OSS_ACCESSKEYID;
    @Value("${aliyun.oss.accessKeySecret}")
    private String ALIYUN_OSS_ACCESSKEYSECRET;

    public OSS getOssClient(){
        return new OSSClientBuilder().build(ALIYUN_OSS_ENDPOINT,ALIYUN_OSS_ACCESSKEYID,ALIYUN_OSS_ACCESSKEYSECRET);
    }

    public CommonResult uploadImg(MultipartFile img){
        OSS oss = getOssClient();
        String objectName;
        try {
            Date date = new Date();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat format2 = new SimpleDateFormat("hhmmss");
            String oriName = img.getOriginalFilename();
            String suffix = oriName.substring(oriName.indexOf('.'));
            String randString = RandomStringUtils.randomAlphanumeric(5);
            objectName = "images/"+format1.format(date)+"/"+format2.format(date)+randString+suffix;
            oss.putObject(bucketName,objectName,img.getInputStream());
        } catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed("上传图片时出错");
        }finally {
            oss.shutdown();
        }

        return CommonResult.success("上传成功","https://"+bucketName+"."+endpoint+"/"+objectName);
    }

    public CommonResult uploadImgs(MultipartFile[] img){
        boolean flag = true;
        Set<String> urlSet = new HashSet<>();
        for (MultipartFile multipartFile : img) {
            CommonResult result = uploadImg(multipartFile);
            if (result.getCode() == 200){
                urlSet.add((String) result.getData());
            } else {
                flag = false;
            }
        }
        if (flag) return CommonResult.success(urlSet);
        else return CommonResult.failed();
    }

    public CommonResult uploadFile(MultipartFile file){
        OSS oss = getOssClient();
        String objectName;
        try {
            Date date = new Date();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat format2 = new SimpleDateFormat("hhmmss");
            String oriName = file.getOriginalFilename();
            String suffix = oriName.substring(oriName.indexOf('.'));
            String randString = RandomStringUtils.randomAlphanumeric(5);
            objectName = "files/"+format1.format(date)+"/"+format2.format(date)+randString+suffix;
            oss.putObject(bucketName,objectName,file.getInputStream());
        } catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed("上传文件时出错");
        }finally {
            oss.shutdown();
        }

        return CommonResult.success("上传成功","https://"+bucketName+"."+endpoint+"/"+objectName);
    }
}
