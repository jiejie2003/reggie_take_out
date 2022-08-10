package look.word.reggie.service.oss.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import lombok.extern.slf4j.Slf4j;
import look.word.reggie.service.oss.FileService;
import look.word.reggie.utils.OssProperties;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author : look-word
 * @date : 2022-05-15 11:07
 **/
@Slf4j
@Service
public class FileServiceImpl implements FileService {
    /**
     * 文件上传
     */
    @Override
        public String upload(InputStream inputStream, String module, String fileName) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder()
                .build(
                        OssProperties.ENDPOINT,
                        OssProperties.KEY_ID,
                        OssProperties.KEY_SECRET);
        //判断oss实例是否存在：如果不存在则创建，如果存在则获取
        if(!ossClient.doesBucketExist(OssProperties.BUCKET_NAME)){
            //创建bucket
            ossClient.createBucket(OssProperties.BUCKET_NAME);
            //设置oss实例的访问权限：公共读
            ossClient.setBucketAcl(OssProperties.BUCKET_NAME, CannedAccessControlList.PublicRead);
        }

        //构建日期路径：avatar/2019/02/26/文件名
        String folder = new DateTime().toString("yyyy/MM/dd");

        //文件名：uuid.扩展名
        fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));

        //文件根路径
        String key = module + "/" + folder + "/" + fileName;

        //文件上传至阿里云
        ossClient.putObject(OssProperties.BUCKET_NAME, key, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();

        //阿里云文件绝对路径
        return "https://" + OssProperties.BUCKET_NAME + "." + OssProperties.ENDPOINT + "/" + key;

    }

    /**
     * 删除阿里云的文件
     * @param url 访问地址
     */
    @Override
    public void removeFile(String url) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder()
                .build(
                        OssProperties.ENDPOINT,
                        OssProperties.KEY_ID,
                        OssProperties.KEY_SECRET);

        String urlPrefix = "https://" + OssProperties.BUCKET_NAME + "." + OssProperties.ENDPOINT +"/";
        String urlSuffix=url.substring(urlPrefix.length());
        ossClient.deleteObject(OssProperties.BUCKET_NAME,urlSuffix);
        log.info("已成功删除该文件 地址是："+url);


        // 关闭OSSClient。
        ossClient.shutdown();

    }
}
