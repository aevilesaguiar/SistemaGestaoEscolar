package com.treinamento.teste;


import com.treinamento.dao.EmpresaDAO;
import com.treinamento.dao.JPAUtil;
import com.treinamento.dao.UnidadeDAO;
import com.treinamento.model.*;


import javax.persistence.EntityManager;
import java.util.Arrays;

public class PersistindoEmpresa {

    public static void main(String[] args) {
        // obtém o entity manager
        EntityManager em = JPAUtil.getEntityManager();

        Empresa empresa = new Empresa("USP") ;
        Empresa empresa1 = new Empresa("Juscelino Kubtheck") ;

        Unidade unidade = new Unidade("Objetivo","Rua francisco,01,Serraria");
        Unidade unidade2 = new Unidade("Juscelino centro","Rua francisco,56,Dom pedro");

        EmpresaDAO empresaDAO= new EmpresaDAO(em);
        UnidadeDAO unidadeDAO=new UnidadeDAO(em);

        //perssit empresa

        empresaDAO.save(empresa);
        empresaDAO.save(empresa1);

        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();

        /*


        Curso curso= new Curso("Engenharia Macatronica");
        Curso curso1= new Curso("Engenharia de Produção");

        Disciplina disciplina=new Disciplina("Física");
        Disciplina disciplina1=new Disciplina("Química");
        Disciplina disciplina2=new Disciplina("Mecânica dos Fluidos");
        Disciplina disciplina3=new Disciplina("Resistencia dos materiais");

        PeriodoCurso periodoCurso =new PeriodoCurso("Manhã");
        PeriodoCurso periodoCurso1 =new PeriodoCurso("Tarde");
        PeriodoCurso periodoCurso2 =new PeriodoCurso("Noite");


        Aluno aluno=new Aluno("João da Silva","123445",Sexo.MASCULINO);
        Aluno aluno1=new Aluno("Fernanda Souza","129999",Sexo.FEMININO);
        Aluno aluno2=new Aluno("Joana da Silva","123444",Sexo.FEMININO);


        Professor professor1=new Professor("Fernando","12545",Sexo.MASCULINO);
        Professor professor2=new Professor("Arlete","45698",Sexo.FEMININO);

        //setando os atributos

        disciplina.setSemestre(periodoCurso);
        disciplina1.setSemestre(periodoCurso1);
        disciplina2.setSemestre(periodoCurso2);
        disciplina3.setSemestre(periodoCurso);


        periodoCurso.setCurso(curso);
        periodoCurso.setDisciplinas(Arrays.asList(disciplina1,disciplina2,disciplina3));


        periodoCurso1.setCurso(curso);
        periodoCurso1.setDisciplinas(Arrays.asList(disciplina2,disciplina3));


        periodoCurso2.setCurso(curso1);
        periodoCurso2.setDisciplinas(Arrays.asList(disciplina1,disciplina3,disciplina2));


        curso.setPeriodoCursos(Arrays.asList(periodoCurso1,periodoCurso2));

        empresa.setUnidades(Arrays.asList(unidade));
        empresa1.setUnidades(Arrays.asList(unidade2));

        unidade.setAlunos(Arrays.asList(aluno1,aluno));
        unidade2.setAlunos(Arrays.asList(aluno,aluno2));

        unidade.setProfessores(Arrays.asList(professor1,professor2));
        unidade2.setProfessores(Arrays.asList(professor2));


        unidade.setEmpresa(empresa);
        unidade2.setEmpresa(empresa1);

        unidade.setAlunos(Arrays.asList(aluno2,aluno));
        unidade.setProfessores(Arrays.asList(professor1));
        unidade.setEmpresa(empresa);
        unidade.setCursos(Arrays.asList(curso1));

        unidade2.setAlunos(Arrays.asList(aluno1,aluno));
        unidade2.setProfessores(Arrays.asList(professor2));
        unidade2.setEmpresa(empresa1);
        unidade2.setCursos(Arrays.asList(curso1));


*/




    }
}
