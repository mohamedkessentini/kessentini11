package com.test.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.test.demo.entity.EntityOne;
import com.test.demo.entity.EntityTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.daoImpl.DaoImpl;

@Service
public class TestService {
	@Autowired
	private DaoImpl daoImpl;
	
    public List<List<Map<String, Object>>> GetAllResults(String...spNameParams){
        return this.daoImpl.callSp(spNameParams);
    }

    public List<EntityOne> getAllEntityOnes(String... spNameParams){
        // Obtenir tous les résultats
        List<List<Map<String, Object>>> AllResults = GetAllResults(spNameParams);
        // Initialiser la liste qui va contenir les résultats
        List<EntityOne> Resultat = new ArrayList<>();

        // Parcourir chaque liste de résultats dans AllResults
        for(List<Map<String, Object>> result : AllResults){
            // Parcourir chaque map dans la liste de résultats
            for(Map<String, Object> map : result){
                // Créer un nouvel objet EntityOne pour chaque map
                EntityOne entityOne = new EntityOne();

                // Supposons que vous voulez extraire deux attributs : "attribut1" et "attribut2"
                // Vérifier si les clés existent pour éviter NullPointerException
                if(map.containsKey("aidprt")){
                    // Obtenir la valeur de "attribut1" et la setter dans entityOne
                    entityOne.setAidprt((String)map.get("aidprt"));
                }
                if(map.containsKey("allprt")){
                    // Obtenir la valeur de "attribut2" et la setter dans entityOne
                    entityOne.setAllprt((String) map.get("allprt"));
                }

                // Ajouter l'objet entityOne configuré à la liste Resultat
                Resultat.add(entityOne);
            }
        }

        // Retourner la liste des EntityOne configurés
        return Resultat;
    }

    public List<EntityTwo> getAllEntityTwos(String... spNameParams){
        // Obtenir tous les résultats
        List<List<Map<String, Object>>> AllResults = GetAllResults(spNameParams);
        // Initialiser la liste qui va contenir les résultats
        List<EntityTwo> Resultat = new ArrayList<>();

        // Parcourir chaque liste de résultats dans AllResults
        for(List<Map<String, Object>> result : AllResults){
            // Parcourir chaque map dans la liste de résultats
            for(Map<String, Object> map : result){
                // Créer un nouvel objet EntityOne pour chaque map
                EntityTwo entityTwo = new EntityTwo();

                // Supposons que vous voulez extraire deux attributs : "attribut1" e, "attribut2" "attribut3" et "attribut4"
                // Vérifier si les clés existent pour éviter NullPointerException
                if(map.containsKey("acdprt")){
                    // Obtenir la valeur de "attribut1" et la setter dans entityOne
                    entityTwo.setAcdprt((String)map.get("acdprt"));
                }
                if(map.containsKey("acealia")){
                    // Obtenir la valeur de "attribut2" et la setter dans entityOne
                    entityTwo.setAcealia((String) map.get("acealia"));
                }
                if(map.containsKey("adtaprt")){
                    // Obtenir la valeur de "attribut3" et la setter dans entityOne
                    entityTwo.setAdtaprt((String) map.get("adtaprt"));
                }
                if(map.containsKey("aidgrp")){
                    // Obtenir la valeur de "attribut4" et la setter dans entityOne
                    entityTwo.setAidgrp((String) map.get("aidgrp"));
                }

                // Ajouter l'objet entityOne configuré à la liste Resultat
                Resultat.add(entityTwo);
            }
        }

        // Retourner la liste des EntityOne configurés
        return Resultat;
    }

}
