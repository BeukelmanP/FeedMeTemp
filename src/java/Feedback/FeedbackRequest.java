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


    public String getImageFrom() {
        return imageFrom;
    }


    public int getIDto() {
        return IDto;
    }


    public int getIDFrom() {
        return IDFrom;
    }


    public String getNameTo() {
        return NameTo;
    }



    public String getNameFrom() {
        return NameFrom;
    }


}
