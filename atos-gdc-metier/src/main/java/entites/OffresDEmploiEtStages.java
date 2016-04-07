/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "offres_d_emploi_et_stages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OffresDEmploiEtStages.findAll", query = "SELECT o FROM OffresDEmploiEtStages o"),
    @NamedQuery(name = "OffresDEmploiEtStages.findByIdOffresEmpoiStages", query = "SELECT o FROM OffresDEmploiEtStages o WHERE o.idOffresEmpoiStages = :idOffresEmpoiStages"),
    @NamedQuery(name = "OffresDEmploiEtStages.findByIntitulePoste", query = "SELECT o FROM OffresDEmploiEtStages o WHERE o.intitulePoste = :intitulePoste"),
    @NamedQuery(name = "OffresDEmploiEtStages.findByTypecontrat", query = "SELECT o FROM OffresDEmploiEtStages o WHERE o.typecontrat = :typecontrat"),
    @NamedQuery(name = "OffresDEmploiEtStages.findByCategorieEploi", query = "SELECT o FROM OffresDEmploiEtStages o WHERE o.categorieEploi = :categorieEploi"),
    @NamedQuery(name = "OffresDEmploiEtStages.findByDiplomesDemandes", query = "SELECT o FROM OffresDEmploiEtStages o WHERE o.diplomesDemandes = :diplomesDemandes"),
    @NamedQuery(name = "OffresDEmploiEtStages.findByAnneesMinimumExperience", query = "SELECT o FROM OffresDEmploiEtStages o WHERE o.anneesMinimumExperience = :anneesMinimumExperience"),
    @NamedQuery(name = "OffresDEmploiEtStages.findByLanguesparlees", query = "SELECT o FROM OffresDEmploiEtStages o WHERE o.languesparlees = :languesparlees"),
    @NamedQuery(name = "OffresDEmploiEtStages.findByDebutContrat", query = "SELECT o FROM OffresDEmploiEtStages o WHERE o.debutContrat = :debutContrat"),
    @NamedQuery(name = "OffresDEmploiEtStages.findByDureeContrant", query = "SELECT o FROM OffresDEmploiEtStages o WHERE o.dureeContrant = :dureeContrant")})
public class OffresDEmploiEtStages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOffresEmpoiStages")
    private Integer idOffresEmpoiStages;
    @Size(max = 3000)
    @Column(name = "intitulePoste")
    private String intitulePoste;
    @Lob
    @Size(max = 16777215)
    @Column(name = "descriptionPoste")
    private String descriptionPoste;
    @Size(max = 500)
    @Column(name = "typecontrat")
    private String typecontrat;
    @Size(max = 500)
    @Column(name = "categorieEploi")
    private String categorieEploi;
    @Lob
    @Size(max = 16777215)
    @Column(name = "profilRecherche")
    private String profilRecherche;
    @Size(max = 3000)
    @Column(name = "diplomesDemandes")
    private String diplomesDemandes;
    @Column(name = "anneesMinimumExperience")
    private Integer anneesMinimumExperience;
    @Size(max = 3000)
    @Column(name = "languesparlees")
    private String languesparlees;
    @Lob
    @Size(max = 16777215)
    @Column(name = "preRequis")
    private String preRequis;
    @Lob
    @Size(max = 16777215)
    @Column(name = "descriptifSociete")
    private String descriptifSociete;
    @Column(name = "debutContrat")
    @Temporal(TemporalType.DATE)
    private Date debutContrat;
    @Size(max = 1500)
    @Column(name = "dureeContrant")
    private String dureeContrant;
    @OneToMany(mappedBy = "idOffresEmpoiStages")
    private List<Postulations> postulationsList;
    @JoinColumn(name = "idRecruteur", referencedColumnName = "idRecruteur")
    @ManyToOne
    private Recruteur idRecruteur;

    public OffresDEmploiEtStages() {
    }

    public OffresDEmploiEtStages(Integer idOffresEmpoiStages) {
        this.idOffresEmpoiStages = idOffresEmpoiStages;
    }

    public Integer getIdOffresEmpoiStages() {
        return idOffresEmpoiStages;
    }

    public void setIdOffresEmpoiStages(Integer idOffresEmpoiStages) {
        this.idOffresEmpoiStages = idOffresEmpoiStages;
    }

    public String getIntitulePoste() {
        return intitulePoste;
    }

    public void setIntitulePoste(String intitulePoste) {
        this.intitulePoste = intitulePoste;
    }

    public String getDescriptionPoste() {
        return descriptionPoste;
    }

    public void setDescriptionPoste(String descriptionPoste) {
        this.descriptionPoste = descriptionPoste;
    }

    public String getTypecontrat() {
        return typecontrat;
    }

    public void setTypecontrat(String typecontrat) {
        this.typecontrat = typecontrat;
    }

    public String getCategorieEploi() {
        return categorieEploi;
    }

    public void setCategorieEploi(String categorieEploi) {
        this.categorieEploi = categorieEploi;
    }

    public String getProfilRecherche() {
        return profilRecherche;
    }

    public void setProfilRecherche(String profilRecherche) {
        this.profilRecherche = profilRecherche;
    }

    public String getDiplomesDemandes() {
        return diplomesDemandes;
    }

    public void setDiplomesDemandes(String diplomesDemandes) {
        this.diplomesDemandes = diplomesDemandes;
    }

    public Integer getAnneesMinimumExperience() {
        return anneesMinimumExperience;
    }

    public void setAnneesMinimumExperience(Integer anneesMinimumExperience) {
        this.anneesMinimumExperience = anneesMinimumExperience;
    }

    public String getLanguesparlees() {
        return languesparlees;
    }

    public void setLanguesparlees(String languesparlees) {
        this.languesparlees = languesparlees;
    }

    public String getPreRequis() {
        return preRequis;
    }

    public void setPreRequis(String preRequis) {
        this.preRequis = preRequis;
    }

    public String getDescriptifSociete() {
        return descriptifSociete;
    }

    public void setDescriptifSociete(String descriptifSociete) {
        this.descriptifSociete = descriptifSociete;
    }

    public Date getDebutContrat() {
        return debutContrat;
    }

    public void setDebutContrat(Date debutContrat) {
        this.debutContrat = debutContrat;
    }

    public String getDureeContrant() {
        return dureeContrant;
    }

    public void setDureeContrant(String dureeContrant) {
        this.dureeContrant = dureeContrant;
    }

    @XmlTransient
    public List<Postulations> getPostulationsList() {
        return postulationsList;
    }

    public void setPostulationsList(List<Postulations> postulationsList) {
        this.postulationsList = postulationsList;
    }

    public Recruteur getIdRecruteur() {
        return idRecruteur;
    }

    public void setIdRecruteur(Recruteur idRecruteur) {
        this.idRecruteur = idRecruteur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOffresEmpoiStages != null ? idOffresEmpoiStages.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OffresDEmploiEtStages)) {
            return false;
        }
        OffresDEmploiEtStages other = (OffresDEmploiEtStages) object;
        if ((this.idOffresEmpoiStages == null && other.idOffresEmpoiStages != null) || (this.idOffresEmpoiStages != null && !this.idOffresEmpoiStages.equals(other.idOffresEmpoiStages))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.OffresDEmploiEtStages[ idOffresEmpoiStages=" + idOffresEmpoiStages + " ]";
    }
    
}
