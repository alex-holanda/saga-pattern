package com.arantes.orchestrator.adapters.in.consumer;

import com.arantes.orchestrator.adapters.out.message.SaleMessage;
import com.arantes.orchestrator.application.core.domain.Sale;
import com.arantes.orchestrator.application.ports.in.WorkflowInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToProcessConsumer {

    private final List<WorkflowInputPort> workflows;

    @KafkaListener(topics = "tp-saga-orchestrator", groupId = "orchestrator")
    public void receive(SaleMessage saleMessage) {
        var workflow = workflows.stream()
                .filter(w -> w.isCalledByTheEvent(saleMessage.getSaleEvent()))
                .findFirst()
                .orElse(null);

        if (Objects.nonNull(workflow)) {
            workflow.execute(saleMessage.getSale());
        } else {
            log.error("Evento não encontrado");
        }
    }
}
