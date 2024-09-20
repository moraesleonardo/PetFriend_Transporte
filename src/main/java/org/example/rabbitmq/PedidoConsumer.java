package org.example.rabbitmq;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.config.RabbitMQConfig;
import org.example.transporte.Pedido;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PedidoConsumer {

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receive(@Payload String json) {
        try {
            Pedido pedido = objectMapper.readValue(json, Pedido.class);
            log.info("Pedido recebido: {}", pedido);


        } catch (JsonProcessingException e) {
            log.error("Erro ao processar a mensagem", e);
            throw new RuntimeException(e);
        }
    }
}
