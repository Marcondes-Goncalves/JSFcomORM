package com.marcondes.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.marcondes.dao.DaoGeneric;
import com.marcondes.entidades.Pessoa;

@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaBean {
    
    private Pessoa pessoa = new Pessoa();
    private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();

    public String salvar(){
        daoGeneric.salvar(pessoa);
        
        return "";
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    

}
