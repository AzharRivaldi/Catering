package com.azhar.catering.main;

/**
 * Created by Azhar Rivaldi on 17-07-2023
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

public class ModelTrending {

    int imgThumb;
    String tvPlaceName;
    String tvVote;

    public ModelTrending(int imgThumb, String tvPlaceName, String tvVote) {
        this.imgThumb = imgThumb;
        this.tvPlaceName = tvPlaceName;
        this.tvVote = tvVote;
    }

    public int getImgThumb() {
        return imgThumb;
    }

    public void setImgThumb(int imgThumb) {
        this.imgThumb = imgThumb;
    }

    public String getTvPlaceName() {
        return tvPlaceName;
    }

    public void setTvPlaceName(String tvPlaceName) {
        this.tvPlaceName = tvPlaceName;
    }

    public String getTvVote() {
        return tvVote;
    }

    public void setTvVote(String tvVote) {
        this.tvVote = tvVote;
    }
}
