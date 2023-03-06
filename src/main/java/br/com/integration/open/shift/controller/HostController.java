
package br.com.integration.open.shift.controller;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.integration.open.shift.entity.Host;
import br.com.integration.open.shift.filter.HostFilter;
import br.com.integration.open.shift.published.APIGenericResponse;
import br.com.integration.open.shift.published.StatusResponse;
import br.com.integration.open.shift.service.HostService;

/**
 * @author Thiago Araujo
 *
 *
 */
@RestController
@RequestMapping(value = "/host", produces = MediaType.APPLICATION_JSON_VALUE)
public class HostController {

	static Logger logger = LoggerFactory.getLogger(HostController.class);	
	
	@Autowired
	private HostService hostService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> create (@RequestBody HostFilter host) { 
		
		try {

			return ResponseEntity.ok(new APIGenericResponse(hostService.create(host), new StatusResponse("Request API is successfully", HttpStatus.CREATED)));
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(false, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> read (@PathVariable(value = "id") Long id) { 
		
		try {

			Optional<Host> host = hostService.read(id);
			
			if (host.isPresent()) {
				
				return ResponseEntity.ok(new APIGenericResponse(host.get(), new StatusResponse("Request API is successfully", HttpStatus.OK)));
			
			} else {
				
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(null, new StatusResponse("Host not found.", HttpStatus.NOT_FOUND)));
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> update (@PathVariable(value = "id") Long id,   @RequestBody HostFilter hostFilter) { 
		
		try {
			Host host = hostService.update(id, hostFilter); 
			if (host == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(host, new StatusResponse("Host not found.", HttpStatus.NOT_FOUND)));
			}
			return ResponseEntity.ok(new APIGenericResponse(host, new StatusResponse("Request API is successfully", HttpStatus.OK)));
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> delete (@PathVariable(value = "id") Long id) { 
		
		try {

			Boolean deleted = hostService.delete(id);
			if (deleted) {
				return ResponseEntity.ok(new APIGenericResponse(deleted, new StatusResponse("Request API is successfully", HttpStatus.OK)));
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(deleted, new StatusResponse("Host not found.", HttpStatus.NOT_FOUND)));
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
}
