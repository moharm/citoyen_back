package com.back.back_citoyen.Controllers.citoyen;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
/**
 * SignUpCitoye
 */
public class SignUpCitoye {

    @CrossOrigin("*")
    @PostMapping(value = "/citoyen/signup")
    public String Signup(@RequestParam(value = "image", required = false) MultipartFile image,
    @RequestParam("prenom") String prenom) throws IOException {

        System.out.println(image.getContentType().split("/")[1]);
     
        Files.write(Paths.get("../Store/Citoyen/" + image.getOriginalFilename()), image.getBytes());
        return prenom;
    }

}