/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "formation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formation.findAll", query = "SELECT f FROM Formation f"),
    @NamedQuery(name = "Formation.findByIdFormation", query = "SELECT f FROM Formation f WHERE f.idFormation = :idFormation"),
    @NamedQuery(name = "Formation.findByNomDiplome", query = "SELECT f FROM Formation f WHERE f.nomDiplome = :nomDiplome"),
    @NamedQuery(name = "Formation.findByUniversite", query = "SELECT f FROM Formation f WHERE f.universite = :universite"),
    @NamedQuery(name = "Formation.findByAnneeOptention", query = "SELECT f FROM Formation f WHERE f.anneeOptention = :anneeOptention"),
    @NamedQuery(name = "Formation.findByMention", query = "SELECT f FROM Formation f WHERE f.mention = :mention")})
public class Formation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFormation")
    private Integer idFormation;
    @Size(max = 350)
    @Column(name = "nomDiplome")
    private String nomDiplome;
    @Size(max = 350)
    @Column(name = "universite")
    private String universite;
    @Column(name = "anneeOptention")
    @Temporal(TemporalType.DATE)
    private Date anneeOptention;
    @Size(max = 254)
    @Column(name = "mention")
    private String mention;
    @JoinColumn(name = "idProfilGL", referencedColumnName = "idProfilGL")
    @ManyToOne(optional = false)
    private Profilgl idProfilGL;

    public Formation() {
    }

    public Formation(Integer idFormation) {
        this.idFormation = idFormation;
    }

    public Integer getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Integer idFormation) {
        this.idFormation = idFormation;
    }

    public String getNomDiplome() {
        return nomDiplome;
    }

    public void setNomDiplome(String nomDiplome) {
        this.nomDiplome = nomDiplome;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public Date getAnneeOptention() {
        return anneeOptention;
    }

    public void setAnneeOptention(Date anneeOptention) {
        this.anneeOptention = anneeOptention;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
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
        hash += (idFormation != null ? idFormation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.idFormation == null && other.idFormation != null) || (this.idFormation != null && !this.idFormation.equals(other.idFormation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Formation[ idFormation=" + idFormation + " ]";
    }
    
}
