package com.intellij.terarosa.service;

import com.intellij.terarosa.domain.Product;
import com.intellij.terarosa.repository.ProductRepository;
import com.intellij.terarosa.repository.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void itemRegi(ProductDto productDto) throws Exception {
        String IMAGEPATH = "C:\\terarosa\\image\\";
        try{
            Product product = productDto.toEntity();
            productRepository.save(product);
            product = productRepository.findTop1ByOrderByIdDesc();
            product.setImgpath(IMAGEPATH + product.getId() + "\\");
            productRepository.save(product);
        }catch (Exception e) {
            throw new Exception();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String uploadAttachment(MultipartFile[] sourceFile) throws IOException {

        Product product = productRepository.findTop1ByOrderByIdDesc();

        for(MultipartFile file : sourceFile) {
            String sourceFileName = file.getOriginalFilename();
            File destinationFile;
            do {
                destinationFile = new File(product.getImgpath() + sourceFileName);
                destinationFile.getParentFile().mkdirs();
            } while (destinationFile.exists());
            file.transferTo(destinationFile);
        }
        return "redirect:/";
    }

    public List<ProductDto> getList(String value) {
        List<Product> productList =  productRepository.findListOrderBy(value);
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product list : productList) {
            ProductDto dto = ProductDto.builder()
                    .id(list.getId())
                    .name(list.getName())
                    .category(list.getCategory())
                    .price(String.valueOf(list.getPrice()))
                    .info(list.getInfo())
                    .imgpath(list.getImgpath())
                    .build();
            dto.setImgList(dto.getBase64List());
            productDtoList.add(dto);
        }
        return productDtoList;
    }
}
