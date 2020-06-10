package me.siduzy.ch02;

import edu.princeton.cs.algs4.Date;

import java.math.BigDecimal;

public class E010213 {

    public static class Transaction {
        private final String who;
        private final Date when;
        private final BigDecimal amount;


        public Transaction(String who, Date when, BigDecimal amount) {
            if (who == null || when == null || amount == null) {
                throw new IllegalArgumentException();
            }
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        public String getWho() {
            return who;
        }

        public Date getWhen() {
            return when;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return who + " - " + amount + " - " + when;
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) return true;
            if (other == null) return false;
            if (other.getClass() != this.getClass()) return false;
            Transaction that = (Transaction) other;
            return this.who.equals(that.who)
                    && this.when.equals(that.when)
                    && this.amount.equals(this.amount);
        }

        public static void main(String[] args) {
            Transaction transaction = new Transaction("Sid", new Date(1, 1, 2020), new BigDecimal("100.53"));
            System.out.println(transaction);
        }
    }
}
