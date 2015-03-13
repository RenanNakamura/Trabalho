package br.unicesumar.restserver.Disciplina;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Disciplinas")
@Transactional
public class ManterDisciplina {
    @Autowired
    private EntityManager em;
    
    @RequestMapping(method = RequestMethod.GET )
    public List<Disciplina> getDisciplina(){
        return this.em.createQuery("from Disciplina").getResultList();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void criarDisciplina(@RequestBody Disciplina disciplina){
        em.persist(disciplina);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public void atualizaDisciplina(@RequestBody Disciplina disciplina){
        disciplina = em.merge(disciplina);
        this.em.persist(disciplina);
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void removeDisciplina(@PathVariable long id){
        this.em.createQuery("delete from Disciplina d where d.id = :id").setParameter("id", id).executeUpdate();         
        
    }
}
