package com.hidarisoft.testActiveMQ.service;

import com.hidarisoft.testActiveMQ.model.Employee;
import com.hidarisoft.testActiveMQ.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
@Slf4j
public class JmsConsumer implements MessageListener {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            Employee employee = (Employee)objectMessage.getObject();
            employeeRepository.save(employee);

            log.info("Received Message: "+ employee.toString());
        } catch(Exception e) {
            log.error("Received Exception : "+ e);
        }

    }
}
