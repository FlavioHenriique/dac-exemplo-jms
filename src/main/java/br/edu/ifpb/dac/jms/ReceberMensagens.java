package br.edu.ifpb.dac.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class ReceberMensagens {

    @Inject
    private JMSContext context;

    @Resource(lookup = "jms/demoQueue")
    private Queue queue;

    public String ler() {

        JMSConsumer consumer = context.createConsumer(queue);
        return consumer.receiveBody(String.class);
    }
}
