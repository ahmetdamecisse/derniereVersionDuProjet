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
@Table(name = "langues")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Langues.findAll", query = "SELECT l FROM Langues l"),
    @NamedQuery(name = "Langues.findByIdLangues", query = "SELECT l FROM Langues l WHERE l.idLangues = :idLangues"),
    @NamedQuery(name = "Langues.findByNom", query = "SELECT l FROM Langues l WHERE l.nom = :nom"),
    @NamedQuery(name = "Langues.findByNiveau", query = "SELECT l FROM Langues l WHERE l.niveau = :niveau")})
public class Langues implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLangues")
    private Integer idLangues;
    @Size(max = 350)
    @Column(name = "nom")
    private String nom;
    @Size(max = 350)
    @Column(name = "niveau")
    private String niveau;
    @JoinColumn(name = "idProfilGL", referencedColumnName = "idProfilGL")
    @ManyToOne(optional = false)
    private Profilgl idProfilGL;

    public Langues() {
    }

    public Langues(Integer idLangues) {
        this.idLangues = idLangues;
    }

    public Integer getIdLangues() {
        return idLangues;
    }

    public void setIdLangues(Integer idLangues) {
        this.idLangues = idLangues;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        hash += (idLangues != null ? idLangues.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Langues)) {
            return false;
        }
        Langues other = (Langues) object;
        if ((this.idLangues == null && other.idLangues != null) || (this.idLangues != null && !this.idLangues.equals(other.idLangues))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Langues[ idLangues=" + idLangues + " ]";
    }
    
}
