package com.cricket.stockmarket.api.restricted;

import com.cricket.stockmarket.t20.service.T20Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class T20Api {

    private final T20Service t20Service;

    @PostMapping(value = "/populate")
    public void populateInitialValues() {

    }
}
