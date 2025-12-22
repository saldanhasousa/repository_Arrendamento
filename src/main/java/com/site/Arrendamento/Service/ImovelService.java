package com.site.Arrendamento.Service;

import com.site.Arrendamento.Conversores.ImovelMap;
import com.site.Arrendamento.Conversores.LocalizacaoMap;
import com.site.Arrendamento.Conversores.UsuarioMap;
import com.site.Arrendamento.DTO.ImovelDTOEntrada;
import com.site.Arrendamento.Repository.ImovelRepository;
import com.site.Arrendamento.Repository.LocalizacaoRepository;
import com.site.Arrendamento.Repository.UsuarioRepository;
import com.site.Arrendamento.entidades.Imovel;
import com.site.Arrendamento.entidades.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ImovelService {

 /*@Value("${upload.dir}")
    private String uploadDir;*/

    private final ImovelRepository imovelRepository;
    private final UsuarioRepository usuarioRepository;
    private  final ImovelMap imovelMap;
    private final LocalizacaoRepository localizacaoRepository;
    private final LocalizacaoMap localizacaoMap;
    private final UsuarioMap usuarioMap;
    private final ImagemService imagemService;

    public void cadastrarImovel(ImovelDTOEntrada imovelDTOEntrada) {
       Usuario usuario =usuarioRepository.findByEmail(imovelDTOEntrada.getImail())
               .orElseThrow( ()-> new RuntimeException(" Para publicar o seu imovel necessita ser cadastrado."));




        Imovel imovel=imovelMap.paraImovel(imovelDTOEntrada);
        imovel.setProprietario(usuario);

        try {
            imovel.setImagem1(imagemService.salvarImagem(imovelDTOEntrada.getImagem1()));
            imovel.setImagem2(imagemService.salvarImagem(imovelDTOEntrada.getImagem2()));
            imovel.setImagem3(imagemService.salvarImagem(imovelDTOEntrada.getImagem3()));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar imagens", e);
        }
        imovelRepository.save(imovel);





    }
    public List<Imovel> listarTodos() {
        return imovelRepository.findAll();
    }

    public void deletar(Long id) {
        if (!imovelRepository.existsById(id)) {
            throw new RuntimeException("Imóvel não encontrado");
        }
        imovelRepository.deleteById(id);
    }


}





