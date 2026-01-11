package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Nome")
    private String nome;

    @Column(unique = true, name = "Email")
    private String email;

    @Column(name = "Idade")
    private int idade;

    // @ManyToOne: um ninja tem uma única missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreign Key ou Chave Estrangeira
    private MissoesModel missoes;

}
