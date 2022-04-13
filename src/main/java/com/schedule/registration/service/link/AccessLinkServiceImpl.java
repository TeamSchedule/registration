package com.schedule.registration.service.link;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.InetAddress;

@Service
public class AccessLinkServiceImpl implements AccessLinkService {
    private final int port;
    private String link;

    public AccessLinkServiceImpl(@Value("${server.port}") int port) {
        this.port = port;
    }

    @PostConstruct
    @SneakyThrows
    public void init() {
        this.link = "http://" + InetAddress.getLocalHost().getHostAddress() + ":" + port;
    }

    @Override
    public String link() {
        return this.link;
    }
}
