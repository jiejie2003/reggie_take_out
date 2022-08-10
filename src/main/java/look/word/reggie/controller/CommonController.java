package look.word.reggie.controller;

import lombok.extern.slf4j.Slf4j;
import look.word.reggie.common.R;
import look.word.reggie.service.oss.FileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件上传和下载
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Resource
    private FileService fileService;

    /**
     * 文件上传
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) {
        try {
            //将临时文件转存到指定位置
            InputStream inputStream = file.getInputStream();
            String filename = file.getOriginalFilename();
            String uploadUrl = fileService.upload(inputStream, "reggie", filename);
            return R.success(uploadUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return R.error("上传失败");
        }
    }
}
