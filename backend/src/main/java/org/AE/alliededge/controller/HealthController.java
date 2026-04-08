package org.AE.alliededge.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Simple health endpoints.
 *
 * Why:
 * - Render/Cloudflare (or other monitors) may probe GET/HEAD /.
 * - Without a mapping, Spring can log NoResourceFoundException for "/".
 * - Having a fast 200 OK endpoint also makes it easier to confirm the service is reachable.
 */
@RestController
public class HealthController {

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String root() {
        return "OK";
    }

    @GetMapping(value = "/api/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> apiHealth() {
        return Map.of("status", "UP");
    }
}

