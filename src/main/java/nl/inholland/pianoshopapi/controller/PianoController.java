package nl.inholland.pianoshopapi.controller;

import nl.inholland.pianoshopapi.model.Piano;
import nl.inholland.pianoshopapi.model.dto.PianoDTO;
import nl.inholland.pianoshopapi.service.PianoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pianos")
public class PianoController {

    private PianoService pianoService;

    public PianoController(PianoService pianoService) {
        this.pianoService = pianoService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Object> getPianos() {
        return ResponseEntity.status(200)
                .body(pianoService.getAllPianos());
    }

    @PostMapping
    public ResponseEntity<Object> addPiano(@RequestBody PianoDTO pianoDTO) {
        Piano newPiano = pianoService.addPiano(pianoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(newPiano);
    }
}
