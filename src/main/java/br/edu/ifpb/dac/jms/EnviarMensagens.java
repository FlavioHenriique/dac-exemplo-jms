package br.edu.ifpb.dac.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;

@Stateless
public class EnviarMensagens {

    @Resource(lookup = "jms/demoQueue")
    private Queue queue;

    @Inject
    private JMSContext context;

    public void enviarMensagens(String mensagem) {

        JMSProducer producer = context.createProducer();
        producer.send(queue, mensagem);
    }
}
