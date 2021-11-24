package com.glasgow.wind.controller;

import com.glasgow.wind.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author Zhe Miao Guid: 2598803M
 * @Date 2021/11/21 15:02
 * @Version 1.0
 */

@RestController
@RequestMapping("/storage")
public class StorageController {
    @Value("${storage.path}")
    String storagePath;

    @PostMapping("/create")
    public Object create(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.indexOf("."));
        File fileDestination = new File(storagePath, uuid);
        file.transferTo(fileDestination);
        System.out.println(storagePath+uuid);

        Map<Object, Object> data = new HashMap<Object, Object>();
        data.put("src", storagePath + "/" + uuid);
        return ResponseUtil.ok(data);
    }
}
