package com.site.Arrendamento.DTO;

import com.site.Arrendamento.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSaidaDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String tipoUsuario;
    private String dataCadastro;


    public UsuarioSaidaDTO(Usuario usuario) {

        //Para que retorn os usuarios
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.telefone = usuario.getTelefone();
        this.email = usuario.getEmail();
        //Pediu para fazer isso
        this.tipoUsuario = String.valueOf(usuario.getTipoUsuario());
        //this.dataCadastro = usuario.getDataCadastro().toString();
    }
}
