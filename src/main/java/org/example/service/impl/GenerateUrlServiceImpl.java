package org.example.service.impl;

import org.apache.tomcat.util.codec.binary.Base64;
import org.example.service.GenerateUrlService;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.UUID;

@Service
public class GenerateUrlServiceImpl implements GenerateUrlService {

    @Override
    public String generateUrl() {
        var uuid = UUID.randomUUID();
        var byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        byte[] uuidBytes = byteBuffer.array();
        return Base64.encodeBase64String(uuidBytes).substring(1, 8);
    }
}
