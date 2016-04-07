/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "profilgl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profilgl.findAll", query = "SELECT p FROM Profilgl p"),
    @NamedQuery(name = "Profilgl.findByIdProfilGL", query = "SELECT p FROM Profilgl p WHERE p.idProfilGL = :idProfilGL"),
    @NamedQuery(name = "Profilgl.findByVersion", query = "SELECT p FROM Profilgl p WHERE p.version = :version")})
public class Profilgl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProfilGL")
    private Integer idProfilGL;
    @Column(name = "version")
    private Integer version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfilGL")
    private List<Formation> formationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfilGL")
    private List<Langages> langagesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfilGL")
    private List<Langues> languesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfilGL")
    private List<Experiencesprofessionnelles> experiencesprofessionnellesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfilGL")
    private List<Materielssystemesexploitation> materielssystemesexploitationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfilGL")
    private List<Methodologie> methodologieList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfilGL")
    private List<Bdd> bddList;
    @JoinColumn(name = "idTypeDeProfil", referencedColumnName = "idTypeDeProfil")
    @ManyToOne(optional = false)
    private Profil idTypeDeProfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfilGL")
    private List<Outils> outilsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfilGL")
    private List<Modelisation> modelisationList;

    public Profilgl() {
    }

    public Profilgl(Integer idProfilGL) {
        this.idProfilGL = idProfilGL;
    }

    public Integer getIdProfilGL() {
        return idProfilGL;
    }

    public void setIdProfilGL(Integer idProfilGL) {
        this.idProfilGL = idProfilGL;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @XmlTransient
    public List<Formation> getFormationList() {
        return formationList;
    }

    public void setFormationList(List<Formation> formationList) {
        this.formationList = formationList;
    }

    @XmlTransient
    public List<Langages> getLangagesList() {
        return langagesList;
    }

    public void setLangagesList(List<Langages> langagesList) {
        this.langagesList = langagesList;
    }

    @XmlTransient
    public List<Langues> getLanguesList() {
        return languesList;
    }

    public void setLanguesList(List<Langues> languesList) {
        this.languesList = languesList;
    }

    @XmlTransient
    public List<Experiencesprofessionnelles> getExperiencesprofessionnellesList() {
        return experiencesprofessionnellesList;
    }

    public void setExperiencesprofessionnellesList(List<Experiencesprofessionnelles> experiencesprofessionnellesList) {
        this.experiencesprofessionnellesList = experiencesprofessionnellesList;
    }

    @XmlTransient
    public List<Materielssystemesexploitation> getMaterielssystemesexploitationList() {
        return materielssystemesexploitationList;
    }

    public void setMaterielssystemesexploitationList(List<Materielssystemesexploitation> materielssystemesexploitationList) {
        this.materielssystemesexploitationList = materielssystemesexploitationList;
    }

    @XmlTransient
    public List<Methodologie> getMethodologieList() {
        return methodologieList;
    }

    public void setMethodologieList(List<Methodologie> methodologieList) {
        this.methodologieList = methodologieList;
    }

    @XmlTransient
    public List<Bdd> getBddList() {
        return bddList;
    }

    public void setBddList(List<Bdd> bddList) {
        this.bddList = bddList;
    }

    public Profil getIdTypeDeProfil() {
        return idTypeDeProfil;
    }

    public void setIdTypeDeProfil(Profil idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    @XmlTransient
    public List<Outils> getOutilsList() {
        return outilsList;
    }

    public void setOutilsList(List<Outils> outilsList) {
        this.outilsList = outilsList;
    }

    @XmlTransient
    public List<Modelisation> getModelisationList() {
        return modelisationList;
    }

    public void setModelisationList(List<Modelisation> modelisationList) {
        this.modelisationList = modelisationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfilGL != null ? idProfilGL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profilgl)) {
            return false;
        }
        Profilgl other = (Profilgl) object;
        if ((this.idProfilGL == null && other.idProfilGL != null) || (this.idProfilGL != null && !this.idProfilGL.equals(other.idProfilGL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Profilgl[ idProfilGL=" + idProfilGL + " ]";
    }
    
}
