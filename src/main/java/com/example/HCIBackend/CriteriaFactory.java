package com.example.HCIBackend;

public class CriteriaFactory {


    public ICriteria getCriteria(String criteria){

        if (criteria.equalsIgnoreCase("name"))
            return new CriteriaName();

        else if (criteria.equalsIgnoreCase("description"))
            return new CriteriaDescription();

        else if (criteria.equalsIgnoreCase("date"))
            return new CriteriaDate();

        else throw new RuntimeException("No valid criteria");
    }


}
