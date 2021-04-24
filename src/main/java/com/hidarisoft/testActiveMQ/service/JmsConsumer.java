package com.hidarisoft.testActiveMQ.service;

import com.hidarisoft.testActiveMQ.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.dirigible.commons.api.helpers.FileSystemUtils;
import org.eclipse.dirigible.commons.api.helpers.GsonHelper;
import org.eclipse.dirigible.commons.api.module.DirigibleModulesInstallerModule;
import org.eclipse.dirigible.database.h2.H2Database;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
@Slf4j
public class JmsConsumer implements MessageListener {


    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            Employee employee = (Employee)objectMessage.getObject();
            FileSystemUtils.createFile("test");

            log.info("Received Message: "+ employee.toString());
        } catch(Exception e) {
            log.error("Received Exception : "+ e);
        }

    }
}
