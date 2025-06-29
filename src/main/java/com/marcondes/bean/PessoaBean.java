package com.marcondes.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.marcondes.dao.DaoGeneric;
import com.marcondes.entidades.Pessoa;

@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaBean {
    
    private Pessoa pessoa = new Pessoa();
    private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();

    public String salvar(){
        pessoa = daoGeneric.merge(pessoa);
        carregarPessoas();
        return "";
    }

    public  String novo(){
        pessoa = new Pessoa();
        return "";
    }

    public String deletar(){
        daoGeneric.deletarPorId(pessoa);
        novo();
        carregarPessoas();
        return "";
    }

    @PostConstruct  //executa a funçao ao abir a página
    public void carregarPessoas(){
        pessoas = daoGeneric.getListEntity(Pessoa.class);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    

    

}
