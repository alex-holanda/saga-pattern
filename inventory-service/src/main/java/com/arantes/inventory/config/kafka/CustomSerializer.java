package com.arantes.inventory.config.kafka;

import com.arantes.inventory.adapters.out.message.SaleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.yaml.snakeyaml.serializer.SerializerException;

import java.util.Objects;

public class CustomSerializer implements Serializer<SaleMessage> {

    @Override
    public byte[] serialize(String topic, SaleMessage data) {
        try {
            if (Objects.isNull(data)) return null;
            return new ObjectMapper().writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializerException("Error when serializing SaleMessage to byte[]");
        }
    }
}
