package controller;
import model.UploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @GetMapping(value = {"/uploadOneFile", "/"})
    public String uploadOneFileForm(Model model){
        UploadForm uploadForm = new UploadForm();
        model.addAttribute("uploadForm", uploadForm);
        return "uploadOneFile";
    }

    @PostMapping(value = "/result")
    public ModelAndView uploadOneFile(@ModelAttribute("uploadForm") UploadForm uploadForm){
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("message", "upload success");
        modelAndView.addObject("description", uploadForm.getDescription());
//        try {
//            MultipartFile multipartFile = uploadForm.getMultipartFile();
//            String fileName = multipartFile.getOriginalFilename();
//            File file = new File("E:\\A1020I1-HoangNgocCuong\\Module4\\_03_data_binding_form\\thuc_hanh\\upload_file\\files", fileName);
//            multipartFile.transferTo(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//            model.addAttribute("message", "upload failed");
//        }
        return modelAndView;
    }

}
