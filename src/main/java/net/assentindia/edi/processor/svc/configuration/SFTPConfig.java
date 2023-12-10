/**
 * 
 */
package net.assentindia.edi.processor.svc.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * @author gaaur
 *
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sftp")
public class SFTPConfig 
{
	String frequency;
	String host;
	Integer port;
	String username;
	String password;
	String remoteDirectory;
	String localDirectory;
	String backupDirectory;
	String fileExtenstion;
}
