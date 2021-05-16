package com.intellij.terarosa.service;

import com.intellij.terarosa.domain.Product;
import com.intellij.terarosa.repository.ProductRepository;
import com.intellij.terarosa.repository.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;

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

}
