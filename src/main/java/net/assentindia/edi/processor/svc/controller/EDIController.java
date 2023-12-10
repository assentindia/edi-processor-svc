/**
 * 
 */
package net.assentindia.edi.processor.svc.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.assentindia.edi.processor.model.Root;
import net.assentindia.edi.processor.svc.configuration.SFTPConfig;
import net.assentindia.edi.processor.svc.handler.FileHandler;



/**
 * @author kush
 *
 */
@RestController
@RequestMapping("edi")
public class EDIController
{
	@Autowired
	FileHandler fileHandler;
	
	@Autowired
	SFTPConfig sftpConfig;
	
	@ResponseBody
	@GetMapping(path="/get/{fileName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Root getById(@PathVariable(required = true)String fileName)
	{
		return fileHandler.handleFile(new File(sftpConfig.getBackupDirectory()+File.separator+fileName));
	}
}
