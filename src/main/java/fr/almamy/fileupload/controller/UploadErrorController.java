package fr.almamy.fileupload.controller;

import fr.almamy.util.Mappings;
import fr.almamy.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class UploadErrorController implements ErrorController {
    @RequestMapping(Mappings.ERROR)
    public String error(){
        log.info("Error Occurred");
        return ViewNames.ERROR;
    }
}
