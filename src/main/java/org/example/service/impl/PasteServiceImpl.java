package org.example.service.impl;

import lombok.AllArgsConstructor;
import org.example.entity.Paste;
import org.example.repository.PasteRepository;
import org.example.service.PasteService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PasteServiceImpl implements PasteService {

    private final PasteRepository pasteRepository;

    @Override
    public void savePaste(Paste paste) {
        pasteRepository.save(paste);
    }
}
