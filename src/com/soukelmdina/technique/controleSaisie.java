/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.technique;

import javafx.scene.control.Label;

/**
 *
 * @author mosla
 */
public class controleSaisie {

    public boolean controleTextFieldVide(String chaine) {
        if (chaine.length() == 0) {
            return true;
        }
        return false;
    }

    /* public boolean controleTextFieldNonNumerique(String chaine) {
        if (!chaine.matches(".*[a-zA-Z].*")) {
            return true;
        }
        return false;
    }*/
    public boolean controleTextFieldOnlyLetters(String chaine) {
        char[] tab = chaine.toCharArray();

        boolean valide = true;

        for (int i = 0; i < tab.length; i++) {
            if (Character.isDigit(tab[i]) || tab[i] == '.' || tab[i] == ',' || tab[i] == '-' || tab[i] == '_' || tab[i] == '@') {
                valide = false;
            }
        }

        if (!valide) {
            return true;
        }
        return false;
    }

    public boolean controleTextFieldChiffres(String chaine) {
        char[] tab = chaine.toCharArray();

        boolean estUnNombre = true;
        for (int i = 0; i < tab.length; i++) {
            if (!Character.isDigit(tab[i])) {
                estUnNombre = false;
            }
        }
        if (!estUnNombre) {
            return true;
        }
        return false;
    }

    public boolean controleCINLongueur(String chaine) {

        if (chaine.length() != 8) {
            return true;
        }
        return false;
    }

    public boolean controleCPLongueur(String chaine) {

        if (chaine.length() != 4) {
            System.out.println(chaine);
            return true;
        }
        return false;
    }

    public boolean controleNumTelLongueur(String chaine) {
        if (chaine.length() != 8) {
            return true;
        }
        return false;
    }

       public boolean isValidFloat(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;		
	}
    
    
    
    public boolean controleMailFormat(String chaine) {
        if (chaine.length() != 0) {
            if (chaine.charAt(chaine.length() - 1) == '.') {
                return true;
            } else {

                int firstIndexA = chaine.indexOf("@");
                int lastIndexA = chaine.lastIndexOf("@");
                int lastIndexPt = chaine.lastIndexOf(".");
                if (firstIndexA < 3 || firstIndexA != lastIndexA || firstIndexA > lastIndexPt || lastIndexPt - firstIndexA < 4 || chaine.substring(lastIndexPt + 1, chaine.length() - 1).length() > 3 || chaine.substring(lastIndexPt + 1, chaine.length()).length() < 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean controleComplexiteMDP(String chaine) {
        char[] tab = chaine.toCharArray();
        boolean chiffre = false;
        boolean minus = false;
        boolean majus = false;

        for (int i = 0; i < tab.length; i++) {
            if (Character.isDigit(tab[i])) {
                chiffre = true;
            } else if (tab[i] >= 'a' && tab[i] <= 'z') {
                minus = true;
            } else if (tab[i] >= 'A' && tab[i] <= 'Z') {
                majus = true;
            }
        }

        if (!(chiffre && minus && majus)) {
            return true;
        }
        return false;
    }

    public boolean controleNumTelFormat(String chaine) {
        if (chaine.substring(0, 1) != "31" && chaine.charAt(0) != '2' && chaine.charAt(0) != '5' && chaine.charAt(0) != '9' && chaine.charAt(0) != '7') {
            return true;
        }
        return false;
    }
}
