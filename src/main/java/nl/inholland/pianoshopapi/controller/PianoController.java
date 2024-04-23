package nl.inholland.pianoshopapi.controller;

import nl.inholland.pianoshopapi.model.Piano;
import nl.inholland.pianoshopapi.model.PianoDTO;
import nl.inholland.pianoshopapi.service.PianoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pianos")
public class PianoController {

    private PianoService pianoService;

    public PianoController(PianoService pianoService) {
        this.pianoService = pianoService;
    }

    private static ResponseEntity<Object> createPianoNotFoundResponse(long id) {
        String message = "Piano with id %d not found".formatted(id);
        Map<String, String> response = Collections.singletonMap("message", message);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<Piano>> getAllPianos() {
        return ResponseEntity.ok(pianoService.getAllPianos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPianoById(@PathVariable long id) {
        try {
            Piano piano = pianoService.getPianoById(id);
            return ResponseEntity.status(HttpStatus.OK).body(piano);
        } catch (Throwable e) {
            return createPianoNotFoundResponse(id);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addPiano(@RequestBody PianoDTO dto) {
        Piano piano = pianoService.addPiano(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(piano);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updatePiano(@PathVariable long id,
                                              @RequestBody PianoDTO dto) {
        try {
            return ResponseEntity.status(200).body(pianoService.updatePiano(id, dto));
        } catch (Exception e) {
            return createPianoNotFoundResponse(id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePiano(@PathVariable long id) {
        try {
            pianoService.deletePiano(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return createPianoNotFoundResponse(id);
        }
    }
}
