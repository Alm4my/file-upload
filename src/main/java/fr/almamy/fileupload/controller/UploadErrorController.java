package fr.almamy.fileupload.controller;

import fr.almamy.util.Mappings;
import fr.almamy.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class UploadErrorController implements ErrorController {
    @RequestMapping(Mappings.ERROR)
    public String error(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        log.info("Error Occurred");

        if (status != null){
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value())
                return ViewNames.ERROR_404;

            if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value())
                return ViewNames.ERROR_500;

            }
        return ViewNames.ERROR;
    }
}
