package br.edu.ifpb.pdist.back;

import org.springframework.web.bind.annotation.*;

@RestController
public class BackendController {

    @GetMapping("/backend")
    public String getBackendData() {
        return "Backend Data";
    }
}