package org.example.service.impl;

import lombok.AllArgsConstructor;
import org.example.dto.PasteDto;
import org.example.dto.RecordDto;
import org.example.entity.Paste;
import org.example.repository.RecordRepository;
import org.example.service.GenerateUrlService;
import org.example.service.MinioService;
import org.example.service.PasteService;
import org.example.service.RecordService;
import org.example.entity.Record;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;

    private final PasteService pasteService;

    private final GenerateUrlService generateUrlService;

    private final MinioService minioService;

    public RecordDto createRecord(PasteDto pasteDto) {
        var paste = new Paste(pasteDto.getTitle(),
                minioService.uploadText(pasteDto.getText()));
        pasteService.savePaste(paste);

        var uniqueUrl = generateUrlService.generateUrl();
        while (recordRepository.existsByUrl(uniqueUrl)) {
            uniqueUrl = generateUrlService.generateUrl();
        }

        var record = new Record(uniqueUrl, paste);
        saveRecord(record);

        return new RecordDto(record.getUrl());
    }

    @Override
    public void saveRecord(Record record) {
        recordRepository.save(record);
    }

    @Override
    public Record findRecordByUrl(String url) {
        return recordRepository.findRecordByUrl(url).orElseThrow();
    }

    @Override
    public PasteDto getPasteDto(String url) {
        var paste = findRecordByUrl(url).getPaste();
        return new PasteDto(paste.getTitle(),
                minioService.getText(paste.getMinioUrl()));
    }
}
