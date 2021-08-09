package tw.leonchen.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {
	@RequestMapping(path = "/responsebody.controller", method = RequestMethod.GET)
	@ResponseBody
	public String processResponseAction1() {
		return "This Message is From Server";
	}

	@RequestMapping(path = "/responsebodyCharset.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody // text/plain 是指定的意思，可以改成: applicationl/xml, application/json, text/html
	public String processResponseAction2() {
		return "This Message is From Server:你好";
	}

	@RequestMapping(path = "/responseEntity.controller", method = RequestMethod.GET)
	public ResponseEntity<String> processResponseEntity() {
		return new ResponseEntity<String>("Custom Message 403(Forbidden)", HttpStatus.FORBIDDEN);
	}

	@RequestMapping(value = "/response/entity/headers.controller", method = RequestMethod.GET)
	public ResponseEntity<String> responseEntityCustomHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<String>("Custom header Content-Type=text/plain", headers, HttpStatus.OK);
	}

	@RequestMapping(path = "/responsebodyByteImage.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public void processResponseByteImageAction(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		InputStream is1 = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/images01.jpg");
		IOUtils.copy(is1, response.getOutputStream());
	}
}
