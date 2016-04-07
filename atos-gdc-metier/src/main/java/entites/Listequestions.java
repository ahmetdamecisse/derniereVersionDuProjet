/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "listequestions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listequestions.findAll", query = "SELECT l FROM Listequestions l"),
    @NamedQuery(name = "Listequestions.findByIdQuestion", query = "SELECT l FROM Listequestions l WHERE l.idQuestion = :idQuestion"),
    @NamedQuery(name = "Listequestions.findByQuestion", query = "SELECT l FROM Listequestions l WHERE l.question = :question")})
public class Listequestions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idQuestion")
    private Integer idQuestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3000)
    @Column(name = "question")
    private String question;
    @OneToMany(mappedBy = "idQuestion")
    private List<Avoirreponse> avoirreponseList;
    @OneToMany(mappedBy = "idQuestion")
    private List<Avoirquestions> avoirquestionsList;

    public Listequestions() {
    }

    public Listequestions(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Listequestions(Integer idQuestion, String question) {
        this.idQuestion = idQuestion;
        this.question = question;
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @XmlTransient
    public List<Avoirreponse> getAvoirreponseList() {
        return avoirreponseList;
    }

    public void setAvoirreponseList(List<Avoirreponse> avoirreponseList) {
        this.avoirreponseList = avoirreponseList;
    }

    @XmlTransient
    public List<Avoirquestions> getAvoirquestionsList() {
        return avoirquestionsList;
    }

    public void setAvoirquestionsList(List<Avoirquestions> avoirquestionsList) {
        this.avoirquestionsList = avoirquestionsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestion != null ? idQuestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listequestions)) {
            return false;
        }
        Listequestions other = (Listequestions) object;
        if ((this.idQuestion == null && other.idQuestion != null) || (this.idQuestion != null && !this.idQuestion.equals(other.idQuestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Listequestions[ idQuestion=" + idQuestion + " ]";
    }
    
}
