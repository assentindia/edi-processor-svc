/**
 * 
 */
package net.assentindia.edi.processor.svc.handler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.filters.AcceptAllFileListFilter;
import org.springframework.integration.file.filters.AcceptOnceFileListFilter;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.filters.SftpSimplePatternFileListFilter;
import org.springframework.integration.sftp.inbound.SftpInboundFileSynchronizer;
import org.springframework.integration.sftp.inbound.SftpInboundFileSynchronizingMessageSource;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;


import com.jcraft.jsch.ChannelSftp.LsEntry;

import net.assentindia.edi.processor.svc.configuration.SFTPConfig;

/**
 * @author gaaur
 *
 */
@Configuration
public class SFTPHandler 
{
	@Autowired
	SFTPConfig sftpConfig; 
	
	@Autowired
	FileHandler fileHandler;
	
	@Bean
	    public SessionFactory<LsEntry> sftpSessionFactory() {
	        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
	        factory.setHost(sftpConfig.getHost());
	        factory.setPort(sftpConfig.getPort());
	        factory.setUser(sftpConfig.getUsername());
	        factory.setPassword(sftpConfig.getPassword());
	        factory.setAllowUnknownKeys(true);
	        //factory.setTestSession(true);
	        return new CachingSessionFactory<LsEntry>(factory);
	    }

	    @Bean
	    public SftpInboundFileSynchronizer sftpInboundFileSynchronizer() {
	        SftpInboundFileSynchronizer fileSynchronizer = new SftpInboundFileSynchronizer(sftpSessionFactory());
	        fileSynchronizer.setDeleteRemoteFiles(true);
	        fileSynchronizer.setRemoteDirectory(sftpConfig.getRemoteDirectory());
	        fileSynchronizer.setFilter(new SftpSimplePatternFileListFilter("*."+sftpConfig.getFileExtenstion()));
	        return fileSynchronizer;
	    }

	    @Bean
	    @InboundChannelAdapter(channel = "sftpChannel", poller = @Poller(fixedDelay = "${sftp.frequency}"))
	    public MessageSource<File> sftpMessageSource() {
	        SftpInboundFileSynchronizingMessageSource source =
	                new SftpInboundFileSynchronizingMessageSource(sftpInboundFileSynchronizer());
	        source.setLocalDirectory(new File(sftpConfig.getLocalDirectory()));
	        source.setAutoCreateLocalDirectory(true);
	        //source.setLocalFilter(new AcceptOnceFileListFilter<File>());
	        source.setLocalFilter(new AcceptAllFileListFilter<File>());
	        source.setMaxFetchSize(1);
	        return source;
	    }

	    @Bean
	    @ServiceActivator(inputChannel = "sftpChannel")
	    public MessageHandler handler() {
	        return new MessageHandler() {

	            @Override
	            public void handleMessage(Message<?> message) throws MessagingException {
	                System.out.println("========================"+message.getPayload());
	                try {
	                	File srcFile =(File)message.getPayload();
	                	File destFile =new File(sftpConfig.getBackupDirectory()+File.separator+srcFile.getName());
	                	fileHandler.handleFile(srcFile);
	                	if(destFile.exists())
	                	{ 
	                		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmssSSS");
	                		File tempFile = new File(destFile.getAbsolutePath()+".old."+sdf.format(new Date()));
	                		Files.move(Paths.get(destFile.getAbsolutePath()), Paths.get(tempFile.getAbsolutePath()),StandardCopyOption.REPLACE_EXISTING);
	                	}
	                	Files.move(Paths.get(srcFile.getAbsolutePath()), Paths.get(destFile.getAbsolutePath()),StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        };
	    }
}
