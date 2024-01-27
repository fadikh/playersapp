package org.players.players.entities;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Player {

    @Id
    @CsvBindByPosition(position = 0)
    private String playerID;

    @CsvBindByPosition(position = 1)
    private int birthYear;

    @CsvBindByPosition(position = 2)
    private int birthMonth;

    @CsvBindByPosition(position = 3)
    private int birthDay;

    @CsvBindByPosition(position = 4)
    private String birthCountry;

    @CsvBindByPosition(position = 5)
    private String birthState;

    @CsvBindByPosition(position = 6)
    private String birthCity;

    @CsvBindByPosition(position = 7)
    private int deathYear;

    @CsvBindByPosition(position = 8)
    private int deathMonth;

    @CsvBindByPosition(position = 9)
    private int deathDay;

    @CsvBindByPosition(position = 10)
    private String deathCountry;

    @CsvBindByPosition(position = 11)
    private String deathState;

    @CsvBindByPosition(position = 12)
    private String deathCity;

    @CsvBindByPosition(position = 13)
    private String nameFirst;

    @CsvBindByPosition(position = 14)
    private String nameLast;

    @CsvBindByPosition(position = 15)
    private String nameGiven;

    @CsvBindByPosition(position = 16)
    private int weight;

    @CsvBindByPosition(position = 17)
    private int height;

    @CsvBindByPosition(position = 18)
    private String bats;

    @CsvBindByPosition(position = 19)
    // @Column(name = "`throws`")
    private String throwsValue;

    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByPosition(position = 20)
    private Date date;

    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByPosition(position = 21)
    private Date finalGame;

    @CsvBindByPosition(position = 22)
    private String retroID;

    @CsvBindByPosition(position = 23)
    private String bbrefID;


    public Player() {}

    public Player(String playerID, int birthYear, int birthMonth, int birthDay, String birthCountry, String birthState,
        String birthCity, int deathYear, int deathMonth, int deathDay, String deathCountry, String deathState, String deathCity,
        String nameFirst, String nameLast, String nameGiven, int weight, int height, String bats, String throwsValue, Date date,
        Date finalGame, String retroID, String bbrefID) {
        this.playerID = playerID;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthCountry = birthCountry;
        this.birthState = birthState;
        this.birthCity = birthCity;
        this.deathYear = deathYear;
        this.deathMonth = deathMonth;
        this.deathDay = deathDay;
        this.deathCountry = deathCountry;
        this.deathState = deathState;
        this.deathCity = deathCity;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.nameGiven = nameGiven;
        this.weight = weight;
        this.height = height;
        this.bats = bats;
        this.throwsValue = throwsValue;
        this.date = date;
        this.finalGame = finalGame;
        this.retroID = retroID;
        this.bbrefID = bbrefID;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public int getDeathMonth() {
        return deathMonth;
    }

    public void setDeathMonth(int deathMonth) {
        this.deathMonth = deathMonth;
    }

    public int getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(int deathDay) {
        this.deathDay = deathDay;
    }

    public String getDeathCountry() {
        return deathCountry;
    }

    public void setDeathCountry(String deathCountry) {
        this.deathCountry = deathCountry;
    }

    public String getDeathState() {
        return deathState;
    }

    public void setDeathState(String deathState) {
        this.deathState = deathState;
    }

    public String getDeathCity() {
        return deathCity;
    }

    public void setDeathCity(String deathCity) {
        this.deathCity = deathCity;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getNameGiven() {
        return nameGiven;
    }

    public void setNameGiven(String nameGiven) {
        this.nameGiven = nameGiven;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBats() {
        return bats;
    }

    public void setBats(String bats) {
        this.bats = bats;
    }

    public String getThrowsValue() {
        return throwsValue;
    }

    public void setThrowsValue(String throwsValue) {
        this.throwsValue = throwsValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getFinalGame() {
        return finalGame;
    }

    public void setFinalGame(Date finalGame) {
        this.finalGame = finalGame;
    }

    public String getRetroID() {
        return retroID;
    }

    public void setRetroID(String retroID) {
        this.retroID = retroID;
    }

    public String getBbrefID() {
        return bbrefID;
    }

    public void setBbrefID(String bbrefID) {
        this.bbrefID = bbrefID;
    }
}
