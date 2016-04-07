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
import javax.persistence.ManyToMany;
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
@Table(name = "recruteur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recruteur.findAll", query = "SELECT r FROM Recruteur r"),
    @NamedQuery(name = "Recruteur.findByIdRecruteur", query = "SELECT r FROM Recruteur r WHERE r.idRecruteur = :idRecruteur")})
public class Recruteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRecruteur")
    private Integer idRecruteur;
    @ManyToMany(mappedBy = "recruteurList")
    private List<Candidat> candidatList;
    @ManyToMany(mappedBy = "recruteurList1")
    private List<Candidat> candidatList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecruteur")
    private List<Fichedeposte> fichedeposteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecruteur")
    private List<Notification> notificationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecruteur")
    private List<Entretien> entretienList;
    @OneToMany(mappedBy = "idRecruteur")
    private List<OffresDEmploiEtStages> offresDEmploiEtStagesList;
    @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idUtilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecruteur")
    private List<Fichedetest> fichedetestList;

    public Recruteur() {
    }

    public Recruteur(Integer idRecruteur) {
        this.idRecruteur = idRecruteur;
    }

    public Integer getIdRecruteur() {
        return idRecruteur;
    }

    public void setIdRecruteur(Integer idRecruteur) {
        this.idRecruteur = idRecruteur;
    }

    @XmlTransient
    public List<Candidat> getCandidatList() {
        return candidatList;
    }

    public void setCandidatList(List<Candidat> candidatList) {
        this.candidatList = candidatList;
    }

    @XmlTransient
    public List<Candidat> getCandidatList1() {
        return candidatList1;
    }

    public void setCandidatList1(List<Candidat> candidatList1) {
        this.candidatList1 = candidatList1;
    }

    @XmlTransient
    public List<Fichedeposte> getFichedeposteList() {
        return fichedeposteList;
    }

    public void setFichedeposteList(List<Fichedeposte> fichedeposteList) {
        this.fichedeposteList = fichedeposteList;
    }

    @XmlTransient
    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @XmlTransient
    public List<Entretien> getEntretienList() {
        return entretienList;
    }

    public void setEntretienList(List<Entretien> entretienList) {
        this.entretienList = entretienList;
    }

    @XmlTransient
    public List<OffresDEmploiEtStages> getOffresDEmploiEtStagesList() {
        return offresDEmploiEtStagesList;
    }

    public void setOffresDEmploiEtStagesList(List<OffresDEmploiEtStages> offresDEmploiEtStagesList) {
        this.offresDEmploiEtStagesList = offresDEmploiEtStagesList;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @XmlTransient
    public List<Fichedetest> getFichedetestList() {
        return fichedetestList;
    }

    public void setFichedetestList(List<Fichedetest> fichedetestList) {
        this.fichedetestList = fichedetestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecruteur != null ? idRecruteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recruteur)) {
            return false;
        }
        Recruteur other = (Recruteur) object;
        if ((this.idRecruteur == null && other.idRecruteur != null) || (this.idRecruteur != null && !this.idRecruteur.equals(other.idRecruteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Recruteur[ idRecruteur=" + idRecruteur + " ]";
    }
    
}
