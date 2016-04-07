/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "avoirquestions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avoirquestions.findAll", query = "SELECT a FROM Avoirquestions a"),
    @NamedQuery(name = "Avoirquestions.findByIdquestionsFicheTest", query = "SELECT a FROM Avoirquestions a WHERE a.idquestionsFicheTest = :idquestionsFicheTest")})
public class Avoirquestions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idquestionsFicheTest")
    private Integer idquestionsFicheTest;
    @JoinColumn(name = "idFicheTest", referencedColumnName = "idFicheTest")
    @ManyToOne
    private Fichedetest idFicheTest;
    @JoinColumn(name = "idQuestion", referencedColumnName = "idQuestion")
    @ManyToOne
    private Listequestions idQuestion;

    public Avoirquestions() {
    }

    public Avoirquestions(Integer idquestionsFicheTest) {
        this.idquestionsFicheTest = idquestionsFicheTest;
    }

    public Integer getIdquestionsFicheTest() {
        return idquestionsFicheTest;
    }

    public void setIdquestionsFicheTest(Integer idquestionsFicheTest) {
        this.idquestionsFicheTest = idquestionsFicheTest;
    }

    public Fichedetest getIdFicheTest() {
        return idFicheTest;
    }

    public void setIdFicheTest(Fichedetest idFicheTest) {
        this.idFicheTest = idFicheTest;
    }

    public Listequestions getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Listequestions idQuestion) {
        this.idQuestion = idQuestion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idquestionsFicheTest != null ? idquestionsFicheTest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avoirquestions)) {
            return false;
        }
        Avoirquestions other = (Avoirquestions) object;
        if ((this.idquestionsFicheTest == null && other.idquestionsFicheTest != null) || (this.idquestionsFicheTest != null && !this.idquestionsFicheTest.equals(other.idquestionsFicheTest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Avoirquestions[ idquestionsFicheTest=" + idquestionsFicheTest + " ]";
    }
    
}
