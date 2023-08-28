package com.azhar.catering.main;

import java.io.Serializable;

/**
 * Created by Azhar Rivaldi on 14-07-2023
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

public class ModelCategories implements Serializable {

    int iIcon;
    String strName;

    public ModelCategories(int iIcon, String strName) {
        this.iIcon = iIcon;
        this.strName = strName;
    }

    public int getiIcon() {
        return iIcon;
    }

    public void setiIcon(int iIcon) {
        this.iIcon = iIcon;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }
}
