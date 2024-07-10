package org.example.service;

import org.example.dto.PasteDto;
import org.example.dto.RecordDto;
import org.example.entity.Record;

public interface RecordService {

    void saveRecord(Record record);

    RecordDto createRecord(PasteDto pasteDto);
}
