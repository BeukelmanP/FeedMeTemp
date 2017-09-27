/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Feedback;

/**
 *
 * @author piete
 */
public class FeedbackRequest {

    int IDto;
    int IDFrom;
    String NameTo;
    String NameFrom;
    String imageTo;
    String imageFrom;

    public FeedbackRequest(int IDFrom, int IDto, String NameFrom, String NameTo, String imageFrom, String imageTo) {
        this.IDto = IDto;
        this.IDFrom = IDFrom;
        this.NameTo = NameTo;
        this.NameFrom = NameFrom;
        this.imageFrom = imageFrom;
        this.imageTo = imageTo;
    }

    public String getImageTo() {
        return imageTo;
    }

    public void setImageTo(String imageTo) {
        this.imageTo = imageTo;
    }

    public String getImageFrom() {
        return imageFrom;
    }

    public void setImageFrom(String imageFrom) {
        this.imageFrom = imageFrom;
    }

    public int getIDto() {
        return IDto;
    }

    public void setIDto(int IDto) {
        this.IDto = IDto;
    }

    public int getIDFrom() {
        return IDFrom;
    }

    public void setIDFrom(int IDFrom) {
        this.IDFrom = IDFrom;
    }

    public String getNameTo() {
        return NameTo;
    }

    public void setNameTo(String NameTo) {
        this.NameTo = NameTo;
    }

    public String getNameFrom() {
        return NameFrom;
    }

    public void setNameFrom(String NameFrom) {
        this.NameFrom = NameFrom;
    }

}
