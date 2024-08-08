package org.example.service.impl;

import org.example.entity.Paste;
import org.example.repository.PasteRepository;
import org.example.service.MinioService;
import org.example.service.PasteService;
import org.springframework.stereotype.Service;

@Service
public class PasteServiceImpl implements PasteService {

    private final PasteRepository pasteRepository;

    public PasteServiceImpl(PasteRepository pasteRepository) {
        this.pasteRepository = pasteRepository;
    }

    @Override
    public void savePaste(Paste paste) {
        pasteRepository.save(paste);
    }
}
