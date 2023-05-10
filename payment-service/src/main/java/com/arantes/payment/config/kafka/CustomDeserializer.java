package com.arantes.payment.config.kafka;

import com.arantes.payment.adapters.out.message.SaleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Objects;

public class CustomDeserializer implements Deserializer<SaleMessage> {

    @Override
    public SaleMessage deserialize(String topic, byte[] data) {
        try {
            if (Objects.isNull(data)) return null;

            return new ObjectMapper().readValue(new String(data, "UTF-8"), SaleMessage.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializer byte[] to SaleMessage");
        }
    }
}
