package org.example.service;

import org.example.dto.PasteDto;
import org.example.entity.Paste;
import org.example.entity.Record;

public interface PasteService {

    void savePaste(Paste paste);
}
