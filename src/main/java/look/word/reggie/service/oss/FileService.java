package look.word.reggie.service.oss;

import java.io.InputStream;

/**
 * @author : look-word
 * @date : 2022-05-15 11:06
 **/

public interface FileService {
    /**
     * 文件上传至阿里云
     */
    String upload(InputStream inputStream, String module, String fileName);

    /**
     * 删除阿里云的文件
     * @param url 访问地址
     */
    void removeFile(String url);
}
