package com.intellij.terarosa.repository.dto;

import com.intellij.terarosa.domain.Product;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Base64;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Slf4j
public class ProductDto {

    private Long id;
    private String name;
    private String category;
    private BigInteger price;
    private String info;
    private String imgpath;
    private int count;
    private LocalDateTime createDate;
    private String[] imgList;

    public Product toEntity() {
        Product product = Product.builder()
                .id(id)
                .name(name)
                .category(category)
                .price(price)
                .info(info)
                .imgpath(imgpath)
                .build();
        return product;
    }

    @Builder
    public ProductDto (Long id, String name, String category, String price, String info,
                        String imgpath, int count, LocalDateTime createDate, String[] imgList) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = BigInteger.valueOf(Long.parseLong(price));
        this.info = info;
        this.imgpath = imgpath;
        this.count = count;
        this.createDate = createDate;
        this.imgList = imgList;
    }

    public String[] getBase64List() {
        try {
            File dir = new File(this.imgpath);
            File[] fileList = dir.listFiles();
            String[] list = new String[fileList.length];
            for (int i = 0; i < list.length; i++) {
                byte[] fileByte = FileUtils.readFileToByteArray(fileList[i]);
                String encodedString = Base64.getEncoder().encodeToString(fileByte);
                list[i] = encodedString;
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}
