package com.treinamento.teste;

import com.treinamento.model.*;

import java.util.Arrays;

public class PersistindoEmpresa {

    public static void main(String[] args) {

        Empresa empresa = new Empresa("USP") ;
        Unidade unidade = new Unidade("Rua Francisco");

        Curso curso= new Curso("Engenharia Macatronica");

        Disciplina disciplina=new Disciplina("Física");
        Disciplina disciplina1=new Disciplina("Química");
        Disciplina disciplina2=new Disciplina("Mecânica dos Fluidos");
        Disciplina disciplina3=new Disciplina("Resistencia dos materiais");

        Semestre semestre=new Semestre("Manhã");
        Semestre semestre1=new Semestre("Tarde");
        Semestre semestre2=new Semestre("Noite");


        Aluno aluno=new Aluno("João da Silva","123445",Sexo.MASCULINO);
        Aluno aluno1=new Aluno("Fernanda Souza","129999",Sexo.FEMININO);
        Aluno aluno2=new Aluno("Joana da Silva","123444",Sexo.FEMININO);

        //setando os atributos

        disciplina.setSemestre(semestre);
        disciplina1.setSemestre(semestre1);
        disciplina2.setSemestre(semestre2);
        disciplina3.setSemestre(semestre);


        semestre.setCurso(curso);
        semestre.setDisciplinas(Arrays.asList(disciplina1,disciplina2,disciplina3));


        semestre1.setCurso(curso);
        semestre1.setDisciplinas(Arrays.asList(disciplina2,disciplina3));

        curso.setSemestreList(Arrays.asList(semestre2,semestre,semestre1));

        empresa.setUnidades(Arrays.asList(unidade));


    }
}
