package DAO;

import Model.Giftcard;
import Util.ConnectionUtil;
import org.apache.log4j.LogManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.FileHandler;
import java.util.logging.Logger;


public class GiftcardRepository {

    Logger logger = Logger.getLogger(String.valueOf(GiftcardRepository.class));

    Connection conn;

    public GiftcardRepository() throws SQLException {

        conn = ConnectionUtil.getConnection();

    }
    public List<Giftcard> getAllGiftcards() {
        List<Giftcard> allGiftcards = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From giftcards");
            while(rs.next()){
                Giftcard loadedGiftcard = new Giftcard(rs.getString("giftcardName"), rs.getInt("id"), rs.getString("description"), rs.getString("url"));
                allGiftcards.add(loadedGiftcard);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return allGiftcards;
    }
    public List<Giftcard> getAllGiftcardsByGiftID(int id) {
        List<Giftcard> giftcards = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("Select * from giftcards where id = ?");
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Giftcard loadedGiftcard = new Giftcard(rs.getString("giftcardName"), rs.getInt("id"), rs.getString("description"), rs.getString("url"));
                giftcards.add(loadedGiftcard);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
            return giftcards;
    }
    public void addGiftcard(Giftcard gc) {
        try {
            PreparedStatement statement = conn.prepareStatement("insert into giftcards(giftcardName, description, url)" + "values (?, ?, ?)");
            statement.setString(1, gc.getName());
            statement.setString(2, gc.getDescription());
            statement.setString(3, gc.getUrl());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Giftcard getGiftcardByName(String name) {
        //System.out.println(name);
        try {
            PreparedStatement statement = conn.prepareStatement("select * from giftcards where giftcardName = ?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Giftcard gc = new Giftcard(rs.getString("giftcardName"), rs.getInt("id"), rs.getString("description"), rs.getString("url"));
                return gc;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Giftcard> getAllGiftcardsByName(String name) {
        List<Giftcard> allGiftcards = new ArrayList<>();
        try {
            PreparedStatement statement = conn.prepareStatement("Select * From giftcards where giftcardName = ?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Giftcard loadedGiftcard = new Giftcard(rs.getString("giftcardName"), rs.getInt("id"), rs.getString("description"), rs.getString("url"));
                allGiftcards.add(loadedGiftcard);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("getting giftcards by name");
        return allGiftcards;
    }
    public Giftcard getDescriptionByName(String name) {
        try {
            PreparedStatement statement = conn.prepareStatement("Select * from giftcards where description = ?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Giftcard gc = new Giftcard(rs.getString("giftcardName"), rs.getInt("id"), rs.getString("description"), rs.getString("url"));
                return gc;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*public void deleteGiftcardByGiftID(int id) {
        try {
            PreparedStatement statement = conn.prepareStatement("delete from giftcards where id = ?)");
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }*/
}


// public void updateGiftcard(int id, Giftcard requestGiftcard) {}
