package org.example.controller;

import org.example.dto.PasteDto;
import org.example.dto.RecordDto;
import org.example.service.RecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping("/create")
    public RecordDto createPaste(@RequestBody PasteDto pasteDto) {
        var recordDto = recordService.createRecord(pasteDto);
        return recordDto;
    }

    @GetMapping
    public PasteDto getPaste() {
        var pasteDto = new PasteDto("title", "text");
        return pasteDto;
    }
}