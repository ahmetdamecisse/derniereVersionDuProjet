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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "langages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Langages.findAll", query = "SELECT l FROM Langages l"),
    @NamedQuery(name = "Langages.findByIdLangages", query = "SELECT l FROM Langages l WHERE l.idLangages = :idLangages"),
    @NamedQuery(name = "Langages.findByDomaine", query = "SELECT l FROM Langages l WHERE l.domaine = :domaine"),
    @NamedQuery(name = "Langages.findByNiveau", query = "SELECT l FROM Langages l WHERE l.niveau = :niveau")})
public class Langages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLangages")
    private Integer idLangages;
    @Size(max = 350)
    @Column(name = "domaine")
    private String domaine;
    @Size(max = 350)
    @Column(name = "niveau")
    private String niveau;
    @JoinColumn(name = "idProfilGL", referencedColumnName = "idProfilGL")
    @ManyToOne(optional = false)
    private Profilgl idProfilGL;

    public Langages() {
    }

    public Langages(Integer idLangages) {
        this.idLangages = idLangages;
    }

    public Integer getIdLangages() {
        return idLangages;
    }

    public void setIdLangages(Integer idLangages) {
        this.idLangages = idLangages;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Profilgl getIdProfilGL() {
        return idProfilGL;
    }

    public void setIdProfilGL(Profilgl idProfilGL) {
        this.idProfilGL = idProfilGL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLangages != null ? idLangages.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Langages)) {
            return false;
        }
        Langages other = (Langages) object;
        if ((this.idLangages == null && other.idLangages != null) || (this.idLangages != null && !this.idLangages.equals(other.idLangages))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Langages[ idLangages=" + idLangages + " ]";
    }
    
}
