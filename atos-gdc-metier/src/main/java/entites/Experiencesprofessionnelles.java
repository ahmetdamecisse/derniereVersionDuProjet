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
import javax.persistence.Lob;
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
@Table(name = "experiencesprofessionnelles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiencesprofessionnelles.findAll", query = "SELECT e FROM Experiencesprofessionnelles e"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByIdExperiencesProfess", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.idExperiencesProfess = :idExperiencesProfess"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByDatedebut", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.datedebut = :datedebut"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByDateFin", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.dateFin = :dateFin"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByEnvironnement", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.environnement = :environnement"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByProjet", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.projet = :projet"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByMissionsRealisees", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.missionsRealisees = :missionsRealisees")})
public class Experiencesprofessionnelles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idExperiencesProfess")
    private Integer idExperiencesProfess;
    @Lob
    @Size(max = 16777215)
    @Column(name = "description")
    private String description;
    @Column(name = "datedebut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Column(name = "dateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Lob
    @Size(max = 16777215)
    @Column(name = "fonction")
    private String fonction;
    @Size(max = 3000)
    @Column(name = "environnement")
    private String environnement;
    @Size(max = 3000)
    @Column(name = "projet")
    private String projet;
    @Size(max = 5000)
    @Column(name = "missionsRealisees")
    private String missionsRealisees;
    @JoinColumn(name = "idProfilGL", referencedColumnName = "idProfilGL")
    @ManyToOne(optional = false)
    private Profilgl idProfilGL;

    public Experiencesprofessionnelles() {
    }

    public Experiencesprofessionnelles(Integer idExperiencesProfess) {
        this.idExperiencesProfess = idExperiencesProfess;
    }

    public Integer getIdExperiencesProfess() {
        return idExperiencesProfess;
    }

    public void setIdExperiencesProfess(Integer idExperiencesProfess) {
        this.idExperiencesProfess = idExperiencesProfess;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(String environnement) {
        this.environnement = environnement;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getMissionsRealisees() {
        return missionsRealisees;
    }

    public void setMissionsRealisees(String missionsRealisees) {
        this.missionsRealisees = missionsRealisees;
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
        hash += (idExperiencesProfess != null ? idExperiencesProfess.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencesprofessionnelles)) {
            return false;
        }
        Experiencesprofessionnelles other = (Experiencesprofessionnelles) object;
        if ((this.idExperiencesProfess == null && other.idExperiencesProfess != null) || (this.idExperiencesProfess != null && !this.idExperiencesProfess.equals(other.idExperiencesProfess))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Experiencesprofessionnelles[ idExperiencesProfess=" + idExperiencesProfess + " ]";
    }
    
}
