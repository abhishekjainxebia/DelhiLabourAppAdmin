package com.DelhiLabourWebAppAdmin.model;

import javax.persistence.*;

/**
 * @author abhishekjain on 30/3/18.
 */

@Entity
@Table(name="Annual_Return")
public class AnnualReturn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String act_name;

    private String UIN;

    private String factory_name;

    private String industry_nature;

    private String name_manager;

    private String name_occupier;

    private String postal_address;

    private String registration_number;

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public String getUIN() {
        return UIN;
    }

    public void setUIN(String UIN) {
        this.UIN = UIN;
    }

    public String getFactory_name() {
        return factory_name;
    }

    public void setFactory_name(String factory_name) {
        this.factory_name = factory_name;
    }

    public String getIndustry_nature() {
        return industry_nature;
    }

    public void setIndustry_nature(String industry_nature) {
        this.industry_nature = industry_nature;
    }

    public String getName_manager() {
        return name_manager;
    }

    public void setName_manager(String name_manager) {
        this.name_manager = name_manager;
    }

    public String getPostal_address() {
        return postal_address;
    }

    public void setPostal_address(String postal_address) {
        this.postal_address = postal_address;
    }

    public String getName_occupier() {
        return name_occupier;
    }

    public void setName_occupier(String name_occupier) {
        this.name_occupier = name_occupier;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }
}
