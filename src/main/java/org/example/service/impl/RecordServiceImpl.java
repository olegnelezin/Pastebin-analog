package org.example.service.impl;

import org.example.dto.PasteDto;
import org.example.dto.RecordDto;
import org.example.entity.Paste;
import org.example.repository.RecordRepository;
import org.example.service.GenerateUrlService;
import org.example.service.PasteService;
import org.example.service.RecordService;
import org.example.entity.Record;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;

    private final PasteService pasteService;

    private final GenerateUrlService generateUrlService;

    public RecordServiceImpl(RecordRepository recordRepository, PasteService pasteService, GenerateUrlService generateUrlService) {
        this.recordRepository = recordRepository;
        this.pasteService = pasteService;
        this.generateUrlService = generateUrlService;
    }

    public RecordDto createRecord(PasteDto pasteDto) {

        Paste paste = new Paste(pasteDto.getTitle(), "#minioUrl#");
        pasteService.savePaste(paste);

        var record = new Record(generateUrlService.generateUrl(), paste);
        saveRecord(record);

        return new RecordDto(record.getUrl());
    }

    @Override
    public void saveRecord(Record record) {
        recordRepository.save(record);
    }
}