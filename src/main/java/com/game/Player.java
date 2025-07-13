package com.game;
public class Player {
   private String name;
   private String email;
   private Player recipient;
   private Player sender;

   public Player(String name, String email) {
      this.name = name;
      this.email = email;
   }

   public String getName() {
      return name;
   }

   public String getEmail() {
      return email;
   }

   public boolean hasEmail() {
      return !email.equals("");
   }

   public boolean hasRecipient() {
      return recipient != null;
   }

   public String getRecipientName() {
      return recipient.getName();
   }

   public void setRecipient(Player recipient) {
      this.recipient = recipient;
   }

   public void resetRecipient() {
      this.recipient = null;
   }

   public boolean hasSender() {
      return sender != null;
   }

   public String getSenderName() {
      return sender.getName();
   }

   public void setSender(Player sender) {
      this.sender = sender;
   }

   public void resetSender() {
      this.sender = null;
   }
}