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
@Table(name = "bdd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bdd.findAll", query = "SELECT b FROM Bdd b"),
    @NamedQuery(name = "Bdd.findByIdBDD", query = "SELECT b FROM Bdd b WHERE b.idBDD = :idBDD"),
    @NamedQuery(name = "Bdd.findByDomaine", query = "SELECT b FROM Bdd b WHERE b.domaine = :domaine"),
    @NamedQuery(name = "Bdd.findByNiveau", query = "SELECT b FROM Bdd b WHERE b.niveau = :niveau")})
public class Bdd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBDD")
    private Integer idBDD;
    @Size(max = 350)
    @Column(name = "domaine")
    private String domaine;
    @Size(max = 350)
    @Column(name = "niveau")
    private String niveau;
    @JoinColumn(name = "idProfilGL", referencedColumnName = "idProfilGL")
    @ManyToOne(optional = false)
    private Profilgl idProfilGL;

    public Bdd() {
    }

    public Bdd(Integer idBDD) {
        this.idBDD = idBDD;
    }

    public Integer getIdBDD() {
        return idBDD;
    }

    public void setIdBDD(Integer idBDD) {
        this.idBDD = idBDD;
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
        hash += (idBDD != null ? idBDD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bdd)) {
            return false;
        }
        Bdd other = (Bdd) object;
        if ((this.idBDD == null && other.idBDD != null) || (this.idBDD != null && !this.idBDD.equals(other.idBDD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Bdd[ idBDD=" + idBDD + " ]";
    }
    
}
