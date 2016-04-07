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
@Table(name = "avoirreponse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avoirreponse.findAll", query = "SELECT a FROM Avoirreponse a"),
    @NamedQuery(name = "Avoirreponse.findByIdReponsesQuestions", query = "SELECT a FROM Avoirreponse a WHERE a.idReponsesQuestions = :idReponsesQuestions")})
public class Avoirreponse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idReponsesQuestions")
    private Integer idReponsesQuestions;
    @JoinColumn(name = "idQuestion", referencedColumnName = "idQuestion")
    @ManyToOne
    private Listequestions idQuestion;
    @JoinColumn(name = "idReponse", referencedColumnName = "idReponse")
    @ManyToOne
    private Listereponse idReponse;

    public Avoirreponse() {
    }

    public Avoirreponse(Integer idReponsesQuestions) {
        this.idReponsesQuestions = idReponsesQuestions;
    }

    public Integer getIdReponsesQuestions() {
        return idReponsesQuestions;
    }

    public void setIdReponsesQuestions(Integer idReponsesQuestions) {
        this.idReponsesQuestions = idReponsesQuestions;
    }

    public Listequestions getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Listequestions idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Listereponse getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(Listereponse idReponse) {
        this.idReponse = idReponse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReponsesQuestions != null ? idReponsesQuestions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avoirreponse)) {
            return false;
        }
        Avoirreponse other = (Avoirreponse) object;
        if ((this.idReponsesQuestions == null && other.idReponsesQuestions != null) || (this.idReponsesQuestions != null && !this.idReponsesQuestions.equals(other.idReponsesQuestions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Avoirreponse[ idReponsesQuestions=" + idReponsesQuestions + " ]";
    }
    
}
