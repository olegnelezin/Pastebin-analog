package org.example.controller;

import org.example.dto.PasteDto;
import org.example.dto.RecordDto;
import org.example.service.PasteService;
import org.example.service.RecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService, PasteService pasteService) {
        this.recordService = recordService;
    }

    @PostMapping("/create")
    public RecordDto createPaste(@RequestBody PasteDto pasteDto) {
        return recordService.createRecord(pasteDto);
    }

    @GetMapping("/{url}")
    public PasteDto getPaste(@PathVariable String url) {
        return recordService.getPasteDto(url);
    }
}