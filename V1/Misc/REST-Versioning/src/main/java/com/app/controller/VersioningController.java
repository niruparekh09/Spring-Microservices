package com.app.controller;

import com.app.model.Name;
import com.app.model.PersonV1;
import com.app.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class VersioningController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersion() {
        return new PersonV1("NRV ROGERS");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersion() {
        return new PersonV2(new Name("NRV", "ROGERS"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionViaParams() {
        return new PersonV1("NRV ROGERS");
    }

    @GetMapping(path     = "/person", params = "version=2")
    public PersonV2 getSecondVersionViaParams() {
        return new PersonV2(new Name("NRV", "ROGERS"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionViaRequestHeader() {
        return new PersonV1("NRV ROGERS");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionViaRequestHeader() {
        return new PersonV2(new Name("NRV", "ROGERS"));
    }

    @GetMapping(path = "/person/header", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionViaAcceptHeader() {
        return new PersonV1("NRV ROGERS");
    }

    @GetMapping(path = "/person/header", produces ="application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionViaAcceptHeader() {
        return new PersonV2(new Name("NRV", "ROGERS"));
    }
}
