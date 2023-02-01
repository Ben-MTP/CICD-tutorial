package com.msoft.core.entity;

import java.util.LinkedHashMap;

/**
 * @author ManhKM on 1/29/2023
 * @project cicd-tutorial
 */
public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private LinkedHashMap<String, String> countryOptions;
    private String favoriteLanguage;
    private String[] operatingSystem;

    public Student(){
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("VN", "Viet Nam");
        countryOptions.put("CN", "China");
        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        // Chỉnh sửa lại việc khi truyền một CODE country vào thì trả về một NAME country
        this.country = countryOptions.get(country);
        System.out.println("    country selected: " + this.country);
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    /**
     * getOperatingSystem
     * Chuyển đổi danh sách String OperatingSystem thành một String phân biệt trong ký tự đặc biệt
     * Đồng thời loại bỏ kí tự cuối cùng cho ra format đẹp hơn
     * @return
     */
    public String getOperatingSystem() {
        StringBuilder resultOperatingSystem = new StringBuilder();
        for (String item: operatingSystem) {
            resultOperatingSystem.append(item).append(",");
        }
        if(resultOperatingSystem.length() > 1){
            int lastIndex = resultOperatingSystem.length() - 1;
            resultOperatingSystem.deleteCharAt(lastIndex);
        }

        return resultOperatingSystem.toString();
    }

    public void setOperatingSystem(String[] operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
