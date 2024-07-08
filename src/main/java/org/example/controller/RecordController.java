package org.example.controller;

import org.example.dto.RecordDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {

    @PostMapping("/create")
    public RecordDto createPaste() {
        var recordDto = new RecordDto("test");
        return recordDto;
    }
}
