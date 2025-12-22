package com.site.Arrendamento.Controlo;

import com.site.Arrendamento.DTO.ImovelDTOEntrada;
import com.site.Arrendamento.Service.ImovelService;
import com.site.Arrendamento.entidades.Imovel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imovel")
public class ImovelControlo {
    @Autowired
    ImovelService imovelService;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> cadastrarImovel(  @ModelAttribute @Valid ImovelDTOEntrada imovelDTOEntrada){
        imovelService.cadastrarImovel(imovelDTOEntrada);
        return ResponseEntity.ok("Imovel cadastrado com sucesso");

    }


    // ✅ LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<Imovel>> listarImoveis() {
        return ResponseEntity.ok(imovelService.listarTodos());
    }

    // ✅ DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarImovel(@PathVariable Long id) {
        imovelService.deletar(id);
        return ResponseEntity.noContent().build(); // 204
    }

}

